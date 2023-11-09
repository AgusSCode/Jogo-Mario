package Resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
//Carga las imagenes segun el tipo de bloque
	public static BufferedImage[] blocks;
	public static BufferedImage breathL1,breathL2,breathL3,breathL4,breathR1, breathR2, breathR3, breathR4,up1R,up2R,up3R,up4R,up5R,up1L,up2L,up3L,up4L,up5L,left1,left2,left3,left4,right1,right2,right3,right4;
	public static String direction="right"; 
	
	public static int spriteCounter=0;
	public static int spriteNum= 1;
	
	public Images() {
		blocks= new BufferedImage[1];
		try {
// Para logica de respirar derecha/izquierda, hcaer un booleano para tener registrado el ultimo ingreso por teclado, para saber para que lado debe respirar
			right1 = ImageIO.read(getClass().getResourceAsStream("/Player/CaminaDerecha1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/Player/CaminaDerecha2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/Player/CaminaDerecha3.png"));
			right4 = ImageIO.read(getClass().getResourceAsStream("/Player/CaminaDerecha4.png"));
			
			
			//Izquierda
			left1 = ImageIO.read(getClass().getResourceAsStream("/Player/CaminaIzquierda1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/Player/CaminaIzquierda2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/Player/CaminaIzquierda3.png"));
			left4 = ImageIO.read(getClass().getResourceAsStream("/Player/CaminaIzquierda4.png")); 
			
			// saltarDerecha
			
			  
			 up1R = ImageIO.read(getClass().getResourceAsStream("/Player/SaltarDerecha1.png"));
			 up2R = ImageIO.read(getClass().getResourceAsStream("/Player/SaltarDerecha2.png"));
			 up3R = ImageIO.read(getClass().getResourceAsStream("/Player/SaltarDerecha3.png"));
			 up4R = ImageIO.read(getClass().getResourceAsStream("/Player/SaltarDerecha4.png"));
			 up5R = ImageIO.read(getClass().getResourceAsStream("/Player/SaltarDerecha5.png"));
			  
			  
			
			// saltarIzquierda
						
						  
						 up1L = ImageIO.read(getClass().getResourceAsStream("/Player/SaltarIzquierda1.png"));
						 up2L = ImageIO.read(getClass().getResourceAsStream("/Player/SaltarIzquierda2.png"));
						 up3L = ImageIO.read(getClass().getResourceAsStream("/Player/SaltarIzquierda3.png"));
						 up4L = ImageIO.read(getClass().getResourceAsStream("/Player/SaltarIzquierda4.png"));
						 up5L = ImageIO.read(getClass().getResourceAsStream("/Player/SaltarIzquierda5.png"));
						  
						  
			
			
			//Respira
			
			
			breathR1 = ImageIO.read(getClass().getResourceAsStream("/Player/RespirarDerecha1.png")); // este es el chico
			breathR2 = ImageIO.read(getClass().getResourceAsStream("/Player/RespirarDerecha2.png")); //respira1.png es el grande
			breathR3 = ImageIO.read(getClass().getResourceAsStream("/Player/RespirarDerecha3.png"));
			breathR4 = ImageIO.read(getClass().getResourceAsStream("/Player/RespirarDerecha4.png"));
			  
			
		
			breathL1 = ImageIO.read(getClass().getResourceAsStream("/Player/RespirarIzquierda1.png")); // este es el chico
			breathL2 = ImageIO.read(getClass().getResourceAsStream("/Player/RespirarIzquierda2.png")); //respira1.png es el grande
			breathL3 = ImageIO.read(getClass().getResourceAsStream("/Player/RespirarIzquierda3.png"));
			breathL4 = ImageIO.read(getClass().getResourceAsStream("/Player/RespirarIzquierda4.png"));
			  
			
			
			blocks[0]= ImageIO.read(getClass().getResourceAsStream("/Blocks/block_brick.png"));
		} catch (IOException e) {
		
			e.printStackTrace();
		}	
	}
}
