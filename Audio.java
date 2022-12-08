import java.io.IOException;

import javax.sound.sampled.*;

public class Audio {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // Open an audio input stream from the sound file
        String soundFile = "sound\\Song.wav";
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(App.class.getResource(soundFile));

        // Get a sound clip resource
        Clip clip = AudioSystem.getClip();

        // Open audio clip and load samples from the audio input stream
        clip.open(audioIn);

        // Play the sound clip
        clip.start();
    }
}