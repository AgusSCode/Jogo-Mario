import javax.swing.*;
import java.awt.*;

public class Juego extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7461897230133563467L;
	private Player player;
    private Bloques bloques;
    private Controles controles;
    private int cameraX; // Variable para almacenar la posición de la cámara en el eje X

    public Juego() {
    	 player = new Player(); // 5 es un ejemplo, ajusta este valor según la velocidad que desees
         bloques = new Bloques();
         controles = new Controles(player, bloques);
         this.addKeyListener(controles);
         this.setFocusable(true);
         cameraX = 0;
    }

    @Override
    public void paintComponent(Graphics g) {
    	
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, getWidth(), getHeight());
        // Dibuja los bloques teniendo en cuenta la posición de la cámara
        bloques.dibujarBloques(g, cameraX);
        // Dibuja el jugador teniendo en cuenta la posición de la cámara
        player.dibujarPlayer(g, cameraX);
    }

    public void actualizar() {
        controles.actualizarMovimiento();
        // Actualiza la posición de la cámara para que siga al jugador
        cameraX = player.getX() - getWidth() / 2;
        // Limita la posición de la cámara para que no se salga de los límites del mapa
        cameraX = Math.max(0, Math.min(bloques.getNumBlocks() * bloques.getBlockSize() - getWidth(), cameraX));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mi Juego");
        Juego juego = new Juego();
        frame.add(juego);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);

        while (true) {
            juego.actualizar();
            juego.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}