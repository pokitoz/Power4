import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUIGame extends JPanel implements MouseListener {

	private static final long serialVersionUID = -8903203546792274040L;

	private Board board = null;

	public GUIGame(Board board) {
		super(true);
		this.board = board;
		this.addMouseListener(this);
		setVisible(true);
	}

	final int adjustX = 10;
	final int adjustY = 33;

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D graphics2D = (Graphics2D) g;

		graphics2D.translate(adjustX, adjustY);
		graphics2D.setColor(Color.black);
		graphics2D.fillRect(0, 0, board.width(), board.height() + 50);

		graphics2D.setColor(Color.white);
		String player = board.redPlayer ? "Red" : "Blue";
		graphics2D.drawString("Current Player is " + player, 0,
				board.height() + 20);

		board.paint(graphics2D);
		System.out.println(board.width());

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

		int x = arg0.getX() - adjustX;
		for (int col = 0; col < Board.getNumberOfColumn(); col++) {
			if ((col * board.pixelImg) <= x && x <= (col * board.pixelImg + 75)) {
				board.putInColumn(col);
				repaint();
				char winner = board.getWinner();
				if (!(winner == ' ')) {
					String win = winner == 'X' ? "Blue" : "Red";
					JOptionPane.showMessageDialog(this, "Winner is " + win);
					board.restart();
					repaint();
				}
			}
		}

		if (board.isDraw()) {
			JOptionPane.showMessageDialog(this, "Draw");
			board.restart();
			repaint();
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}
