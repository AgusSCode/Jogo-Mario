package mapping;

import java.awt.Graphics;
import java.lang.*;
import java.util.ArrayList;
import java.io.*;
import objects.Block;
import objects.MovingBlock;
// El mapa se carga a traves de un txt
public class Map {
private String path;
private int width,height;
private Block[][] blocks;
private ArrayList<MovingBlock> movingBlocks;
private String line;

	public Map(String loadPath) {
		path= loadPath;
		

	loadMap();
	}
	
	public void draw(Graphics g){
		for(int i=0; i<blocks.length;i++) {
		for(int j=0;j<blocks[0].length;j++) {
			blocks[i][j].draw(g);
			
		}	
					
		}
		
		
		for(int i=0; i<movingBlocks.size(); i++) {
			movingBlocks.get(i).draw(g);
		}
		
		
	}
	
	public void tick(){
		
		for(int i =0; i< movingBlocks.size();i++) {
			movingBlocks.get(i).tick();
			
		}
		
	}
	// a traves de un camino hacia el txt, inputstream guarda el contenido del txt y bufferedReader lo lee.
	public void loadMap() {
		InputStream is = this.getClass().getResourceAsStream(path);
		BufferedReader br= new BufferedReader(new InputStreamReader(is));
	
	try {
		//aca se guardan las diferentes lineas que va leyendo
		// se establecen la anchura y altura en las dos primeras lineas
		width= Integer.parseInt(br.readLine());
		height = Integer.parseInt(br.readLine());
		
		//se establece el tamaño del mapa
		blocks = new Block[height][width];
		
		
		//se rellena teniendo en cuenta si el bloque va a ser dibujable(1) o no (0).
		for(int y=0;y<height;y++) {
			
		line = br.readLine();
		//Esta parte separa los reglones de los bloques
		String[] tokens = line.split("\\s+");
	
		for(int x=0;x<width;x++) {
			blocks[y][x]=new Block(x*Block.blockSize,y*Block.blockSize,Integer.parseInt(tokens[x]));
		}
		}
	
		line = br.readLine();
		line= br.readLine();
		int length = Integer.parseInt(line);
		movingBlocks = new ArrayList<MovingBlock>();
		
		for(int i= 0;i<length;i++) {
			line = br.readLine();
			String[] tokens = line.split("\\s+");
			
			movingBlocks.add(new MovingBlock(Integer.parseInt(tokens[0]) * Block.blockSize,
					Integer.parseInt(tokens[1])*Block.blockSize,Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3])*Block.blockSize,
					Integer.parseInt(tokens[4])*Block.blockSize));
		}
		
		
	} catch (NumberFormatException | IOException e) {
		
		e.printStackTrace();
	}
	
	}
	
	public Block[][] getBlocks(){
		
		return blocks;
	}

	
	public ArrayList<MovingBlock> getMovingBlocks(){
		return movingBlocks;
		
	}
	
	
}
