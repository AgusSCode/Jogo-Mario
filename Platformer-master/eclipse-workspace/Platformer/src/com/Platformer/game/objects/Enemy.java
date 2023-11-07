package com.Platformer.game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.Platformer.game.gamestate.GameState;

public class Enemy extends Rectangle{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int leftBound, rightBound;
	private int id;
	private int move=3;
	private int i;
	public Enemy(int x, int y, int id, int leftBound, int rightBound)
	{
		setBounds(x,y,Block.blockSize,Block.blockSize);
		this.id=id;
		this.rightBound=rightBound;
		this.leftBound=leftBound;
		i=x;
	}
	public void tick()
	{
		if(x>=i+rightBound)
		{
			move=-3;
		//	System.out.println("God fucking dammit");
		}
		if(x<i-leftBound)
		{
			move=3;
		}
		x+=move;
	}
	public void draw(Graphics g)
	{
		if(id!=0)
		{
			g.setColor(Color.RED);
			g.fillRect(x-(int)GameState.xOffset, y-(int)GameState.yOffset, width, height);
		}
	//	System.out.println("RENDER");
	}
	public int getMove()
	{
		return move;
	}
	public int getId()
	{
		return id;
	}

}

