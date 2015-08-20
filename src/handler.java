import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;

public class handler{
	LinkedList<gameObject> object = new LinkedList<gameObject>();
	gameObject food;
	private HUD hud;
	private game gm;
	
	public handler(game gm, HUD hud){
		this.hud = hud;
		this.gm = gm;
	}
	
	public void tick(){
		if(gm.gameState == STATE.Game){
			//update position
			for(int i = object.size() - 1; i >= 1; i--){
				gameObject tempObject = object.get(i);
				gameObject tempObject2 = object.get(i-1);
				tempObject.tick(tempObject2.getX(), tempObject2.getY());
			}
			gameObject head = object.get(0);
			head.tick();
			
			//if food eaten
			if(head.getBounds().intersects(food.getBounds())){
				//new food position
				food.tick();
		
				hud.setScore(hud.getScore()+10);
				
				//add snake length
				this.object.add(new Body(head.getX(), head.getY(), ID.Body, gm, this));
				this.object.add(new Body(head.getX(), head.getY(), ID.Body, gm, this));
				this.object.add(new Body(head.getX(), head.getY(), ID.Body, gm, this));
				this.object.add(new Body(head.getX(), head.getY(), ID.Body, gm, this));
				this.object.add(new Body(head.getX(), head.getY(), ID.Body, gm, this));
				this.object.add(new Body(head.getX(), head.getY(), ID.Body, gm, this));
			}
		}
	}
	public void render(Graphics g){
		if(gm.gameState == STATE.Game){
			for(int i = 0; i < object.size(); i++){
				gameObject tempObject = object.get(i);
				
				tempObject.render(g);
			}
			food.render(g);
		}
	}
	public void addFood(gameObject food){
		this.food = food;
	}
	public void addObject(gameObject object){
		this.object.add(object);
	}
	public void removeObject(gameObject object){
		this.object.remove(object);
	}
}
