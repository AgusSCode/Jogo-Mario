package com.Platformer.game.physics;

import java.awt.Point;

import com.Platformer.game.objects.Block;
import com.Platformer.game.objects.Coin;
import com.Platformer.game.objects.Enemy;
import com.Platformer.game.objects.MovingBlock;

public class Collision {
	public static boolean playerBlock(Point p, Block b)
	{
		return b.contains(p);
	}
	public static boolean playerMovingBlock(Point p, MovingBlock b) {
		// TODO Auto-generated method stub
		return b.contains(p);
	}
	public static boolean playerEnemy(Point p, Enemy b)
	{
		return b.contains(p);
	}
	public static boolean playerCoin(Point p, Coin b)
	{
		return b.contains(p);
	}
}
