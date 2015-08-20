import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter{
	private handler hdlr;
	private game gm;
	private HUD hud;
	
	private int mx, my;
	
	public Menu(game gm, handler hdlr, HUD hud){
		this.gm = gm;
		this.hdlr = hdlr;
		this.hud = hud;
	}
	
	public void mousePressed(MouseEvent e){
		mx = e.getX();
		my = e.getY();
		
		if(gm.gameState == STATE.Menu){
			if(mouseOver(mx, my, 210, 150, 200, 64)){
				while (!hdlr.object.isEmpty()) {
			        hdlr.object.removeFirst();
			    }
				hud.setScore(0);
				
				hdlr.addFood(new Food(ID.Food));
				hdlr.addObject(new Body(gm.width/2-32, gm.height/2-32, ID.Body, gm, hdlr));
				
				gm.gameState = STATE.Game;	
			}
			else if(mouseOver(mx, my, 210, 250, 200, 64)){
				System.exit(1);
			}
		}
		else if(gm.gameState == STATE.Gameover){
			if(mouseOver(mx, my, 240, 300, 135, 50)){
				//hdlr.removeObject();
				
				
				gm.gameState = STATE.Menu;
			}
		}
	}
	
	public void mouseReleased(MouseEvent e){
	}
	
	public boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if((mx > x && mx < x + width) && (my > y && my < y + height)){
			return true;
		}else{
			return false;
		}
	}
	
	public void tick(){
		
	}
	public void render(Graphics g){
		Font font = new Font("Arial", 1, 50);
		Font font2 = new Font("Arial", 1, 30);
		g.setColor(Color.white);
		g.setFont(font);
		if(gm.gameState == STATE.Menu){
			g.drawString("Menu", 245, 80);
			
			g.setFont(font2);
			
			g.drawRect(210, 150, 200, 64);
			g.drawString("Play", 270, 193);
			
			g.drawRect(210, 250, 200, 64);
			g.drawString("Quit", 270, 293);
		}
		else if(gm.gameState == STATE.Gameover){		
			g.setFont(font);
			g.drawString("Game Over", 180, 200);
			
			g.setFont(font2);
			g.drawString("Score : "+ hud.getScore(), 240, 250);
			
			g.drawRect(240, 300, 135, 50);
			g.setColor(Color.red);
			g.drawString("Retry", 265, 335);
		}
	}
}
