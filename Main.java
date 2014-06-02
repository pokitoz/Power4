import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Main {

	
	static BufferedImage jeton1 = null;
	static BufferedImage jeton2 = null;
	static BufferedImage empty = null;
	
	public static void main(String[] args) {

		try {
			jeton1 = ImageIO.read(new File("img" + File.separator
					+ "JETONBLUEfont.png"));
			jeton2 = ImageIO.read(new File("img" + File.separator
					+ "JETONREDfont.png"));
			empty = ImageIO.read(new File("img" + File.separator
					+ "JETONfont.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		Board b = new Board();
		GUIGame game = new GUIGame(b);
		JFrame frame = new JFrame();
		frame.setTitle("Puissance 4");
		frame.add(game);
		frame.setSize(600, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setVisible(true);
		System.out.println(b);

	}
}
