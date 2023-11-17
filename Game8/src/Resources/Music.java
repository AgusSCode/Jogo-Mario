package Resources;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;



public class Music {
	
	public static  Clip Win;
	public static  Clip Lose;
	public static  Clip Nivel1;
	public static  Clip Nivel2;
	public static  Clip Nivel3;

	
	
	
	public Music() {
		
		
		
try {
        	
            File ArchivoSonidoWin = new File("res/Music/GameWin.wav");
            File ArchivoSonidoLose = new File("res/Music/GameOver.wav");
            File ArchivoSonidoNivel1 = new File("res/Music/lvl1.wav");
            File ArchivoSonidoNivel2 = new File("res/Music/lvl2.wav");
            File ArchivoSonidoNivel3 = new File("res/Music/lvl3.wav");
          
         
            AudioInputStream SonidoWin = AudioSystem.getAudioInputStream(ArchivoSonidoWin);
            AudioInputStream SonidoLose = AudioSystem.getAudioInputStream(ArchivoSonidoLose);
            AudioInputStream SonidoLVL1 = AudioSystem.getAudioInputStream(ArchivoSonidoNivel1);
            AudioInputStream SonidoLVL2 = AudioSystem.getAudioInputStream(ArchivoSonidoNivel2);
            AudioInputStream SonidoLVL3 = AudioSystem.getAudioInputStream(ArchivoSonidoNivel3);
            
     
            
            
           
            Win = AudioSystem.getClip();
            Win.open(SonidoWin);
            
            Lose = AudioSystem.getClip();
            Lose.open(SonidoLose);
            
            Nivel1 = AudioSystem.getClip();
            Nivel1.open(SonidoLVL1);
            
            Nivel2 = AudioSystem.getClip();
            Nivel2.open(SonidoLVL2);
            
            Nivel3 = AudioSystem.getClip();
            Nivel3.open(SonidoLVL3);
        
            
            
         

            
            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace(); 
        }



		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	 

}