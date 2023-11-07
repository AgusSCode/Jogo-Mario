package com.Platformer.game.map;

import java.awt.Graphics;

import java.io.*;
import java.util.ArrayList;

import com.Platformer.game.objects.Block;
import com.Platformer.game.objects.Coin;
import com.Platformer.game.objects.Enemy;
import com.Platformer.game.objects.MovingBlock;

public class MapLoader {
	String path;
	private int width, height;
	private Block[][] blocks;
	String line;
	private ArrayList<MovingBlock> movingBlocks;
	private ArrayList<Enemy> enemy;
	private ArrayList<Coin> coin;
	public MapLoader(String path)
	{
		this.path=path;
		blocks=new Block[height][width];
		loadMap();
	}
	public void loadMap()
	{
		InputStream is=this.getClass().getResourceAsStream(path);
		BufferedReader br=new BufferedReader(new InputStreamReader(is));
		try {
			width=Integer.parseInt(br.readLine());
			height=Integer.parseInt(br.readLine());
			blocks=new Block[height][width];
		
			for(int y=0;y<height;y++)
			{
				line=br.readLine();
				String[] tokens=line.split("\\s+");
				for(int x=0;x<width;x++)
				{
					blocks[y][x]=new Block(x*Block.blockSize,y*Block.blockSize,Integer.parseInt(tokens[x]));
				}
			}
			line=br.readLine();
		//	System.out.println(line);
			line=br.readLine();
			System.out.println("line2-"+line);
			int length=Integer.parseInt(line);
			movingBlocks=new ArrayList<MovingBlock>();
			enemy=new ArrayList<Enemy>();
			coin=new ArrayList<Coin>();
			for(int i=0;i<length;i++)
			{
				line=br.readLine();
				String[] tokens=line.split("\\s+");
				movingBlocks.add(new MovingBlock(Integer.parseInt(tokens[0])*Block.blockSize,
						Integer.parseInt(tokens[1])*Block.blockSize,
						Integer.parseInt(tokens[2])*Block.blockSize,
						Integer.parseInt(tokens[3])*Block.blockSize,
						Integer.parseInt(tokens[4])*Block.blockSize));	
			}
			line=br.readLine();
			line=br.readLine();
		//System.out.println(line);
			int x=Integer.parseInt(line);
			for(int i=0;i<x;i++)
			{
				line=br.readLine();
				String[] tokens=line.split("\\s+");
				enemy.add(new Enemy(Integer.parseInt(tokens[0])*Block.blockSize,
						Integer.parseInt(tokens[1])*Block.blockSize,
						Integer.parseInt(tokens[2])*Block.blockSize,
						Integer.parseInt(tokens[3])*Block.blockSize,
						Integer.parseInt(tokens[4])*Block.blockSize));
			}
			line=br.readLine();
			line=br.readLine();
			
			int y=Integer.parseInt(line);
		//	System.out.println("y-"+y);
			for(int i=0;i<y;i++)
			{
				line=br.readLine();
			//	System.out.println("Line-"+line);
				String[] tokens=line.split("\\s+");
				//System.out.println(tokens.length);
				coin.add(new Coin(Integer.parseInt(tokens[0])*Block.blockSize, Integer.parseInt((tokens[1]))*Block.blockSize, Integer.parseInt(tokens[2])));
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics g)
	{
		for(int i=0;i<blocks.length;i++)
		{
			for(int j=0;j<blocks[0].length;j++)
			{
				blocks[i][j].draw(g);
			}
		}
		for(int j=0;j<movingBlocks.size();j++)
		{
			movingBlocks.get(j).draw(g);
		}
		for(int i=0;i<enemy.size();i++)
		{
			enemy.get(i).draw(g);
		}
		for(int i=0;i<coin.size();i++)
		{
			coin.get(i).draw(g);
		}
		
		
		
	}
	public void tick()
	{
		for(int j=0;j<movingBlocks.size();j++)
		{
			movingBlocks.get(j).tick();
		}
		for(int i=0;i<enemy.size();i++)
		{
			enemy.get(i).tick();
		}
	}
	public Block[][] getBlocks()
	{
		return blocks;
	}
	public ArrayList<MovingBlock> getMovingBlocks()
	{
		return movingBlocks;
	}
	public ArrayList<Enemy> getEnemies()
	{
		return enemy;
	}
	public ArrayList<Coin> getCoin()
	{
		return coin;
	}
	
}
