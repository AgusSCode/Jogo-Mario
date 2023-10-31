import java.awt.*;

public class Colisiones {
    public static boolean colisionConBloques(Player player, Bloques bloques) {
        Rectangle jugadorRect = player.getBounds();

        for (int i = 0; i < bloques.getNumBlocks(); i++) {
            Rectangle bloqueRect = new Rectangle(i * bloques.getBlockSize(), 450, bloques.getBlockSize(), bloques.getBlockSize());

            if (jugadorRect.intersects(bloqueRect)) {
                // Hay una colisión entre el jugador y el bloque en el índice 'i'
                return true;
            }
        }

        // No hay colisión con ningún bloque
        return false;
    }
} 