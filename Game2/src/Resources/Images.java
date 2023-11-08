package Resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
//Carga las imagenes segun el tipo de bloque
	public static BufferedImage[] blocks;
	
	public Images() {
		blocks= new BufferedImage[3];
		try {
			blocks[0]= ImageIO.read(getClass().getResourceAsStream("/Blocks/block_brick.png"));
			blocks[1]= ImageIO.read(getClass().getResourceAsStream("/Blocks/tierra.jpg"));
			blocks[2]= ImageIO.read(getClass().getResourceAsStream("/Blocks/spike1.png"));
		} catch (IOException e) {
		
			e.printStackTrace();
		}	
	}
}
