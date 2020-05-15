package C16777089;

import ie.tudublin.*;
import processing.data.Table;
import processing.data.TableRow;
import java.util.ArrayList;

public class AudioVisual extends Visual{
    
    private boolean firstPress = true;
    private boolean songPlaying = true;

    private boolean wfSelected = false;
    private boolean freqSelected = false;
    private boolean circSelected = false;

    private int numLines;
    private float textGap;


    Waveform waveform;
    Frequency frequency;

    ArrayList<Menu> menuItemArray = new ArrayList<Menu>();

    public void setup()
    {   
        startMinim();
        colorMode(HSB); 

        loadMenu();
        loadAudio("01 A Rainbow in Curved Air.mp3");

        waveform = new Waveform(this);
        frequency = new Frequency(this);
       
    }

    public void loadMenu()
    {
        Table t = loadTable("menu.csv", "header");

        for(TableRow row:t.rows())
		{
			Menu m = new Menu(row);
			menuItemArray.add(m);
		}
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

        if(key == '1')
        {
            wfSelected = true;
            freqSelected = false;
            circSelected = false;
        }

        if(key == '2')
        {
            wfSelected = false;
            freqSelected = true;
            circSelected = false;
        }

        if(key == '3')
        {
            wfSelected = false;
            freqSelected = false;
            circSelected = true;
        }

    }

    public void drawSidebar()
    {
        stroke(255);
        fill(120);
        rect(10, 10, 100, 480);

        numLines = width/128;
        textGap = 50;
        int index = 1; 

        for(Menu m: menuItemArray)
        {
            float y = map(index, 0, numLines, textGap, height - textGap);

            textAlign(CENTER,CENTER);
            
            if(index % 2 == 0)
            {
                fill(200);
            }
            else{
                fill(0);
            }
            
            text(m.getMenuItem(), 60, y);
            ++index;
        }

        textAlign(CENTER,CENTER);
        fill(255);
        text("Hit space to begin", width/2, 20);  
        
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

        calculateFrequencyBands(); 
        background(0); 
        drawSidebar();

        if(wfSelected){
            waveform.drawWaveform();
        }

        if(freqSelected){
            frequency.drawSpectrum();
        }

        if(circSelected){
            
        }
        
    }
}