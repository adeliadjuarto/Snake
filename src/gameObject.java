import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class gameObject{
	protected int x, y;
	protected ID id;
	protected int velX, velY;
	
	public abstract void tick();
	public abstract void tick(int x,int y);
	public abstract void render(Graphics g);
	
	public abstract Rectangle getBounds();
	
	public void setX(int x){
		this.x = x;
	}
	public int getX(){
		return x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getY(){
		return y;
	}
	public void setID(ID id){
		this.id = id;
	}
	public ID getID(){
		return id;
	}
	public void setVelX(int velX){
		this.velX = velX;
	}
	public int getVelX(){
		return velX;
	}
	public void setVelY(int velY){
		this.velY = velY;
	}
	public int getVelY(){
		return velY;
	}
}
