import java.awt.*;
import java.util.Arrays;

public class Bloques {
    private int blockSize = 50;
    private int numBlocks = 32;
    private boolean[] bloqueAtravesable;
    private int elevatedBlockHeight = 100; // Altura del bloque elevado

    public Bloques() {
        // Inicializa los bloques como no atravesables por defecto
        bloqueAtravesable = new boolean[numBlocks];
        Arrays.fill(bloqueAtravesable, true);
     
      
  
    }
    public void dibujarBloques(Graphics g, int cameraX) {
        g.setColor(Color.GREEN);
        for (int i = 0; i < numBlocks; i++) {
            // Dibuja solo los bloques atravesables teniendo en cuenta la posición de la cámara
            
                g.fillRect(i * blockSize - cameraX, 450, blockSize, blockSize);
            
            
        }
    }
    

    public int getNumBlocks() {
        return numBlocks;
    }

    public int getBlockSize() {
        return blockSize;
    }
}  