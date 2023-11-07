package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import Resources.Images;
import javax.imageio.ImageIO;


import Main.GamePanel;
import Physics.Collision;
import gamestate.GameState;
import objects.Block;
import objects.MovingBlock;

public class Player {
	//booleanos para manejar los controles y los keylistener
	private boolean right= false,left= false, jumping = false, falling = false;
	private boolean topCollision= false;
	
	//posiciones y tamaño
	private double x,y;
	private int width,height;

	 // velocidad movimiento
	private double moveSpeed=2.5;
	
	//velocidad salto
	private double jumpSpeed =5;
	private double currentJumpSpeed =jumpSpeed;
	
	//velocidad caida
	private double maxFallSpeed=5;
	private double currentFallSpeed= 0.1;
	

	public Player(int width, int height) {
		// lo posiciona en el centro de la pantalla
		x= GamePanel.WIDTH/2+50;
		y=GamePanel.HEIGHT/2;
		this.width = width;
		this.height = height;
	
	}
	// el metodo tick se repite mucho, es la tasa de actualización en el juego. Actualiza los movimientos X cantidad de veces por segundo
	public void tick(Block[][] b, ArrayList<MovingBlock> movingBlocks) {
		
		//conversion de variables double a int para poder ser trabajadas
			int iX=(int)x;
			int iY= (int)y;
			
			//
			for(int i =0;i<b.length;i++) {
			for(int j =0;j<b[0].length;j++){
				
				if(b[i][j].getID()!=0) {
				
				//colision derecha
			if(Collision.playerBlock(new Point(iX+width+(int) GameState.xOffset,iY+ (int)GameState.yOffset+2), b[i][j])
					|| Collision.playerBlock(new Point(iX+width+(int) GameState.xOffset, iY+height+ (int)GameState.yOffset-1),b[i][j])) {
				right=false;
			}
			
			//colision izquierda
			
			if(Collision.playerBlock(new Point(iX+(int)GameState.xOffset-1,iY+(int)GameState.yOffset+2), b[i][j])
					|| Collision.playerBlock(new Point(iX+ (int)GameState.xOffset-1,iY+height+(int)GameState.yOffset-1), b[i][j])) {
				left= false;
			}
			
			//colision superior
			
			if(Collision.playerBlock(new Point(iX+(int)GameState.xOffset+1,iY+(int)GameState.yOffset),b[i][j])
					||Collision.playerBlock(new Point(iX+width+(int)GameState.xOffset-2,iY+(int)GameState.yOffset), b[i][j])) {
				jumping= false;
				falling= true;
			}
			
			//colision inferior
			if(Collision.playerBlock(new Point(iX+ (int)GameState.xOffset+2,iY+height+(int)GameState.yOffset+1),b[i][j])||
				Collision.playerBlock(new Point(iX+width+(int)GameState.xOffset-2,iY+height+(int)GameState.yOffset+1), b[i][j])) {
				
				y=b[i][j].getY()-height-GameState.yOffset;
				
				falling=false;
				topCollision= true;
			}else {
				if(!topCollision&& !jumping) {
					falling=true;
				}
				
			}
				}
			}
			
		}
			
			
			for(int i=0; i<movingBlocks.size();i++) {
				
				if(movingBlocks.get(i).getID()!= 0) {
					//colision derecha
					if(Collision.playerMovingBlock(new Point(iX+width+(int) GameState.xOffset,iY+ (int)GameState.yOffset+2), movingBlocks.get(i))
							|| Collision.playerMovingBlock(new Point(iX+width+(int) GameState.xOffset, iY+height+ (int)GameState.yOffset-1),movingBlocks.get(i))) {
						right=false;
					}
					
					//colision izquierda
					
					if(Collision.playerMovingBlock(new Point(iX+(int)GameState.xOffset-1,iY+(int)GameState.yOffset+2), movingBlocks.get(i))
							|| Collision.playerMovingBlock(new Point(iX+ (int)GameState.xOffset-1,iY+height+(int)GameState.yOffset-1), movingBlocks.get(i))) {
						left= false;
					}
					
					//colision superior
					
					if(Collision.playerMovingBlock(new Point(iX+(int)GameState.xOffset+1,iY+(int)GameState.yOffset),movingBlocks.get(i))
							||Collision.playerMovingBlock(new Point(iX+width+(int)GameState.xOffset-2,iY+(int)GameState.yOffset), movingBlocks.get(i))) {
						jumping= false;
						falling= true;
					}
					
					//colision inferior
					if(Collision.playerMovingBlock(new Point(iX+ (int)GameState.xOffset+2,iY+height+(int)GameState.yOffset+1),movingBlocks.get(i))||
						Collision.playerMovingBlock(new Point(iX+width+(int)GameState.xOffset-2,iY+height+(int)GameState.yOffset+1), movingBlocks.get(i))) {
						
						y=movingBlocks.get(i).getY()-height-GameState.yOffset;
						
						falling=false;
						topCollision= true;
						
						GameState.xOffset += movingBlocks.get(i).getMove();
						
					}else {
						if(!topCollision&& !jumping) {
							falling=true;
							
						}
						
					}
						}
				}
				
				
				
			
			
			
			
		topCollision= false;
		
		//movimiento hacia la derecha
if(right) {
			GameState.xOffset+= moveSpeed;
			
			
			
			//sprite derecha
			Images.spriteCounter++;


			if (Images.spriteCounter > 12) {
			    Images.spriteNum = (Images.spriteNum % 4) + 1;
			    Images.spriteCounter = 0;
			}
			
			
			
			
			
}
		//movimiento hacia la izquierda
if(left) {
			GameState.xOffset-=moveSpeed;
			
			//sprite izquierda
			
			/*Images.spriteCounter++;


			if (Images.spriteCounter > 12) {
			    Images.spriteNum = (Images.spriteNum % 4) + 1;
			    Images.spriteCounter = 0;
			}*/
			
			
			
}



	//salto y manejo de velocidad
if(jumping) {
	GameState.yOffset-=currentJumpSpeed;
	currentJumpSpeed-= .1;
	
	if(currentJumpSpeed<= 0) {
		
		currentJumpSpeed = jumpSpeed;
		jumping = false;
		falling =true;
	}
	

	//sprite salto
	
	/*Images.spriteCounter++;


	if (Images.spriteCounter > 12) {
	    Images.spriteNum = (Images.spriteNum % 4) + 1;
	    Images.spriteCounter = 0;
	}*/
	
	
	
}
//caida y velocidad de la misma
if(falling) {
	
	GameState.yOffset+=currentFallSpeed;
	if(currentFallSpeed<maxFallSpeed) {
		currentFallSpeed+=.1;
			}
}

if(!falling) {
	currentFallSpeed=.1;
	}








		






		

}
	
