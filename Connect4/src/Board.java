
// Import packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JFrame {

    // Declare title variables
    private JLabel titleY;
    private JLabel titleR;
    private JLabel titleD;

    // Creating the board screen class
    public Board() {

        // Title the window
        super("Connect 4 | Game");

        // Setting up the JPanel
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {

                // Determining the dimensions of the board
                int panelWidth = getWidth();
                int panelHeight = getHeight();
                int x = (panelWidth - 860) / 2;
                int y = (panelHeight - 760) / 2;

                g.setColor(Colours.mainColour);
                g.fillRect(x, y, 860, 740);

                // Adding the red and yellow tokens to the board
                for (int r = 0; r < 6; r++) {
                    for (int c = 0; c < 7; c++) {

                        if (Game.getInstance().getBoard()[r][c] == 0) {
                            g.setColor(Color.WHITE);
                        } else if (Game.getInstance().getBoard()[r][c] == 1) {
                            g.setColor(Colours.red);
                        } else {
                            g.setColor(Colours.yellow);
                        }

                        g.fillOval(
                            x + 20 * (c + 1) + 100 * c,
                            y + 20 * (r + 1) + 100 * r,
                            100,
                            100
                        );
                    }
                }
            }
        };

        add(panel, BorderLayout.CENTER);

        // Setting up the title
        JPanel title = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // If there is no winner
        if (!Game.getInstance().isWinner()) {

            // If the game is not drawn
            if (!Game.getInstance().isDraw()) {

                // If it's Player 1's turn
                if (Game.getInstance().getTurn() % 2 == 1) {

                    // Formatting the Player 1's turn title
                    titleR = new JLabel();
                    titleR.setFont(new Font("SANS SERIF", Font.BOLD, 80));
                    titleR.setText("PLAYER 1'S TURN");
                    titleR.setForeground(Colours.red);
                    title.add(titleR);

                    // Changing the user's turn
                    Game.getInstance().setTurn(
                        Game.getInstance().getTurn() + 1
                    );

                } else {

                    // Formatting the Player 2's turn title
                    titleY = new JLabel();
                    titleY.setFont(new Font("SANS SERIF", Font.BOLD, 80));
                    titleY.setText("PLAYER 2'S TURN");
                    titleY.setForeground(Colours.yellow);
                    title.add(titleY);

                    // Changing the user's turn
                    Game.getInstance().setTurn(
                        Game.getInstance().getTurn() + 1
                    );
                }

                // Adding the column selector buttons
                JPanel buttonPanel = new JPanel(
                    new FlowLayout(FlowLayout.CENTER, 20, 0)
                );

                for (int i = 0; i < 7; i++) {

                    int columnNumber = i + 1;

                    // Create button builder
                    ButtonBuilder buttonBuilder =
                        new GameButtonBuilder("" + (i + 1));

                    // Create director
                    ButtonDirector director =
                        new ButtonDirector(buttonBuilder);

                    // Build the button
                    director.makeGameButton(
                        new Font("SANS SERIF", Font.BOLD, 50),
                        Colours.buttonbkgnd,
                        Color.BLACK,
                        new Dimension(100, 80)
                    );

                    // Get the button
                    JButton button = buttonBuilder.getButton();

                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            Game.getInstance().setColumnNumber(columnNumber);
                            dispose();
                        }
                    });

                    buttonPanel.add(button);
                }

                add(buttonPanel, BorderLayout.SOUTH);

            } else {

                // Formatting draw title
                titleD = new JLabel();
                titleD.setFont(new Font("SANS SERIF", Font.BOLD, 80));
                titleD.setText("DRAW");
                titleD.setForeground(Colours.heading);
                title.add(titleD);

                // Adding the exit button
                exitButton(50);

                // Updating stats
                Game.getInstance().setRecentWinner(0);
                Game.getInstance().incrementDraws();
            }

        } else {

            // If Player 1 won
            if ((Game.getInstance().getTurn() - 1) % 2 == 1) {

                // Formatting Player 1 win title
                titleR = new JLabel();
                titleR.setFont(new Font("SANS SERIF", Font.BOLD, 80));
                titleR.setText("PLAYER 1 WINS");
                titleR.setForeground(Colours.red);
                title.add(titleR);

                // Updating stats
                Game.getInstance().incrementP1wins();

                if (Game.getInstance().getRecentWinner() == 1
                        || Game.getInstance().getGamesPlayed() == 1) {

                    Game.getInstance().setStreak(
                        Game.getInstance().getStreak() + 1
                    );

                } else {
                    Game.getInstance().setStreak(1);
                }

                Game.getInstance().setRecentWinner(1);

            } else {

                // Formatting Player 2 win title
                titleY = new JLabel();
                titleY.setFont(new Font("SANS SERIF", Font.BOLD, 80));
                titleY.setText("PLAYER 2 WINS");
                titleY.setForeground(Colours.yellow);
                title.add(titleY);

                // Updating stats
                Game.getInstance().incrementP2wins();

                if (Game.getInstance().getRecentWinner() == 2
                        || Game.getInstance().getGamesPlayed() == 1) {

                    Game.getInstance().setStreak(
                        Game.getInstance().getStreak() + 1
                    );

                } else {
                    Game.getInstance().setStreak(1);
                }

                Game.getInstance().setRecentWinner(2);
            }

            // Adding the exit button
            exitButton(50);

            // Resetting variables
            Game.getInstance().setWinner(false);
            Game.getInstance().setTurn(1);
        }

        // Adding the title to the JFrame
        add(title, BorderLayout.NORTH);
    }

    // Add exit button
    private void exitButton(int size) {

        // Create button builder
        ButtonBuilder buttonBuilder =
            new GameButtonBuilder("EXIT");

        // Create director
        ButtonDirector director =
            new ButtonDirector(buttonBuilder);

        // Build the button
        director.makeGameButton(
            new Font("SANS SERIF", Font.BOLD, size),
            Colours.buttonbkgnd,
            Colours.mainColour,
            new Dimension(100, 80)
        );

        // Get the button
        JButton button = buttonBuilder.getButton();

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Return back to the main menu
                Main.main(null);

                // Close the board window
                dispose();
            }
        });

        add(button, BorderLayout.SOUTH);
    }
}