import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Body extends gameObject {
	private game gm;
	private handler hdlr;
	
	public Body(int x, int y, ID id, game gm, handler hdlr){
		this.x = x;
		this.y = y;
		this.id = id;
		this.gm = gm;
		this.hdlr = hdlr;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 10, 10);
	}
	public void tick(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void tick() {
		x += velX;
		y += velY;
		
		collision();
	}
	
	// ???
	public void collision(){
		//collide with wall
		if(x <= -5 || x >= gm.width - 20 || y <= 0 || y >= gm.height - 50){
			x = 0;
			gm.gameState = STATE.Gameover;
		}
		
		gameObject head = hdlr.object.get(0);
		
		//collide with itself
		for(int i = 1; i < hdlr.object.size(); i++){
			gameObject temp = hdlr.object.get(i);
			
			if(head.getX() == temp.getX() && head.getY() == temp.getY()){
				gm.gameState = STATE.Gameover;
				break;
			}
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(x, y, 10, 10);
	}
}
