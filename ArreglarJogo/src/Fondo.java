import java.awt.*;

public class Fondo {
    private Image imagen;
    private int anchoImagen;
    private int x;
    private int limiteIzquierdo;
    private int limiteDerecho;

    public Fondo(Image imagen, int anchoImagen, int anchoVentana) {
        this.imagen = imagen;
        this.anchoImagen = anchoImagen;
        this.limiteIzquierdo = 0;
        this.limiteDerecho = Math.max(0, anchoImagen - anchoVentana);
        this.x = 0;
    }

    public void actualizar(int cameraX, int playerX) {
    	this.x = cameraX + playerX / 32;//a mas alto numero, mas lento el efecto
        if (x < limiteIzquierdo) {
            x = limiteIzquierdo;
        } else if (x > limiteDerecho) {
            x = limiteDerecho;
        }
    }

    public void dibujarFondo(Graphics g) {
        g.drawImage(imagen, -x, 0, null);
    }
}