	// la parte anterior tambien verifica que no puedas hacer doble salto. 
	
	//Dibujo del jugador
	public void draw(Graphics g) {
		//g.setColor(Color.BLACK);
		//g.fillRect((int)x, (int)y, width, height);
		
	
		BufferedImage imagen= null;
		
		switch(Images.direction) {
		case "up":
			
			
			System.out.println(Images.direction);
			if(Images.spriteNum==1) {imagen =Images.right1;}
		
			if(Images.spriteNum==2) {imagen =Images.right2;}
			
			if(Images.spriteNum==3) {imagen =Images.right3;}
			
			if(Images.spriteNum==4) {imagen =Images.right4;}
			
			
		break;
		case "left":
			
			//if(Images.spriteNum==1) {imagen= Images.left1;}
		
		//break;
		case"right":
			//if(Images.spriteNum==1) {imagen=Images.right1;}
		
		break;
		
		
		}
		
		g.drawImage(imagen, (int)x, (int)y, width, height,null);
		
	}
	
	//Entrada del teclado
	public void keyPressed(int k) {
		if(k== KeyEvent.VK_RIGHT) right= true; Images.direction="right";
		if(k== KeyEvent.VK_LEFT) left= true;Images.direction="left";
		if(k== KeyEvent.VK_UP && !jumping && !falling) jumping = true;Images.direction="up";
	
		
		
	}
	//"Salida" del teclado, desactiva la presion de las teclas
	public void keyReleased (int k) {
		
		if(k== KeyEvent.VK_RIGHT) right= false; 
		if(k== KeyEvent.VK_LEFT) left= false;	
		
		
	}
	
	
	
	
}
