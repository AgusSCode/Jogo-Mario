package Main;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gamestate.GameStateManager;
import gamestate.Level1State;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class niveles {
	
	static GameStateManager gsm;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(50, 50, 1000, 600);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1184, 600);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		ImageIcon image = new ImageIcon("imagenes/Niveles.png");
        Image imageIcon = image.getImage();
        Image scaledImage = imageIcon.getScaledInstance(273, 69, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(scaledIcon);
		lblNewLabel_1.setBounds(390, 40, 273, 69);
		panel.add(lblNewLabel_1);
		
		ImageIcon img = new ImageIcon("imagenes/home.png");
        Image img3 = img.getImage();
        Image scaledImg = img3.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledImag = new ImageIcon(scaledImg);
        
        JButton btn = new JButton();
        btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		start.main(args);
        		frame.setVisible(false);
        		
        	}
        });
		btn.setIcon(scaledImag);
		btn.setOpaque(false);
		btn.setFont(new Font("Dialog", Font.PLAIN, 40));
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setBounds(930, 20, 30, 30);
		panel.add(btn);
		
		ImageIcon image3 = new ImageIcon("imagenes/boton1.png");
        Image imageIcon3 = image3.getImage();
        Image scaledImage3 = imageIcon3.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);
        
        JButton btnNewButton = new JButton();
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Game.main(args);
        	}
        });
		btnNewButton.setIcon(scaledIcon3);
		btnNewButton.setOpaque(false);
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 40));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(309, 294, 60, 60);
		panel.add(btnNewButton);
		
		ImageIcon image4 = new ImageIcon("imagenes/boton2.png");
        Image imageIcon4 = image4.getImage();
        Image scaledImage4 = imageIcon4.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon4 = new ImageIcon(scaledImage4);
        
        JButton btnNewButton1 = new JButton();
		btnNewButton1.setIcon(scaledIcon4);
		btnNewButton1.setOpaque(false);
		btnNewButton1.setFont(new Font("Dialog", Font.PLAIN, 40));
		btnNewButton1.setContentAreaFilled(false);
		btnNewButton1.setBorderPainted(false);
		btnNewButton1.setBounds(399, 294, 60, 60);
		panel.add(btnNewButton1);
		
		ImageIcon image6 = new ImageIcon("imagenes/boton3.png");
        Image imageIcon6 = image6.getImage();
        Image scaledImage6 = imageIcon6.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon6 = new ImageIcon(scaledImage6);
        
        JButton btnNewButton2 = new JButton();
		btnNewButton2.setIcon(scaledIcon6);
		btnNewButton2.setOpaque(false);
		btnNewButton2.setFont(new Font("Dialog", Font.PLAIN, 40));
		btnNewButton2.setContentAreaFilled(false);
		btnNewButton2.setBorderPainted(false);
		btnNewButton2.setBounds(484, 294, 60, 60);
		panel.add(btnNewButton2);
		
		ImageIcon image7 = new ImageIcon("imagenes/boton4.png");
        Image imageIcon7 = image7.getImage();
        Image scaledImage7 = imageIcon7.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon7 = new ImageIcon(scaledImage7);
        
        JButton btnNewButton3 = new JButton();
		btnNewButton3.setIcon(scaledIcon7);
		btnNewButton3.setOpaque(false);
		btnNewButton3.setFont(new Font("Dialog", Font.PLAIN, 40));
		btnNewButton3.setContentAreaFilled(false);
		btnNewButton3.setBorderPainted(false);
		btnNewButton3.setBounds(569, 294, 60, 60);
		panel.add(btnNewButton3);
		
		ImageIcon image8 = new ImageIcon("imagenes/boton5.png");
        Image imageIcon8 = image8.getImage();
        Image scaledImage8 = imageIcon8.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon8 = new ImageIcon(scaledImage8);
        
        JButton btnNewButton4 = new JButton();
		btnNewButton4.setIcon(scaledIcon8);
		btnNewButton4.setOpaque(false);
		btnNewButton4.setFont(new Font("Dialog", Font.PLAIN, 40));
		btnNewButton4.setContentAreaFilled(false);
		btnNewButton4.setBorderPainted(false);
		btnNewButton4.setBounds(654, 294, 60, 60);
		panel.add(btnNewButton4);
		
		ImageIcon image9 = new ImageIcon("imagenes/boton6.png");
        Image imageIcon9 = image9.getImage();
        Image scaledImage9 = imageIcon9.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon9 = new ImageIcon(scaledImage9);
        
        JButton btnNewButton5 = new JButton();
		btnNewButton5.setIcon(scaledIcon9);
		btnNewButton5.setOpaque(false);
		btnNewButton5.setFont(new Font("Dialog", Font.PLAIN, 40));
		btnNewButton5.setContentAreaFilled(false);
		btnNewButton5.setBorderPainted(false);
		btnNewButton5.setBounds(309, 377, 60, 60);
		panel.add(btnNewButton5);
		
		ImageIcon image10 = new ImageIcon("imagenes/boton7.png");
        Image imageIcon10 = image10.getImage();
        Image scaledImage10 = imageIcon10.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon10 = new ImageIcon(scaledImage10);
        
        JButton btnNewButton6 = new JButton();
		btnNewButton6.setIcon(scaledIcon10);
		btnNewButton6.setOpaque(false);
		btnNewButton6.setFont(new Font("Dialog", Font.PLAIN, 40));
		btnNewButton6.setContentAreaFilled(false);
		btnNewButton6.setBorderPainted(false);
		btnNewButton6.setBounds(399, 377, 60, 60);
		panel.add(btnNewButton6);
		
		ImageIcon image2 = new ImageIcon("imagenes/SelectFondo.png");
        Image imageIcon2 = image2.getImage();
        Image scaledImage2 = imageIcon2.getScaledInstance(800, 395, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(scaledIcon2);
		lblNewLabel_2.setBounds(119, 164, 800, 395);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("imagenes/city.gif"));
		lblNewLabel.setBounds(0, 0, 1184, 600);
		panel.add(lblNewLabel);
		
		
		
		
		frame.setVisible(true);
	}
}
