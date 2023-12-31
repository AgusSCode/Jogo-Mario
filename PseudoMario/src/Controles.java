import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controles implements KeyListener {
    private Player player;
    private Bloques bloques;
    private boolean izquierdaPresionada = false;
    private boolean derechaPresionada = false;
    private boolean saltando = false;
    private boolean enAire = false;
    private int alturaInicial;
    private final int alturaMaxima = 100;
    
    private final int velocidadCaida = 3;

    public Controles(Player player, Bloques bloques) {
        this.player = player;
        this.bloques = bloques;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            izquierdaPresionada = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            derechaPresionada = true;
        }
        if (key == KeyEvent.VK_UP && !saltando && !enAire) {
            saltar();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            izquierdaPresionada = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            derechaPresionada = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No necesitas implementar este método, pero es obligatorio por KeyListener
    }

    private void saltar() {
        saltando = true;
        enAire = true;
        alturaInicial = player.getY();
    }

    public void actualizarMovimiento() {
        // Manejar el movimiento lateral
        if (izquierdaPresionada) {
            int nuevaX = player.getX() - player.getVelocidad();
            if (puedeMoverse(nuevaX, player.getY())) {
                player.moverIzquierda();
            }
        }
        if (derechaPresionada) {
            int nuevaX = player.getX() + player.getVelocidad();
            if (puedeMoverse(nuevaX, player.getY())) {
                player.moverDerecha();
            }
        }

        // Manejar el salto y la caída
        if (saltando) {
            int nuevaAltura = player.getY() - 5;
            if (nuevaAltura <= alturaInicial - alturaMaxima) {
                saltando = false;
            } else {
                player.setY(nuevaAltura);
            }
        } else if (enAire) {
            int nuevaAltura = player.getY() + velocidadCaida;
            player.setY(Math.min(nuevaAltura, alturaInicial));
            if (player.getY() >= alturaInicial) {
                enAire = false;
                player.setY(alturaInicial);
            }
        }
    }
    public boolean isEnAire() {
        return enAire;
    }
    
   
    

    private boolean puedeMoverse(int nuevaX, int y) {
    	
    	    
        // Verificar colisiones con los bordes laterales del mapa
        if (nuevaX < 0 || nuevaX + player.getWidth() > bloques.getNumBlocks() * bloques.getBlockSize()) {
            return false;
        }
        return true;
    }
}