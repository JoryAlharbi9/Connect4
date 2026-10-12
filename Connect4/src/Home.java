// Import packages
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame {

    // Declare variables for the menu
    private JLabel title;
    private JButton start;
    private JButton stats;
    private JPanel buttonPanel;

    // Creating the home screen class
    public Home() {

        // Title the window
        super("Connect 4 | Home");

        // Setting up a new layout
        setLayout(new FlowLayout());

        // Adding and formatting the title
        title = new JLabel();
        title.setFont(new Font("SANS SERIF", Font.BOLD, 160));
        title.setText("CONNECT 4");
        title.setForeground(Colours.mainColour);
        add(title, BorderLayout.NORTH);

        // Declaring the button layout
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));

        // Creating icons by referencing png files
        Icon ychip = new ImageIcon(
            new ImageIcon(getClass().getResource("yellowchip.png"))
                .getImage()
                .getScaledInstance(400, 400, Image.SCALE_SMOOTH)
        );

        Icon rchip = new ImageIcon(
            new ImageIcon(getClass().getResource("redchip.png"))
                .getImage()
                .getScaledInstance(400, 400, Image.SCALE_SMOOTH)
        );

        // Build the play button
        ButtonBuilder startBuilder = new GameButtonBuilder("PLAY");
        ButtonDirector startDirector = new ButtonDirector(startBuilder);

        startDirector.makeMenuButton(
            new Font("SANS SERIF", Font.BOLD, 100),
            Colours.buttonbkgnd,
            Colours.heading,
            rchip
        );

        // Get the play button
        start = startBuilder.getButton();

        // Play button action
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Creating a game and closing the menu screen
                Board board = new Board();
                board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                board.setSize(1000, 1000);
                board.setVisible(true);
                dispose();

                Game.getInstance().incrementGamesPlayed();
            }
        });

        // Build the stats button
        ButtonBuilder statsBuilder = new GameButtonBuilder("STATS");
        ButtonDirector statsDirector = new ButtonDirector(statsBuilder);

        statsDirector.makeMenuButton(
            new Font("SANS SERIF", Font.BOLD, 100),
            Colours.buttonbkgnd,
            Colours.heading,
            ychip
        );

        // Get the stats button
        stats = statsBuilder.getButton();

        // Stats button action
        stats.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Creating an instance of the stats screen
                Stats gameStats = new Stats();
                gameStats.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameStats.setSize(1000, 1000);
                gameStats.setVisible(true);
                dispose();
            }
        });

        // Adding the buttons to the screen
        buttonPanel.add(start);
        buttonPanel.add(stats);
        add(buttonPanel, BorderLayout.CENTER);
    }

}