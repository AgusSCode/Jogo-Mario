import javax.swing.*;
import java.awt.*;

public class PanelOscuro {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Panel Oscuro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Configuración del panel oscuro
        JPanel panelOscuro = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibujar un fondo oscuro
                g.setColor(new Color(0, 0, 0, 150));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panelOscuro.setLayout(new BorderLayout());

        // Configuración del contenido del panel oscuro
        JLabel etiqueta = new JLabel("Contenido del panel oscuro");
        etiqueta.setForeground(Color.WHITE);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        panelOscuro.add(etiqueta, BorderLayout.CENTER);

        // Configuración del fondo detrás del panel oscuro
        JLabel fondo = new JLabel();
        fondo.setIcon(new ImageIcon("imagenes/city.gif")); // Cambia la ruta por la ubicación de tu imagen de fondo
        frame.setContentPane(fondo);
        fondo.setLayout(new BorderLayout());

        // Añadir el panel oscuro sobre el fondo
        fondo.add(panelOscuro, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
