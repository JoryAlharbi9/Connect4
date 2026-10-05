//Import packages
import javax.swing.*;

public class Main {

	// Main class
	public static void main(String[] args) {

		// Reset board matrix and status using the Singleton instance
		Game.getInstance().resetBoard();

		// Open up the menu
		Home menu = new Home();
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setSize(1000, 1000);
		menu.setVisible(true);

	}

}
