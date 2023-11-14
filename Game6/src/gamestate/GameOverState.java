package gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Main.GamePanel;

public class GameOverState extends GameState {
	private String[] options= {"Reintentar","Salir"};
	private int currentSelection=1;
	public static Image fondoImagen, ninjaLogo,perdiste;
	private JButton retryButton;
    private JButton quitButton;
	public static int valor;
	/**
	 * @wbp.parser.entryPoint
	 */
	protected GameOverState(GameStateManager gsm)
	{
		super(gsm);
		ImageIcon img = new ImageIcon("res/Blocks/city4.gif");
	    fondoImagen = img.getImage();
	    
	    ImageIcon img2 = new ImageIcon("res/Blocks/NinjaX.png");
        Image Img2 = img2.getImage();
        Image scaled2 = Img2.getScaledInstance(240, 40, Image.SCALE_SMOOTH);
        ImageIcon scaledImg2 = new ImageIcon(scaled2);
        ninjaLogo = scaledImg2.getImage();
        
        ImageIcon img3 = new ImageIcon("res/Blocks/Perdiste.png");
        Image Img3 = img3.getImage();
        Image scaled3 = Img3.getScaledInstance(300, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledImg3 = new ImageIcon(scaled3);
        perdiste = scaledImg3.getImage();
        
        /*retryButton = new JButton("Retry");
        retryButton.setBounds(350, 100, 150, 50);
        retryButton.addActionListener(e -> handleRetryButtonClick());

        quitButton = new JButton("Quit");
        quitButton.setBounds(350, 200, 150, 50);
        quitButton.addActionListener(e -> handleQuitButtonClick());*/
	}

	
	@Override
	public void init()
	{
		System.out.println("Game Over");
	}
	@Override
	public void tick() 
	{
		
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void draw(Graphics g)
	{
		int valor =150;
	//g.setColor(Color.red);
	//g.fillRect(0, 0, GamePanel.WIDTH,GamePanel.HEIGHT);
	g.drawImage(fondoImagen, 0, 0, GamePanel.WIDTH,GamePanel.HEIGHT,null);
	g.drawImage(ninjaLogo, 250, 100, 240, 40, null);
	g.drawImage(perdiste, 220, 180, 300, 50, null);
	
	g.setColor(Color.white);
	g.setFont(new Font("Arial", Font.BOLD,60));
	//g.drawString("¡Moriste!", GamePanel.WIDTH/2-210,200);
	//infoLabel.paint(g);
	//g.drawString("Score-"+score.finalScore(),GamePanel.WIDTH/2-210,260);
		for(int i=0;i<options.length;i++)
		{
			if(i==currentSelection)
			{
				g.setColor(Color.RED);
			}
			else
			{
				g.setColor(Color.white);
			}
		//	g.drawLine(GamePanel.WIDTH/2, 0, GamePanel.WIDTH/2, GamePanel.HEIGHT);
			g.setFont(new Font("Arial", Font.PLAIN,60));
			g.drawString(options[i], GamePanel.WIDTH/2-valor,130+(i+2)*130 );
			
			valor -=70;
		}
	}

	@Override
	public void keyPressed(int k) 
	{
		if(k==KeyEvent.VK_DOWN)
		{
			currentSelection++;
			if(currentSelection>=options.length)
				currentSelection=1;
		}
		else if(k==KeyEvent.VK_UP)
		{
			currentSelection--;
			if(currentSelection<0)
				currentSelection=options.length;
		}
		if(k==KeyEvent.VK_ENTER)
		{
			if(currentSelection==0)
			{
				if(valor==1) {
					gsm.states.push(new Level1State(gsm));
				}
				if(valor==2) {
					gsm.states.push(new Level2State(gsm));
				}
				if(valor==3) {
					gsm.states.push(new Level3State(gsm));
				}
			}
			else if(currentSelection==1)
			{
				System.exit(0);
		 	}
		}
	}

	@Override
	public void keyReleased(int k) 
	{
		
	}

}


