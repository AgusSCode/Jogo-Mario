import javax.swing.*;
import java.awt.*;

public class Juego extends JPanel {
    private Player player;
    private Bloques bloques;
    private Controles controles;

    public Juego() {
        player = new Player();
        bloques = new Bloques();
        controles = new Controles(player);
        this.addKeyListener(controles);
        this.setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, getWidth(), getHeight());
        bloques.dibujarBloques(g);
        player.dibujarPlayer(g);
    }

    public void actualizar() {
        controles.actualizarMovimiento();
        // Aquí puedes agregar lógica para manejar colisiones u otras actualizaciones del juego
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
