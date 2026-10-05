
//Import packages
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.Font;
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
		Icon ychip = new ImageIcon(new ImageIcon(getClass().getResource("yellowchip.png")).getImage()
				.getScaledInstance(400, 400, Image.SCALE_SMOOTH));
		Icon rchip = new ImageIcon(new ImageIcon(getClass().getResource("redchip.png")).getImage()
				.getScaledInstance(400, 400, Image.SCALE_SMOOTH));

		// Formatting the play button
		start = new JButton("PLAY", rchip);
		start.setForeground(Colours.heading);
		start.setRolloverIcon(rchip);
		start.setFont(new Font("SANS SERIF", Font.BOLD, 100));
		start.setVerticalTextPosition(SwingConstants.TOP);
		start.setHorizontalTextPosition(SwingConstants.CENTER);
		start.setBackground(Colours.buttonbkgnd);
		start.setBorderPainted(false);
		start.setFocusPainted(false);
		addHoverEffect(start, Colours.buttonbkgnd, Colours.buttononhover);

		// Adding a colour change when the start button is hovered
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

		// Formatting the stats button
		stats = new JButton("STATS", ychip);
		stats.setFont(new Font("SANS SERIF", Font.BOLD, 100));
		stats.setVerticalTextPosition(SwingConstants.TOP);
		stats.setHorizontalTextPosition(SwingConstants.CENTER);
		stats.setBackground(Colours.buttonbkgnd);
		stats.setBorderPainted(false);
		stats.setForeground(Colours.heading);
		stats.setFocusPainted(false);
		addHoverEffect(stats, Colours.buttonbkgnd, Colours.buttononhover);

		// Adding a colour change when the stats button is hovered
		stats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Creating an instance of the stats screen and closing the menu screen
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

}