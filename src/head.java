import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class head extends gameObject{
	private game gm;
	private handler hdlr;
	
	public head(int x, int y, ID id, game gm, handler hdlr){
		this.x = x;
		this.y = y;
		this.id = id;
		this.gm = gm;
		this.hdlr = hdlr;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 10, 10);
	}
	public void collision(){
		//collide with wall
		if(x <= 0 || x >= gm.width - 20 || y <= 0 || y >= gm.height - 50){
			x = 0;
			gm.gameState = STATE.Gameover;
		}
		
		gameObject head = hdlr.object.get(0);
		
		//collide with itself (not done)
		for(int i = 1; i < hdlr.object.size(); i++){
			gameObject temp = hdlr.object.get(i);
			
			/*if(head.getBounds().intersects(temp.getBounds())){
				gm.gameState = STATE.Gameover;
				break;
			}*/
		}
	}
	public void tick() {
		x += velX;
		y += velY;
		
		collision();
	}
	public void tick(int x, int y) {}
	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.drawRect(x, y, 10, 10);
	}
	
}
