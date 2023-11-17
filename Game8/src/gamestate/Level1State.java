package gamestate;

import java.awt.Graphics;



import entities.Player;
import mapping.Map;
import objects.Block;
import entities.Player;


public class Level1State extends GameState{

	
	private Player player;
	private Map map;
public Level1State(GameStateManager gsm){

	
	super(gsm);
	init();
}


public void init() {
	//Carga tamaño del jugador y el mapa a traves de su txt
	player = new Player(30,30);
	map= new Map("/Maps/map1.map");
	
	//Maneja el movimiento del fondo creando el efecto de que el jugador se mueve. Efecto Parallax
	xOffset= 200;
	yOffset=100;

	


}
public void tick() {
	
	
	player.tick(map.getBlocks(),map.getMovingBlocks());
	map.tick();
	
}


public void draw(Graphics g) {
	
	player.draw(g);
	map.draw(g);
	if(player.winGame()) {
		
		gsm.states.push(new GameWin(gsm));
	}

}


public void keyPressed(int k) {
	player.keyPressed(k);
	
}


public void keyReleased(int k) {
	player.keyReleased(k);
	
	
}
	
	
	
	
	
	
	
	
	
	
	
}