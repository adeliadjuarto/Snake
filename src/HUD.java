import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	private int score = 0;
	public void tick(){
	}
	public void render(Graphics g){
		g.setColor(Color.white);
		g.drawString("Score : "+ score , 20, 20);
	}
	public void setScore(int score){
		this.score = score;
	}
	public int getScore(){
		return score;
	}
}
