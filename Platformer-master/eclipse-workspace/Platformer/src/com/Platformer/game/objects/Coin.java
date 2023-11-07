package com.Platformer.game.objects;

import java.awt.*;

import com.Platformer.game.gamestate.GameState;

public class Coin extends Rectangle {
	private static final long serialVersionUID = 1L;
	private int id;
	private int x,y;
	public Coin(int x, int y, int id)
	{
		this.x=x;
		this.y=y;
		this.id=id;
		setBounds(x,y,30,30);
	}
	public void tick()
	{
	}
	public void draw(Graphics g)
	{
		if(id!=0)
		{
			
			g.setColor(Color.yellow);
			g.fillOval(x-(int)GameState.xOffset, y-(int)GameState.yOffset, 30, 30);
			
		}
	//	System.out.println("RENDER");
	}
	public int getId()
	{
		return id;
	}

}

