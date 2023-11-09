package gamestate;


import java.awt.Graphics;
 // es abstract, no puedo crear objetos en ella . Pero las demas pueden heredar de esta, es buena para la estructura de padre.
public abstract class GameState {

	protected GameStateManager gsm;
	public static double xOffset,yOffset;
	
	public GameState (GameStateManager gsm) {
		this.gsm=gsm;
		
		xOffset =0;
		yOffset=0;
		
		init();
	}
	public abstract void init();
	public abstract void tick();
	public abstract void draw(Graphics g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
	
}
