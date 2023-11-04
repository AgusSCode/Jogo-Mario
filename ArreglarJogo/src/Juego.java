import javax.swing.*;
import java.awt.*;

public class Juego extends JPanel {
    private Player player;
    private Bloques bloques;
    private Controles controles;
    private Fondo fondo;
    private Colisiones colisiones;
    
    private int cameraX; // Variable para almacenar la posición de la cámara en el eje X
    private Image fondoImage; // no la utilizamos ahora, pero tal vez sirve cuando tengamos varios niveles
    public static final int ANCHO_VENTANA = 800;
    public static final int ALTO_VENTANA = 736;
   
    
    
    public Juego() {
        player = new Player();
        bloques = new Bloques();
        controles = new Controles(player, bloques);
        colisiones = new Colisiones(player, bloques);
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
//Dibujar todo
        super.paintComponent(g);
        fondo.dibujarFondo(g);
        bloques.dibujarBloques(g, cameraX);
        player.dibujarPlayer(g, cameraX);
    }

    
    public void actualizar() {
    	// manejo del movimiento, movimiento de la camara, actualizacion del fondo y funcionamiento de colisiones
    	
        controles.actualizarMovimiento();
        cameraX = player.getX() - getWidth() / 2;
        cameraX = Math.max(0, Math.min(bloques.getNumBlocks() * bloques.getBlockSize() - getWidth(), cameraX));
        fondo.actualizar(cameraX, player.getX());
        colisiones.verificarColisiones();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("EL Juego");
        Juego juego = new Juego();
        frame.add(juego);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 736);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
// esto supuestamente hace mas eficiente el refresh rate, tipo para que se vea mas fluido, yo no le vi ningun cambio
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