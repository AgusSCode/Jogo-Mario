package com.Platformer.game.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.Platformer.game.gamestate.GameState;
import com.Platformer.game.gamestate.netScore;
import com.Platformer.game.main.GamePanel;
import com.Platformer.game.main.Score;
import com.Platformer.game.objects.Block;
import com.Platformer.game.objects.Coin;
import com.Platformer.game.objects.Enemy;
import com.Platformer.game.objects.MovingBlock;
import com.Platformer.game.physics.Collision;

public class Player 
{	
	//movement
	private  boolean right=false, left=false, jumping=false, falling=false;
	private  boolean topCollision=false;
	//private boolean bottomCollision=false;
	
	//bounds
	private double x,y;
	private int width,height;
	//jump speed
	private double jumpSpeed=10;
	private double currentJumpSpeed=jumpSpeed;
	//fall speed
	private double maxFallSpeed=6;
	private Double currentFallSpeed=0.6;
	private boolean isDead=false;
	private netScore score;
	private Score s;
	

	public Player(int width, int height)
	{
		x=GamePanel.WIDTH/2;
		y=GamePanel.HEIGHT/2;
		this.width=width;
		this.height=height;
	}
	public void tick(Block[][] b, ArrayList<MovingBlock> movingBlocks,ArrayList<Enemy> enemy,ArrayList<Coin> coin)
	{
//	*/
		System.out.println("X offset-"+GameState.xOffset);
		score=new netScore();
		int iX=(int)x;
		int iY=(int)y;
		for(int i=0;i<b.length;i++)
		{
			for(int j=0;j<b[0].length;j++)
			{
				if(b[i][j].getId()!=0)
				{
			//right
			if(Collision.playerBlock(new Point(iX+width+(int)GameState.xOffset,iY+(int)GameState.yOffset+2), b[i][j])/*||Collision.playerBlock(new Point(iX+width+(int)GameState.xOffset,iY+height+(int)GameState.yOffset-3), b[i][j])*/)
			{
				//System.out.println("RIGHT COLL");
				right=false;
			}
			//left
			if(Collision.playerBlock(new Point(iX+(int)GameState.xOffset-1,iY+(int)GameState.yOffset+2), b[i][j])||Collision.playerBlock(new Point(iX+(int)GameState.xOffset-1, iY-1+height+(int)GameState.yOffset), b[i][j]))
			{
				left=false;
			}
			//top
			if(Collision.playerBlock(new Point(iX+(int)GameState.xOffset+1,iY+(int)GameState.yOffset), b[i][j])||Collision.playerBlock(new Point(iX+width-1+(int)GameState.xOffset,iY+(int)GameState.yOffset), b[i][j]))
			{
				jumping=false;
				falling=true;
			}
			if(Collision.playerBlock(new Point(iX+(int)GameState.xOffset+2,iY+height+(int)GameState.yOffset+1), b[i][j])||Collision.playerBlock(new Point(iX+(int)GameState.xOffset+width-2,iY+height+(int)GameState.yOffset+1), b[i][j]))
			{
				////System.out.println("Bottom Collision");
				y=b[i][j].getY()-height-GameState.yOffset;
				falling=false;
				topCollision=true;
				
			}
			else
			{
				if(!topCollision&&!jumping)
				{
					falling=true;
				}	
			}
			}
			}
		}
	/*	topCollision=false;
		if(right==true)
		GameState.xOffset++;
		if(left==true)
			GameState.xOffset--;
		
		////System.out.println(right);
		if(jumping)
		{
			falling=false;
			GameState.yOffset-=currentJumpSpeed;
			currentJumpSpeed-=0.1;
			if(currentJumpSpeed<=0)
			{
				currentJumpSpeed=jumpSpeed;
				jumping=false;
				falling=true; 
			}
		}
		if(falling)
		{
			GameState.yOffset+=currentFallSpeed;
			if(currentFallSpeed<maxFallSpeed)
			{
				currentFallSpeed+=0.1;
			}
		}
	
	*/
	for(int i=0;i<movingBlocks.size();i++)
	{
		if(movingBlocks.get(i).getId()!=0)
		{
			//right
			if(Collision.playerMovingBlock(new Point(iX+width+(int)GameState.xOffset,iY+(int)GameState.yOffset+2), movingBlocks.get(i))||Collision.playerMovingBlock(new Point(iX+width+(int)GameState.xOffset,iY+height+(int)GameState.yOffset-3), movingBlocks.get(i)))
			{
				//System.out.println("RIGHT COLL");
				right=false;
			}
			//left
			if(Collision.playerMovingBlock(new Point(iX+(int)GameState.xOffset-1,iY+(int)GameState.yOffset+2), movingBlocks.get(i))||Collision.playerMovingBlock(new Point(iX+(int)GameState.xOffset-1, iY-1+height+(int)GameState.yOffset), movingBlocks.get(i)))
			{
				left=false;
			}
			//top
			if(Collision.playerMovingBlock(new Point(iX+(int)GameState.xOffset+1,iY+(int)GameState.yOffset), movingBlocks.get(i))||Collision.playerMovingBlock(new Point(iX+width-1+(int)GameState.xOffset,iY+(int)GameState.yOffset), movingBlocks.get(i)))
			{
				jumping=false;
				falling=true;
			}
			//bottom
			if(Collision.playerMovingBlock(new Point(iX+(int)GameState.xOffset+2,iY+height+(int)GameState.yOffset+1), movingBlocks.get(i))||Collision.playerMovingBlock(new Point(iX+(int)GameState.xOffset+width-2,iY+height+(int)GameState.yOffset+1), movingBlocks.get(i)))
			{
				////System.out.println("Bottom Collision");
				y=movingBlocks.get(i).getY()-height-GameState.yOffset;
				falling=false;
				topCollision=true;
				GameState.xOffset+=movingBlocks.get(i).getMove();
				
			}
			else
			{
				if(!topCollision&&!jumping)
				{
					falling=true;
				}	
			}
		}
	}
	for(int i=0;i<coin.size();i++)
	{
		//System.out.println(coin.size());
		if(coin.get(i).getId()!=0)
		{
			//right
			if(Collision.playerCoin(new Point(iX+width+(int)GameState.xOffset,iY+(int)GameState.yOffset+2), coin.get(i))||Collision.playerCoin(new Point(iX+width+(int)GameState.xOffset,iY+height+(int)GameState.yOffset-3), coin.get(i)))
			{
			//	System.out.println("RIGHT COLL");
				//System.exit(1);
				score.addCoin();
				coin.remove(coin.get(i));
			}
			//left
			else if(Collision.playerCoin(new Point(iX+(int)GameState.xOffset-1,iY+(int)GameState.yOffset+2), coin.get(i))||Collision.playerCoin(new Point(iX+(int)GameState.xOffset-1, iY-1+height+(int)GameState.yOffset), coin.get(i)))
			{
				System.out.println("Left COLL");
				score.addCoin();
				coin.remove(coin.get(i));
			}
			//top
			else if(Collision.playerCoin(new Point(iX+(int)GameState.xOffset+1,iY+(int)GameState.yOffset), coin.get(i))||Collision.playerCoin(new Point(iX+width-1+(int)GameState.xOffset,iY+(int)GameState.yOffset), coin.get(i)))
			{
				System.out.println("Top COLL");
				score.addCoin();
				coin.remove(coin.get(i));
			}
			//bottom
		
			else
			{
				if(!topCollision&&!jumping)
				{
					falling=true;
				}	
			}
		}
	}
	//ENEMY COLLISION
	for(int i=0;i<enemy.size();i++)
	{
		if(enemy.get(i).getId()!=0)
		{
			//bottom
			if(Collision.playerEnemy(new Point(iX+(int)GameState.xOffset+2,iY+height+(int)GameState.yOffset+1), enemy.get(i))||Collision.playerEnemy(new Point(iX+(int)GameState.xOffset+width-2,iY+height+(int)GameState.yOffset+1), enemy.get(i)))
			{
				////System.out.println("Bottom Collision");
				/*y=enemy.get(i).getY()-height-GameState.yOffset;
				falling=false;
				topCollision=true;
				GameState.xOffset+=enemy.get(i).getMove();*/
				score.killCount();
				enemy.remove(enemy.get(i));
			}
			//right
			else if(Collision.playerEnemy(new Point(iX+width+(int)GameState.xOffset,iY+(int)GameState.yOffset+2), enemy.get(i))||Collision.playerEnemy(new Point(iX+width+(int)GameState.xOffset,iY+height+(int)GameState.yOffset-3), enemy.get(i)))
			{
				System.out.println("RIGHT COLL");
				//System.exit(1);
				right=false;
				isDead=true;
			}
			//left
			else if(Collision.playerEnemy(new Point(iX+(int)GameState.xOffset-1,iY+(int)GameState.yOffset+2), enemy.get(i))||Collision.playerEnemy(new Point(iX+(int)GameState.xOffset-1, iY-1+height+(int)GameState.yOffset), enemy.get(i)))
			{
				System.out.println("Left COLL");
				left=false;
				isDead=true;
			}
			//top
		
			else
			{
				if(!topCollision&&!jumping)
				{
					falling=true;
				}	
			}
		}
	}
	topCollision=false;
	if(right==true)
	GameState.xOffset+=5;
	if(left==true)
		GameState.xOffset-=5;
	
	////System.out.println(right);
	if(jumping)
	{
		falling=false;
		GameState.yOffset-=currentJumpSpeed;
		currentJumpSpeed-=0.2;
		if(currentJumpSpeed<=0)
		{
			currentJumpSpeed=jumpSpeed;
			jumping=false;
			falling=true; 
		}
	}
	if(falling)
	{
	//DEBUG MODE	//System.out.println("True");
		GameState.yOffset+=currentFallSpeed;
		if(currentFallSpeed<maxFallSpeed)
		{
			currentFallSpeed+=0.3;
		}
	}
	}
	public double getYOffset()
	{
		return GameState.yOffset;
	}
	public boolean deadOrAlive()
	{
		return isDead;
	}
	public void draw(Graphics g)
	{
		s=new Score();
		g.setColor(Color.GREEN);
		g.fillRect((int)x, (int)y, width, height);
		g.drawString(score.finalScore(),(int)(x+width+10),(int)(y-height+30));
		g.setColor(Color.red);
		g.drawString(Integer.toString(s.getTime()),50,50);
	}
	public void keyPressedEvent(int k)
	{
		
		if(k==KeyEvent.VK_A)
		{
			left=true;
		}
		if(k==KeyEvent.VK_D)
		{
			right=true;
		}
		if(k==KeyEvent.VK_SPACE&&!jumping&&!falling)
		{
			jumping=true;
		}
	}
	public void keyReleased(int k)
	{
		if(k==KeyEvent.VK_D)
		{
			right=false;
		}
		if(k==KeyEvent.VK_A)
		{
			left=false;
		}
		
	}
	public double getXOffset()
	{
		return GameState.xOffset;
	}
}
