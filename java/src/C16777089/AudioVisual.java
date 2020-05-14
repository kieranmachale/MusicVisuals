package C16777089;

import ie.tudublin.*;

public class AudioVisual extends Visual{
    
    private boolean firstPress = true;
    private boolean songPlaying = true;

    public void setup()
    {   
        startMinim();
        colorMode(HSB); 

        loadAudio("01 A Rainbow in Curved Air.mp3");
       
    }

    public void settings()
    {
        size(1024,500);
    }

    public void keyPressed()
    {   

        if(key == ' ')
        {
            if(firstPress)
            {
                getAudioPlayer().cue(0);
                getAudioPlayer().play();

                firstPress = false;
            }
            else
            {
                if(songPlaying)
                {
                    getAudioPlayer().pause();
                    songPlaying = false;
                }
                else
                {
                    getAudioPlayer().play();
                    songPlaying = true;
                }
            }

        }

    }

    public void draw()
    {
        background(0);
        stroke(255);
        
    }
}