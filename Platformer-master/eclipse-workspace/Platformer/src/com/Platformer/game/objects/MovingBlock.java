package com.Platformer.game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.Platformer.game.gamestate.GameState;

public class MovingBlock extends Rectangle{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int leftBound, rightBound;
	private int id;
	private double move=2;

	private int i=0;
	public MovingBlock(int x, int y, int id, int leftBound, int rightBound)
	{
		setBounds(x,y,Block.blockSize,Block.blockSize);
		this.id=id;
		this.rightBound=rightBound;
		this.leftBound=leftBound;
		this.x=x;
		i=x;
		
	}

	
	public void tick()
	{
		//System.out.println("i-"+i);
		if(x>=i+rightBound)
		{
			move=-2;
			//System.out.println("God fucking dammit");
		}
		if(x<i-leftBound)
		{
			move=2;
		}
		x+=move;
		
	
	}
	public void draw(Graphics g)
	{
		if(id!=0)
		{
			g.setColor(Color.BLACK);
			g.fillRect(x-(int)GameState.xOffset, y-(int)GameState.yOffset, width, height);
			//System.out.println(y);
		}
	//	System.out.println("RENDER");
	}
	public int getMove()
	{
		return (int)move;
	}
	public int getId()
	{
		return id;
	}

}
