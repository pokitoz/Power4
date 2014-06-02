import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;

public class Board extends Canvas {

	private static final long serialVersionUID = -5066175705378237337L;
	private char[][] board = null;
	boolean redPlayer;

	private int count = 0;

	int heuristic = 0;

	final int pixelImg = 75;
	private static int numberOfColumns = 7;
	private static int numberOfLines = 6;

	public Board() {
		board = new char[numberOfLines][numberOfColumns];
		restart();
	}

	public Board(Board lastBoard, int col) {
		board = new char[numberOfLines][numberOfColumns];
		char[][] boardArray = lastBoard.getBoard();
		for (int i = 0; i < numberOfLines; i++) {
			for (int j = 0; j < numberOfColumns; j++) {

				if (boardArray[i][j] == 'X') {
					heuristic -= 1;
				} else if (boardArray[i][j] == 'O') {
					heuristic += 1;
				}

				board[i][j] = boardArray[i][j];
			}
		}

		redPlayer = lastBoard.redPlayer;
		putInColumn(col);
	}

	public void restart() {
		count = 0;
		for (int i = 0; i < numberOfLines; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				board[i][j] = ' ';
			}
		}
		redPlayer = true;
	}

	public boolean isDraw() {
		return (numberOfColumns * numberOfLines == count);
	}

	public char[][] getBoard() {
		return board.clone();
	}

	public ArrayList<Board> getChilds() {
		ArrayList<Board> childs = new ArrayList<>(7);

		return childs;
	}

	public boolean putInColumn(int col) {

		char playerSign = redPlayer ? 'O' : 'X';

		for (int i = numberOfLines - 1; i >= 0; i--) {
			if (board[i][col] == ' ') {
				board[i][col] = playerSign;
				// Change the player
				redPlayer = !redPlayer;
				count++;
				return true;
			}
		}

		return false;

	}

	public char getWinner() {

		for (int i = 0; i < numberOfLines; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				if (board[i][j] != ' ') {
					if (checkVertical(i, j, board[i][j])) {
						return board[i][j];
					}
					if (checkDiagonal(i, j, board[i][j])) {
						return board[i][j];
					}

					if (checkHorizontal(i, j, board[i][j])) {
						return board[i][j];
					}
				}
			}
		}
		return ' ';
	}

	private boolean checkVertical(int i, int j, char playerSign) {
		for (int line = i; line < 4 + i; line++) {
			if (line == numberOfLines || board[line][j] != playerSign) {
				return false;
			}
		}
		return true;

	}

	private boolean checkHorizontal(int i, int j, char playerSign) {
		for (int col = j; col < 4 + j; col++) {
			if (col == numberOfColumns || board[i][col] != playerSign) {
				return false;
			}
		}
		return true;
	}

	private boolean checkDiagonal(int i, int j, char playerSign) {
		return checkDiagonalUp(i, j, playerSign)
				|| checkDiagonalDown(i, j, playerSign);
	}

	private boolean checkDiagonalDown(int i, int j, char playerSign) {

		for (int line = i, col = j; col < 4 + j; line++, col++) {

			if (line == numberOfLines || col == numberOfColumns
					|| board[line][col] != playerSign) {
				return false;
			}

		}
		return true;
	}

	private boolean checkDiagonalUp(int i, int j, char playerSign) {

		for (int line = i, col = j; col < 4 + j; line--, col++) {

			if (line == -1 || col == numberOfColumns
					|| board[line][col] != playerSign) {
				return false;
			}

		}
		return true;
	}

	@Override
	public String toString() {
		String boardString = "";
		for (int i = 0; i < numberOfLines; i++) {
			boardString += "|";
			for (int j = 0; j < numberOfColumns; j++) {
				boardString += board[i][j];
			}
			boardString += "|\n";
		}

		return boardString;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < numberOfLines; i++) {
			for (int j = 0; j < numberOfColumns; j++) {

				if (board[i][j] == 'X') {
					g.drawImage(Main.jeton1, j * pixelImg, i * pixelImg, null);

				} else if (board[i][j] == 'O') {
					g.drawImage(Main.jeton2, j * pixelImg, i * pixelImg, null);

				} else {
					g.drawImage(Main.empty, j * pixelImg, i * pixelImg, null);
				}

			}

		}
	}

	public static int getNumberOfColumn() {
		return numberOfColumns;
	}

	public int width() {
		return numberOfColumns * pixelImg;
	}

	public int height() {
		return numberOfLines * pixelImg;
	}
}
