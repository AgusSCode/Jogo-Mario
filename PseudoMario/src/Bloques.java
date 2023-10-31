import java.awt.*;
import java.util.Arrays;

public class Bloques {
    private int blockSize = 50;
    private int numBlocks = 32;
    private boolean[] bloqueAtravesable;
    
    public Bloques() {
        // Inicializa los bloques como no atravesables por defecto
        bloqueAtravesable = new boolean[numBlocks];
        Arrays.fill(bloqueAtravesable, true);
     
        bloqueAtravesable[0] = false;
        bloqueAtravesable[1] = false;
        // Establece algunos bloques como no atravesables para obstáculos en el mapa
        bloqueAtravesable[3] = false;
        bloqueAtravesable[6] = false;
  
    }
    public void dibujarBloques(Graphics g, int cameraX) {
        g.setColor(Color.GREEN);
        for (int i = 0; i < numBlocks; i++) {
            // Dibuja solo los bloques atravesables teniendo en cuenta la posición de la cámara
            if (bloqueAtravesable[i]) {
                g.fillRect(i * blockSize - cameraX, 450, blockSize, blockSize);
            }
            
        }
    }
    

    public int getNumBlocks() {
        return numBlocks;
    }

    public int getBlockSize() {
        return blockSize;
    }
}  