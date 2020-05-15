package C16777089;

import processing.core.*;

public class Frequency {

    AudioVisual av;
    float border, bottomBorder, offset;

    public Frequency(AudioVisual av)
    {
        this.av = av;
        border = 112;
        bottomBorder = 9;
        offset = 0;
    }

    public void drawSpectrum()
    {
        float bandGap = av.width /(float)av.getBands().length;
        av.noStroke();

        for(int i = 0; i < av.getBands().length; i++)
        {   

            float c = (i + offset)%255;

            av.stroke(0);
        
            av.fill(c , 255, 255);
            av.rect(i * bandGap + border, av.height - bottomBorder, bandGap, -av.getSmoothedBands()[i] * 0.5f);

            av.noStroke();
            av.fill(c, 255, 200);
            av.rect(i * bandGap + border, av.height - bottomBorder, 35, -av.getSmoothedBands()[i] * 0.4f);

        }
        offset += 200/250.0f;
    }

    



    
}