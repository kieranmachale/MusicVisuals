package C16777089;

import ie.tudublin.*;

public class AudioVisual extends Visual{
    
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
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }

    public void draw()
    {
        background(0);
        stroke(255);
        
    }
}