package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import objects.Block;

import Resources.Images;
import gamestate.GameState;

public class MovingBlock extends Rectangle{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int leftBound, rightBound;
	private int id;
	private double move=1;

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
	
		if(x>i+rightBound)
		{
			move=-1;
			
		}
		if(x<i-leftBound)
		{
			move=1;
		}
		x+=move;
		
	
	}
	public void draw(Graphics g)
	{
		if(id!=0)
		{
			g.setColor(Color.BLACK);

g.drawImage(Images.blocks[id-1],x-(int)GameState.xOffset, y- (int)GameState.yOffset,width,height,null);
		
		}
	
	}
	public int getMove()
	{
		return (int)move;
	}
	public int getID()
	{
		return id;
	}

}
