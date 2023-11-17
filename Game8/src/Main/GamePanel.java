package Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import Resources.Images;
import gamestate.GameStateManager;
public class GamePanel extends JPanel implements Runnable, KeyListener{
	
	private static final long serialVersionUID = 1L;
	public static Image fondoImagen;

//tamaño frame

public static final int WIDTH =800;
public static final int HEIGHT= 736;

private Thread thread;
private boolean isRunning=false;

private int FPS=60;
private long targetTime = 1000/FPS;

private GameStateManager gsm;

public GamePanel() {
	setPreferredSize(new Dimension(WIDTH,HEIGHT));
	addKeyListener(this);
	setFocusable(true);
	new Images();
	start();
}



private void start() {
	// el thread es el responsable del Inicio,actualización,renderizado y gestion de eventos del juego. 
	isRunning=true;
	thread= new Thread(this);
	thread.start();
}

public void run() {
	long start, elapsed,wait;
	
	gsm = new GameStateManager();
	// esta parte se encarga de hacer que el juego vaya a 60 fps
	while(isRunning) {
		start = System.nanoTime();
		tick();
		repaint();
		elapsed = System.nanoTime() - start;
		wait = targetTime - elapsed /1000000;
		if(wait<0) {
			wait=5;
		}
		try { Thread.sleep(wait);}
		catch(Exception e){
			e.printStackTrace();
		
		}
		
	}
}

//Actualizacion a traves de la clase GameStateManager
public void tick() {
	gsm.tick();
	
}
public void paintComponent(Graphics g) {
	super.paintComponent(g);
	//g.clearRect(0, 0, WIDTH, HEIGHT);
	g.drawImage(fondoImagen, 0, 0, WIDTH, HEIGHT, this);
	//g.fillRect(0, 0, WIDTH, HEIGHT);
	// g.drawImage(fondoimagen, 0, 0, getWidth(),getHeight(),this);
	gsm.draw(g);
}



public void keyTyped(KeyEvent e) {}



public void keyPressed(KeyEvent e) {
	
	gsm.keyPressed(e.getKeyCode());
}


public void keyReleased(KeyEvent e) {
	gsm.keyReleased(e.getKeyCode());
}


}













