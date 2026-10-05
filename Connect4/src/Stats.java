
//Import packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Stats extends JFrame {

	// Display stats class
	public Stats() {

		// Adding the title to the window
		super("Connect 4 | Stats");

		// Determining the streak
		String streakstr = "";
		if (Game.getInstance().getStreak() == 0) {
			streakstr = "STREAK: 0";
		} else {
			streakstr = "STREAK: " + Game.getInstance().getStreak() + " (P" + Game.getInstance().getRecentWinner() + ")";
		}

		// Creating the stats layout
		setLayout(new GridLayout(6, 1));
		createStats(streakstr);

		// Adding the exit button
		exitButton(85);

	}

	// Hovering button effect class
	private void addHoverEffect(JButton button, Color originalColour, Color hoverColour) {
		button.addMouseListener(new java.awt.event.MouseAdapter() {
			// When the cursor enters the button
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				// Change the colour of the button to a lighter colour
				button.setBackground(hoverColour);
			}

			// When the cursor exits the button
			public void mouseExited(java.awt.event.MouseEvent evt) {
				// Revert the colour of the button to the original colour
				button.setBackground(originalColour);
			}
		});
	}

	// Creating the stats class
	private void createStats(String streakstr) {

		// Declaring the stats' labels
		JLabel p1WinsLabel = new JLabel("P1 WINS: " + Game.getInstance().getP1wins(), SwingConstants.CENTER);
		JLabel p2WinsLabel = new JLabel("P2 WINS: " + Game.getInstance().getP2wins(), SwingConstants.CENTER);
		JLabel streakLabel = new JLabel(streakstr, SwingConstants.CENTER);
		JLabel drawsLabel = new JLabel("DRAWS: " + Game.getInstance().getDraws(), SwingConstants.CENTER);
		JLabel gamesPlayedLabel = new JLabel("GAMES PLAYED: " + Game.getInstance().getGamesPlayed(), SwingConstants.CENTER);

		// Adding and formatting the stats
		p1WinsLabel.setFont(new Font("Arial", Font.BOLD, 85));
		p1WinsLabel.setForeground(Colours.red);
		p2WinsLabel.setFont(new Font("Arial", Font.BOLD, 85));
		p2WinsLabel.setForeground(Colours.yellow);
		streakLabel.setFont(new Font("Arial", Font.BOLD, 85));
		streakLabel.setForeground(Colours.orange);
		drawsLabel.setFont(new Font("Arial", Font.BOLD, 85));
		drawsLabel.setForeground(Colours.buttonbkgnd);
		gamesPlayedLabel.setFont(new Font("Arial", Font.BOLD, 85));
		gamesPlayedLabel.setForeground(Colours.mainColour);
		add(p1WinsLabel);
		add(p2WinsLabel);
		add(streakLabel);
		add(drawsLabel);
		add(gamesPlayedLabel);
	}

	// Add exit button class
	private void exitButton(int size) {

		// Adding and formatting exit button
		JButton button = new JButton("EXIT");
		button.setFont(new Font("SANS SERIF", Font.BOLD, size));
		button.setForeground(Colours.mainColour);
		button.setBorderPainted(false);
		button.setBackground(Colours.buttonbkgnd);
		addHoverEffect(button, Colours.buttonbkgnd, Colours.buttononhover);
		button.setFocusPainted(false);
		button.setPreferredSize(new Dimension(100, 80));
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