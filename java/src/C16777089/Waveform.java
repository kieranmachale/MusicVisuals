package C16777089;

import processing.core.*;

public class Waveform {
    
    AudioVisual av;
    float halfHeight;
    float border;
    float offset;

    public Waveform(AudioVisual av)
    {
        this.av = av;
        halfHeight = this.av.height / 2;
        border = 110;
        offset = 0;
    }

    public void drawWaveform()
    {
        av.colorMode(PApplet.HSB);
        for(int i = (int)border; i < av.getAudioBuffer().size(); i++)
        {

            //Outer waveform
            av.stroke(
            PApplet.map(i, 0, av.getAudioBuffer().size(), 0, 255) + offset
                , 255
                , 255
            );

            av.line(i, halfHeight, i, halfHeight + halfHeight * av.getAudioBuffer().get(i) * 0.8f);
            
            //Inner waveform
            av.stroke(
            PApplet.map(i, 0, av.getAudioBuffer().size(), 0, 255) + offset
                , 180
                , 100
            );
            av.line(i, halfHeight, i, halfHeight + halfHeight * av.getAudioBuffer().get(i) * 0.6f);

            av.stroke(30);
            av.line(border + 10, halfHeight, av.width, halfHeight);
            
        }
        
        if(av.frameCount % 60 == 0)
        {
            offset+= 150/255.0f;
        }
    }
}