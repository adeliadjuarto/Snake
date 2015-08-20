import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Food extends gameObject{
	Random r = new Random();
	
	public Food(ID id){
		generateRand();
	}
	public Rectangle getBounds(){
		return new Rectangle(x, y, 10, 10);
	}
	public void generateRand(){
		x = r.nextInt(game.width/5 - 1) * 5 + 5;
		y = r.nextInt(game.height/5 - 1) * 5 + 5;
	}
	public void tick() {
		generateRand();
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 5, 5);
	}
	public void tick(int x, int y) {
	}
	
}
