package com.Platformer.game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import com.Platformer.game.gamestate.GameState;
import com.Platformer.game.physics.Collision;

public class Block extends Rectangle {
	/**
	 * 
	 */
	private static final long serialVersionUID =1L;
	private int id;
	public static final int blockSize=64;
	
	public Block(int x, int y, int id) {
		// TODO Auto-generated constructor stub
		setBounds(x,y,blockSize,blockSize);
		this.id=id;
	}
	public void tick()
	{
		x=x-(int)GameState.xOffset;
		y=y-(int)GameState.yOffset;
	}
	public void draw(Graphics g)
	{
		//g.fillRect(x-(int)GameState.xOffset, y-(int)GameState.yOffset, width, height);
		g.setColor(Color.BLACK);
		if(id!=0)
		{
			g.fillRect(x-(int)GameState.xOffset, y-(int)GameState.yOffset, width, height);
		}
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public int getId()
	{
		return id;
	}
}
