package gamestate;

import java.awt.Graphics;

import entities.Player;
import mapping.Map;
import objects.Block;


public class Level2State extends GameState{

	
	private Player player;
	private Map map;
public Level2State(GameStateManager gsm){

	
	super(gsm);
	init();
}


public void init() {
	//Carga tamaño del jugador y el mapa a traves de su txt
	player = new Player(30,30);
	map= new Map("/Maps/map2.map");
	
	//Maneja el movimiento del fondo creando el efecto de que el jugador se mueve. Efecto Parallax
	xOffset= -250;
	yOffset= -240;



}
public void tick() {
	
	
	player.tick(map.getBlocks(),map.getMovingBlocks());
	map.tick();
	if(player.deadOrAlive()) {
		
		GameOverState.valor=2;
		//Hay que pasarle un valor para que GameOver sepa a cual reiniciar
		gsm.states.push(new GameOverState(gsm));
	}
	if(player.winGame()) {
		
		gsm.states.push(new GameWin(gsm));
	}
	
}


public void draw(Graphics g) {
	
	player.draw(g);
	map.draw(g);

}


public void keyPressed(int k) {
	player.keyPressed(k);
	
}


public void keyReleased(int k) {
	player.keyReleased(k);
	
	
}
	
	
	
	
	
	
	
	
	
	
	
}