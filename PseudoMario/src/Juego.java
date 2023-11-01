import javax.swing.*;
import java.awt.*;

public class Juego extends JPanel {
    private Player player;
    private Bloques bloques;
    private Controles controles;
    private Fondo fondo;
    private int cameraX; // Variable para almacenar la posición de la cámara en el eje X
    private Image fondoImage;
    public static final int ANCHO_VENTANA = 800;
    public static final int ALTO_VENTANA = 736;

    public Juego() {
        player = new Player();
        bloques = new Bloques();
        controles = new Controles(player, bloques);
        this.addKeyListener(controles);
        this.setFocusable(true);
        cameraX = 0;
        
        ImageIcon img = new ImageIcon("media/fondo.png");
        Image Scaledimg = img.getImage().getScaledInstance(1600, 736, Image.SCALE_SMOOTH);
        ImageIcon ScaledimgToIcon = new ImageIcon(Scaledimg);
        fondo = new Fondo(ScaledimgToIcon.getImage(), 1600, ANCHO_VENTANA);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        fondo.dibujarFondo(g);
        bloques.dibujarBloques(g, cameraX);
        player.dibujarPlayer(g, cameraX);
    }

    public void actualizar() {
        controles.actualizarMovimiento();
        cameraX = player.getX() - getWidth() / 2;
        cameraX = Math.max(0, Math.min(bloques.getNumBlocks() * bloques.getBlockSize() - getWidth(), cameraX));
        fondo.actualizar(cameraX, player.getX());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mi Juego");
        Juego juego = new Juego();
        frame.add(juego);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 736);
        frame.setLocationRelativeTo(null);
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