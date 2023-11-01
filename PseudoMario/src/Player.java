import java.awt.*;

public class Player {
    private int x, y, width, height;
    private int velocidad = 5;

    public Player() {
        // Establecer la velocidad del jugador al crearlo
        x = 50;
        y = 400;
        width = 50;
        height = 50;
    }

    

	public void moverDerecha() {
        x += velocidad;
    }

    public void moverIzquierda() {
        x -= velocidad;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int newY) {
        y = newY;
    }

    public void setX(int newX) {
        x = newX;
    }
    
    public void dibujarPlayer(Graphics g, int cameraX) {
        g.setColor(Color.RED);
        // Dibuja al jugador teniendo en cuenta la posición de la cámara
        g.fillRect(x - cameraX, y, width, height);
    }
    public int getVelocidad() {
        return velocidad;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}