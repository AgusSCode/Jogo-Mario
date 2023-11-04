import java.awt.*;
import java.util.Arrays;

public class Bloques {
    private int blockSize = 50;
    private int numBlocks = 32;
    private int[] alturas;
    private boolean[] bloquePisable;

    public Bloques() {
    	 alturas = new int[numBlocks];
    	 bloquePisable = new boolean[numBlocks];
    	    Arrays.fill(alturas, 450); // Altura del suelo por defecto
    	    Arrays.fill(bloquePisable, true); // Por defecto, todos los bloques son pisables
    	    
 // son las alturas que puse para probar lo de los pozos. 
    	    alturas[0] = 400;
    	    alturas[1] = 350;
  
    }
    
// esto simplemente es el metodo que esta en el paintcomponent
    public void dibujarBloques(Graphics g, int cameraX) {
        g.setColor(Color.GREEN);
        for (int i = 0; i < numBlocks; i++) {
            int diferencia = 50;
            g.fillRect(i * blockSize - cameraX, alturas[i] + diferencia, blockSize, blockSize);
            
            
        }
    }
    
//consigue la altura de cada bloque por separado (por eso esta el array alturas)
    public int getAlturaBloqueEnPosicion(int x) {
        int bloqueIndex = x / blockSize;
        bloqueIndex = Math.max(0, Math.min(numBlocks - 1, bloqueIndex));
        
        return alturas[bloqueIndex];
    }

    public boolean colision(int x, int y, int width, int height) {
        int bloqueIndexIzquierda = Math.max(0, x / blockSize);
        int bloqueIndexDerecha = Math.min(numBlocks - 1, (x + width - 1) / blockSize);
        int bloqueIndexArriba = Math.max(0, y / blockSize);
        int bloqueIndexAbajo = Math.min(numBlocks - 1, (y + height - 1) / blockSize);

        for (int i = bloqueIndexIzquierda; i <= bloqueIndexDerecha; i++) {
            for (int j = bloqueIndexArriba; j <= bloqueIndexAbajo; j++) {
                if (!bloquePisable[i] && x + width >= i * blockSize && x <= (i + 1) * blockSize
                        && y + height >= j * blockSize && y <= (j + 1) * blockSize) {
                	System.out.println("AcA");
                	// Colisión detectada
                    return true;
                }
            }
        }

        // No hay colisión en los lados ni en la parte inferior del bloque
        return false;
    }

 // no esta en uso ahora mismo, pero nos puede servir para verificar si un bloque queda como invisible o de hecho esta siendo utilizado
    public boolean EsPisable (int x) {
        int bloqueIndex = x / blockSize;
        bloqueIndex = Math.max(0, Math.min(numBlocks - 1, bloqueIndex));
        
        return bloquePisable[bloqueIndex];
    }
    public int getNumBlocks() {
        return numBlocks;
    }

    public int getBlockSize() {
        return blockSize;
    }
}
