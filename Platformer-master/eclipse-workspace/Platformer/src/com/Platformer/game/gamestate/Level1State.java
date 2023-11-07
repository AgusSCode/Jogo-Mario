package com.Platformer.game.gamestate;

import java.awt.Graphics;
import java.util.Timer;

import com.Platformer.game.entities.Player;
import com.Platformer.game.main.Score;
import com.Platformer.game.map.MapLoader;
import com.Platformer.game.objects.Block;
import com.Platformer.game.objects.Coin;

public class Level1State extends GameState
{
	private Player player;
	private MapLoader map;
	private Coin coin;
	private Score score;
	private int time=70;
	private netScore ns;
	protected Level1State(GameStateManager gsm) 
	{
		
		super(gsm);
		init();
	}

	@Override
	public void init() {
		
		player=new Player(50,50);
		map=new MapLoader("/Map1.map");
		xOffset=-200;//-200
		yOffset=-10;//-400
		score=new Score();
		score.setTime(time);
		ns=new netScore();
	}

	@Override
	public void tick() {
		//gsm.states.push(new GameOverState(gsm));
		System.out.println("gsm-"+gsm.states.peek());
		player.tick(map.getBlocks(),map.getMovingBlocks(),map.getEnemies(),map.getCoin());
		map.tick();
		score.tick();
		if(player.getYOffset()>900)
		{
			gsm.states.push(new GameOverState(gsm));
		}
		if(player.deadOrAlive())
		{
			gsm.states.push(new GameOverState(gsm));
			
		}
		if(player.getXOffset()>12180)
		{
			gsm.states.push(new WinState(gsm));
		}
		if(score.getTime()==0)
		{
			gsm.states.push(new GameOverState(gsm));
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		player.draw(g);
		map.draw(g);
	
	}

	@Override
	public void keyPressed(int k) {
		player.keyPressedEvent(k);
	}

	@Override
	public void keyReleased(int k) {
		player.keyReleased(k);
	}
	
}
