package com.Platformer.game.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import org.ietf.jgss.GSSManager;

import com.Platformer.game.main.GamePanel;

public class HelpState extends GameState
{
	private String[] options= {"Play","Quit"};
	private int currentSelection=0;
	protected HelpState(GameStateManager gsm)
	{
		super(gsm);
	}
	@Override
	public void init()
	{
		
	}
	@Override
	public void tick() 
	{
		
	}
	@Override
	public void draw(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillRect(0, 0, GamePanel.WIDTH,GamePanel.HEIGHT);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD,40));
		g.drawString("CONTROLS", 0+50,50);
		g.setFont(new Font("Arial", Font.BOLD,30));
		g.drawString("D-Move Right", 0+10,90);
		g.drawString("A-Move Left", 0+10,130);
		g.drawString("Space-Jump", 0+10,170);
		
		g.setFont(new Font("Arial", Font.BOLD,40));
		g.drawString("TIPS", 0+50,230);
		g.setFont(new Font("Arial", Font.BOLD,30));
		g.drawString("Coins give 1000 points each", 0+10,270);
		g.drawString("Enemies killed give 2000 points each",0+10,310);
		g.drawString("Your Score is divided by the time you take, so", 0+10,350);
		g.drawString("move quick!", 0+10,390);
		for(int i=0;i<options.length;i++)
		{
			if(i==currentSelection)
			{
				g.setColor(Color.RED);
			}
			else
			{
				g.setColor(Color.white);
			}
			//g.drawLine(GamePanel.WIDTH/2, 50, GamePanel.WIDTH/2, GamePanel.HEIGHT);
			g.setFont(new Font("Arial", Font.PLAIN,72));
			g.drawString(options[i], i*600+50,500);
		}
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.ITALIC,15));
		g.drawString("Made by Aditya Karve and Chirag Pandey", 10,590);

	}
	

	@Override
	public void keyPressed(int k) 
	{
		if(k==KeyEvent.VK_DOWN)
		{
			currentSelection++;
			if(currentSelection>=options.length)
				currentSelection=0;
		}
		else if(k==KeyEvent.VK_UP)
		{
			currentSelection--;
			if(currentSelection<0)
				currentSelection=options.length;
		}
		if(k==KeyEvent.VK_ENTER)
		{
			if(currentSelection==0)
			{
				gsm.states.push(new Level1State(gsm));
			}
			else if(currentSelection==1)
			{
				
			}
			else if(currentSelection==2)
			{
				System.exit(0);
			}
		}
	}

	@Override
	public void keyReleased(int k) 
	{
		
	}

}