/********************************************************************************* 
Name: Hengjin, Clement, Eric
Course: CS170-01
Lab #: project
Submission Date: 10:00pm thurs 12/8/2022 
Brief Description:  This class can be called to play music. It also can stop music from being played.
*********************************************************************************/ 
package stuff;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class sound {

	private static Clip clip; //clip field

	public static void RunMusic(String path) throws LineUnavailableException {
		try {//trys to get and output music
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));//gets music from path
			clip = AudioSystem.getClip();
			clip.open(inputStream);//opens the music
			clip.loop(0);//no loop
			clip.start();//plays music
		} catch (UnsupportedAudioFileException e) {//catch exceptiobns
			e.printStackTrace();
		} catch (IOException e) {//catch exceptiobns
			e.printStackTrace();
		}
	}//end of runMusic
	
	public static void stop() {//this method stops and clears the music that is being played
		clip.stop();
		clip.close();
	}//end of stop method
}//end of sound class