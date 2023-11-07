package com.Platformer.game.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import org.ietf.jgss.GSSManager;

import com.Platformer.game.main.GamePanel;

public class MenuState extends GameState
{
	private String[] options= {"Play","Help","Quit"};
	private int currentSelection=0;
	protected MenuState(GameStateManager gsm)
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
			//g.drawLine(GamePanel.WIDTH/2, 0, GamePanel.WIDTH/2, GamePanel.HEIGHT);
			g.setFont(new Font("Arial", Font.PLAIN,72));
			g.drawString(options[i], GamePanel.WIDTH/2-75,150+i*150 );
		}
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
				gsm.states.push(new HelpState(gsm));
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
