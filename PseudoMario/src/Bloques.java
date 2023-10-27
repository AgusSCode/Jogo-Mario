import java.awt.*;

public class Bloques {
    private int blockSize = 50;
    private int numBlocks = 16;

    public void dibujarBloques(Graphics g) {
        g.setColor(Color.GREEN);
        for (int i = 0; i < numBlocks; i++) {
            g.fillRect(i * blockSize, 450, blockSize, blockSize);
        }
    }

    public int getNumBlocks() {
        return numBlocks;
    }

    public int getBlockSize() {
        return blockSize;
    }
}
