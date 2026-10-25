import javax.swing.*;

public class GameFacade {

    // Start a new game
    public void startGame(JFrame currentWindow) {

        // Create the game board
        Board board = new Board();

        // Configure the board window
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setSize(1000, 1000);
        board.setVisible(true);

        // Close the current window
        currentWindow.dispose();

        // Update game statistics using Singleton
        Game.getInstance().incrementGamesPlayed();
    }

    // Open the statistics screen
    public void showStats(JFrame currentWindow) {

        // Create the statistics screen
        Stats gameStats = new Stats();

        // Configure the statistics window
        gameStats.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameStats.setSize(1000, 1000);
        gameStats.setVisible(true);

        // Close the current window
        currentWindow.dispose();
    }
}
