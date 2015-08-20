import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class keyInput extends KeyAdapter {
	private handler hdlr;
	private int vx, vy;
	private int v = 10;
	public keyInput(handler hdlr){
		this.hdlr = hdlr;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		gameObject tempObj = hdlr.object.get(0);

		if(tempObj.getID() == ID.Body){
			
			switch(key){
			//left
			case 37:
				if(tempObj.getVelX() != v){
					vx = -v;
					vy = 0;
				}
				break;
			//up
			case 38 :
				if(tempObj.getVelY() != v){
					vx = 0;
					vy = -v;
				}
				break;
			//right
			case 39:
				if(tempObj.getVelX() != -v){
					vx = v;
					vy = 0;
				}
				break;
			//down
			case 40:
				if(tempObj.getVelY() != -v){
					vx = 0;
					vy = v;
				}
				break;
			}
			
		}
		tempObj.setVelX(vx);
		tempObj.setVelY(vy);
	}
	public void keyReleased(KeyEvent e){
		
	}
}
