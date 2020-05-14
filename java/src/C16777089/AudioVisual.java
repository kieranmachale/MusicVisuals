package C16777089;

import ie.tudublin.*;
import processing.data.Table;
import processing.data.TableRow;
import java.util.ArrayList;

public class AudioVisual extends Visual{
    
    private boolean firstPress = true;
    private boolean songPlaying = true;
    private int numLines;
    private float textGap;

    Waveform waveform;
    Frequency frequency;

    public void setup()
    {   
        startMinim();
        colorMode(HSB); 

        loadAudio("01 A Rainbow in Curved Air.mp3");

        waveform = new Waveform(this);
        frequency = new Frequency(this);
       
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

    public void drawSidebar()
    {
        stroke(255);
        fill(120);
        rect(10, 10, 100, 480);

        numLines = height/100;
        textGap = 50;

        for(int i = 0; i < numLines; i++)
        {
            float y = map(i, 0, numLines, textGap, height - textGap);

            textAlign(CENTER,CENTER);
            fill(0);
            text("Insert text", 55, y);
        }
    }

    public void draw()
    {

        background(0);
        try
        {
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }

        background(0); 
        drawSidebar();

        waveform.drawWaveform();
    }
}