package com.Platformer.game.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.Platformer.game.main.GamePanel;

public class GameOverState extends GameState {
	private String[] options= {"Retry","Quit"};
	private int currentSelection=1;
	private netScore score=new netScore();
	protected GameOverState(GameStateManager gsm)
	{
		super(gsm);
	}
	@Override
	public void init()
	{
		System.out.println("Game Over");
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
	g.setFont(new Font("Arial", Font.BOLD,60));
	g.drawString("GAME OVER", GamePanel.WIDTH/2-210,130);
	g.drawString("Score-"+score.finalScore(),GamePanel.WIDTH/2-210,260);
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
		//	g.drawLine(GamePanel.WIDTH/2, 0, GamePanel.WIDTH/2, GamePanel.HEIGHT);
			g.setFont(new Font("Arial", Font.PLAIN,60));
			g.drawString(options[i], GamePanel.WIDTH/2-85,130+(i+2)*130 );
		}
	}

	@Override
	public void keyPressed(int k) 
	{
		if(k==KeyEvent.VK_DOWN)
		{
			currentSelection++;
			if(currentSelection>=options.length)
				currentSelection=1;
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
				System.exit(0);
		 	}
		}
	}

	@Override
	public void keyReleased(int k) 
	{
		
	}

}


