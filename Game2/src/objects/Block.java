package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Resources.Images;
import gamestate.GameState;

public class Block extends Rectangle{
	private static final long serialVersionUID = 1L;
public static final int blockSize= 64;
	private int id;
	
	//El id es el responsable de informar sobre el estado del bloque, si es pisable o no
	public Block(int x, int y,int id) {
		
		setBounds(x,y,blockSize,blockSize);
		this.id=id;
	}
	
	public void tick() {
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		if(id==1) {
			// se asigna a todos los bloques visibles la imagen de la clase Images
		g.drawImage(Images.blocks[id-1],x-(int)GameState.xOffset,y-(int)GameState.yOffset,width,height,null);
		}
		if(id==2) {
			// se asigna a todos los bloques visibles la imagen de la clase Images
		g.drawImage(Images.blocks[id-1],x-(int)GameState.xOffset,y-(int)GameState.yOffset,width,height,null);
		}
		if(id==3) {
			// se asigna a todos los bloques visibles la imagen de la clase Images
		g.drawImage(Images.blocks[id-1],x-(int)GameState.xOffset,y-(int)GameState.yOffset,width,height,null);
		}
		
	}
	
	//getters and setters. 
	public void setID(int id) {
		
		this.id=id;
	}
	public int getID() {
		return id;
	}
	
	
}
