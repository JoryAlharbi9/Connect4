
// ************************ MY REPO ************************
//Import packages
import java.util.*;
import javax.swing.JFrame;

public class Game {

	// 1- Singleton Instance Variable
	private static Game instance;

	// 2- Private Game Variables (Encapsulation)
	private int turn = 1;
	private boolean winner = false;
	private int streak = 0;
	private int recentWinner = 0;
	private boolean draw = false;
	private int[][] board = new int[6][7];
	private int p1wins = 0;
	private int p2wins = 0;
	private int draws = 0;
	private int gamesPlayed = 0;

	// 3- Private Constructor
	private Game() { }

	// 4- Global Access Point
	public static Game getInstance() {
		if (instance == null) {
			instance = new Game();
		}
		return instance;
	}

	// 5- Getters and Setters
	public int getTurn() { return turn; }
	public void setTurn(int turn) { this.turn = turn; }

	public boolean isWinner() { return winner; }
	public void setWinner(boolean winner) { this.winner = winner; }

	public int getStreak() { return streak; }
	public void setStreak(int streak) { this.streak = streak; }

	public int getRecentWinner() { return recentWinner; }
	public void setRecentWinner(int recentWinner) { this.recentWinner = recentWinner; }

	public boolean isDraw() { return draw; }
	public void setDraw(boolean draw) { this.draw = draw; }

	public int[][] getBoard() { return board; }
	public void setBoard(int[][] board) { this.board = board; }

	public int getP1wins() { return p1wins; }
	public void incrementP1wins() { this.p1wins++; }

	public int getP2wins() { return p2wins; }
	public void incrementP2wins() { this.p2wins++; }

	public int getDraws() { return draws; }
	public void incrementDraws() { this.draws++; }

	public int getGamesPlayed() { return gamesPlayed; }
	public void incrementGamesPlayed() { this.gamesPlayed++; }

	// reset the board matrix for a new game
	public void resetBoard() {
		this.board = new int[6][7];
		this.winner = false;
		this.draw = false;
		this.turn = 1;
	}

	// User makes a turn class
	public void setColumnNumber(int col) {

		// Checking if turn is valid
		col -= 1;
		boolean validTurn = false;
		for (int i = 5; i > -1; i--) {

			// If the space is empty
			if (board[i][col] == 0) {
				// Turn is valid
				validTurn = true;

				// Player 1's token
				if (turn % 2 == 0 || turn == 1) {
					board[i][col] = 1;
				}

				// Player 2's token
				else {
					board[i][col] = 2;
				}
				break;
			}
		}

		// If an invalid turn, redo the move
		if (!validTurn) {
			turn -= 1;
		}

		// Check if someone has won
		checkForWin();

		// Check for draw circumstance
		if (!winner && turn == 43) {
			draw = true;
		}

		// Set up a new board after turn and close the old window
		Board boardWindow = new Board();
		boardWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boardWindow.setSize(1000, 1000);
		boardWindow.setVisible(true);

	}

	// Check if someone has won class
	private void checkForWin() {
		// Vertical check
		for (int c = 0; c < 7; c++) {
			for (int r = 0; r < 3; r++) {
				if (board[r][c] != 0 && board[r][c] == board[r + 1][c] && board[r][c] == board[r + 2][c]
						&& board[r][c] == board[r + 3][c]) {
					winner = true;
				}
			}
		}

		// Horizontal check
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 4; c++) {
				if (board[r][c] != 0 && board[r][c] == board[r][c + 1] && board[r][c] == board[r][c + 2]
						&& board[r][c] == board[r][c + 3]) {
					winner = true;
				}
			}
		}

		// Diagonal, bottom right to top left, check
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 4; col++) {
				if (board[row][col] != 0 && board[row][col] == board[row + 1][col + 1]
						&& board[row][col] == board[row + 2][col + 2] && board[row][col] == board[row + 3][col + 3]) {
					winner = true;
				}
			}
		}

		// Diagonal, bottom left to top right, check
		for (int r = 3; r < 6; r++) {
			for (int c = 0; c < 4; c++) {
				if (board[r][c] != 0 && board[r][c] == board[r - 1][c + 1] && board[r][c] == board[r - 2][c + 2]
						&& board[r][c] == board[r - 3][c + 3]) {
					winner = true;
				}
			}
		}

	}

}