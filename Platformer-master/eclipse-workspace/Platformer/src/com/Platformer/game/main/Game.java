package com.Platformer.game.main;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Game 
{
	static JFrame frame=new JFrame("PLATFORMER");
	public static void main(String args[])
	{
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.add(new GamePanel(), BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public JFrame getFrame()
	{
		return frame;
	}
}

