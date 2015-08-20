
public class box {
	private int width = game.width/50;
	private int height = width;
	private int posX;
	private int posY;
	private TYPE type;
	
	
	public box(int posX, int posY, TYPE type){
		this.posX = posX;
		this.posY = posY;
		this.type = type;
	}
	public int getPosX(){
		return posX;
	}
	public int getPosY(){
		return posY;
	}
	public TYPE getType(){
		return type;
	}
}
