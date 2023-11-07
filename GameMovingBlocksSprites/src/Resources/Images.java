package Resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
//Carga las imagenes segun el tipo de bloque
	public static BufferedImage[] blocks;
	public static BufferedImage up1,up2,down1,down2,left1,left2,right1,right2,right3,right4;
	public static String direction="up"; 
	
	public static int spriteCounter=0;
	public static int spriteNum= 1;
	
	public Images() {
		blocks= new BufferedImage[1];
		try {

			right1 = ImageIO.read(getClass().getResourceAsStream("/Player/CaminaDerecha1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/Player/CaminaDerecha2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/Player/CaminaDerecha3.png"));
			right4 = ImageIO.read(getClass().getResourceAsStream("/Player/CaminaDerecha4.png"));
		
		
			
			
			blocks[0]= ImageIO.read(getClass().getResourceAsStream("/Blocks/block_brick.png"));
		} catch (IOException e) {
		
			e.printStackTrace();
		}	
	}
}
