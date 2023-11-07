package com.Platformer.game.main;

import java.util.Timer;
import java.util.TimerTask;

public class Score {
	static int time;
	int finaltime=time;
	static int FPS=60;
	static int coins=0;
	static int enemies=0;
	static boolean TimeOut=false;
	public void setTime(int time)
	{
		this.time=time;
	}
	public void tick()
	{
		FPS--;
		if(FPS<=0)
		{
			getTime();
			FPS=60;
			time--;
		}
		
	}
	public int getTime()
	{
	

		System.out.println(time);
		return time;
	}

}
