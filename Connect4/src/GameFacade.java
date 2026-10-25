import javax.swing.*;

public class GameFacade {

    // Open the main menu
    public void showHome(JFrame currentWindow) {
        Game.getInstance().resetBoard();
        openWindow(new Home());
        if (currentWindow != null) {
            currentWindow.dispose();
        }
    }

    // Start a new game
    public void startGame(JFrame currentWindow) {
        openWindow(new Board());
        currentWindow.dispose();
        Game.getInstance().incrementGamesPlayed();
    }

    // Open the statistics screen
    public void showStats(JFrame currentWindow) {
        openWindow(new Stats());
        currentWindow.dispose();
    }

    // Redraw the board after a move
    public void refreshBoard() {
        openWindow(new Board());
    }

    // Shared window setup, written once
    private void openWindow(JFrame window) {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1000, 1000);
        window.setVisible(true);
    }
}