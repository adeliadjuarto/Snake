import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class game extends Canvas implements Runnable{
	private static final long serialVersionUID = -453522247051845779L;
	public static final int width = 640, height = width/12*9;
	
	private Thread thread;
	private boolean running = false;
	
	private handler hdlr;
	private HUD hud;
	private Menu menu;
	
	public STATE gameState = STATE.Menu;
	
	public game(){
		hud = new HUD();
		hdlr = new handler(this, hud);
		menu = new Menu(this, hdlr, hud);
		
		this.addKeyListener(new keyInput(hdlr));
		this.addMouseListener(menu);
		
		new window(width,height,"Snake", this);	
	}
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void run(){
		this.requestFocus();
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 10.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) /ns;
			lastTime = now;
			
			while(delta >= 1){
				tick();
				delta--;
			}
		
			if(running){
				render();
			}
			frames++;
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS : "+frames);
				frames = 0;
			}
		}
		stop();
	}
	private void tick(){
		hdlr.tick();
	}
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		
		hdlr.render(g);
		if(gameState == STATE.Game){
			hud.render(g);
		}else if(gameState == STATE.Menu || gameState == STATE.Gameover){
			menu.render(g);
		}
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		new game();
	}
}
