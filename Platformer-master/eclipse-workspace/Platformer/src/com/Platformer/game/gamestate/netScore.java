package com.Platformer.game.gamestate;

import com.Platformer.game.main.Score;

public class netScore {
	static int coins=0;
	static int enemies=0;
	private Score score=new Score();
	public int addCoin()
	{
		coins++;
		System.out.println(coins);
		return coins;
	}
	public int killCount()
	{
		enemies++;
		return enemies;
	}
	public String finalScore()
	{
		return Integer.toString((coins*1000+enemies*2000)/(101-score.getTime()));
	}
}
