import java.awt.*;

public class Player {
    private int x, y, width, height;
    private int velocidad = 5;

    public Player() {
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

    public void dibujarPlayer(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
