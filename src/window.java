import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class window extends Canvas{
	private static final long serialVersionUID = -5685241566656015950L;

	public window(int width,int height, String title, game game){
		JFrame f = new JFrame(title);
		
		f.setPreferredSize(new Dimension(width,height));
		f.setMaximumSize(new Dimension(width,height));
		f.setMinimumSize(new Dimension(width,height));
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.add(game);
		f.setVisible(true);
		game.start();
	}
}
