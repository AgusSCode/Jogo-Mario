package gamestate;


import java.awt.Graphics;
import java.util.Stack;

public class GameStateManager {
public Stack<GameState> states;
	public GameStateManager() {
		//states, son los diferentes niveles, ahora solo hay 1
	 states= new Stack<GameState>();
	states.push(new MenuState(this));
	
	
	}
	// todos estos metodos trabajan segun el LevelXState que haya. X representa el numero de nivel
	public void tick() {
		
		states.peek().tick();
	}
	
	
	public void draw(Graphics g) {
		states.peek().draw(g);
	}
	public void keyPressed(int k) {
		states.peek().keyPressed(k);
	}
	public void keyReleased (int k) {
		states.peek().keyReleased(k);
	}
	
	
	
	
	
}
