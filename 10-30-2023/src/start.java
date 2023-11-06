import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class start {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setBounds(50, 50, 1000, 600);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1184, 600);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		ImageIcon cross = new ImageIcon("imagenes/red_cross.png");
        Image crossimg = cross.getImage();
        Image scaledCross = crossimg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon scaledImgCross = new ImageIcon(scaledCross);
        
        JButton btnCross = new JButton();
        btnCross.setIcon(scaledImgCross);
        btnCross.setOpaque(false);
        btnCross.setBounds(650, 50, 40, 40);
        btnCross.setContentAreaFilled(false);
        btnCross.setBorderPainted(false);
        btnCross.setVisible(false);
		panel.add(btnCross);
        
		
		ImageIcon imag = new ImageIcon("imagenes/Ninja_x.png");
        Image imag2 = imag.getImage();
        Image scaled = imag2.getScaledInstance(350, 470, Image.SCALE_SMOOTH);
        ImageIcon scaledImg = new ImageIcon(scaled);
        
        JLabel labelInfo = new JLabel();
        labelInfo.setIcon(scaledImg);
        labelInfo.setBounds(350, 40, 350, 470);
        labelInfo.setVisible(false);
		panel.add(labelInfo);
		
		JLabel labelOscuro = new JLabel();
        labelOscuro.setBounds(0, 0, 1000, 600);
        labelOscuro.setOpaque(true);
        labelOscuro.setBackground(new Color(0, 0, 0, 150)); // Color negro con una opacidad de 150
        labelOscuro.setVisible(false); // Inicialmente, el label oscuro está oculto
        panel.add(labelOscuro);
        
        
        
        
		JButton btnNewButton = new JButton();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				niveles.main(args);
				frame.setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon("imagenes/Jugar.png"));
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 40));
		btnNewButton.setOpaque(false); // Hace que el fondo sea transparente
		btnNewButton.setContentAreaFilled(false); // Hace que el área de contenido sea transparente
		btnNewButton.setBorderPainted(false); 
		btnNewButton.setBounds(403, 367, 230, 49);
		panel.add(btnNewButton);
		
		
		ImageIcon image = new ImageIcon("imagenes/salir.png");
        Image imageIcon = image.getImage();
        Image scaledImage = imageIcon.getScaledInstance(225, 55, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
		
		
		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setIcon(scaledIcon);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 40));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(403, 450, 230, 49);
		panel.add(btnNewButton_1);

		
		ImageIcon image2 = new ImageIcon("imagenes/info.png");
        Image imageIcon2 = image2.getImage();
        Image scaledImage2 = imageIcon2.getScaledInstance(41, 41, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        
        
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(scaledIcon2);
		btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                labelOscuro.setVisible(true); // Hace visible el label oscuro al hacer clic en el botón
                labelInfo.setVisible(true);
                btnCross.setVisible(true);
            }
        });
		//btnNewButton_2.setOpaque(false);
		btnNewButton_2.setContentAreaFilled(false); // Hace que el área de contenido sea transparente
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBounds(930, 20, 41, 41);
		panel.add(btnNewButton_2);

		btnCross.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                labelInfo.setVisible(false);
                labelOscuro.setVisible(false);
                btnCross.setVisible(false);
            }
        });
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("imagenes/NinjaX.png"));
		lblNewLabel_1.setBounds(316, 121, 424, 138);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("imagenes/anime.gif"));
		lblNewLabel.setBounds(0, 0, 1184, 600);
		panel.add(lblNewLabel);
		
		
		
		frame.setVisible(true);

	}
}
