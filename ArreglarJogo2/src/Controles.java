import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controles implements KeyListener {
    private Player player;
    private Bloques bloques;
    private boolean izquierdaPresionada = false;
    private boolean derechaPresionada = false;
    private boolean saltando = false;
    private boolean enAire = false;
    private final int velocidadCaida = 3;
    private final int alturaMaxima = 100;
    private int alturaInicial;

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
        if (key == KeyEvent.VK_UP) {
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
        if (!saltando && !enAire && player.getY() == bloques.getAlturaBloqueEnPosicion(player.getX())) {
            saltando = true;
            enAire = true;
            alturaInicial = player.getY();
            
        }
    }

    public void actualizarMovimiento() {
    	int nuevaX = player.getX();

        if (izquierdaPresionada) {
            nuevaX -= player.getVelocidad();
            // Verificar y corregir la colisión con el lado izquierdo de los bloques
            if (bloques.colision(nuevaX, player.getY(), player.getWidth(), player.getHeight())) {
                nuevaX = (bloques.getAlturaBloqueEnPosicion(nuevaX) + 1) * bloques.getBlockSize();
                System.out.println("Colisión izquierda");
            }
        }

        if (derechaPresionada) {
            nuevaX += player.getVelocidad();
            // Verificar y corregir la colisión con el lado derecho de los bloques
            if (bloques.colision(nuevaX, player.getY(), player.getWidth(), player.getHeight())) {
                nuevaX = bloques.getAlturaBloqueEnPosicion(nuevaX) * bloques.getBlockSize() - player.getWidth();
                System.out.println("Colisión derecha");
            }
        }

        // Actualizar la posición del jugador después de verificar las colisiones
        player.setX(nuevaX);

        // Verificar si el jugador está en el aire o en el suelo
        int alturaSuelo = bloques.getAlturaBloqueEnPosicion(player.getX());
        if (player.getY() < alturaSuelo || saltando) {
            // El jugador está en el aire o saltando
        	
            if (saltando) {
                int nuevaAltura = player.getY() - velocidadCaida; // Simula el salto hacia arriba
                if (nuevaAltura <= alturaInicial - alturaMaxima) {
                    saltando = false; // Detener el salto cuando alcanza la altura máxima
                } else {
                    player.setY(nuevaAltura);
                    
                }
            } else {
                int nuevaAltura = player.getY() + velocidadCaida; // Simula la caída
                player.setY(Math.min(nuevaAltura, alturaSuelo));
                
            }
        } else {
            // El jugador está en el suelo
            //player.setY(alturaSuelo); --ACA ESTA EL ERROR
            saltando = false;
            enAire = false;
        }
    }
}
