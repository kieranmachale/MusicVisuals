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

            float l1 = halfHeight + halfHeight * av.getAudioBuffer().get(i) * 1.8f;
            float y1 = PApplet.lerp(halfHeight, l1, 0.5f);

            float l2 = halfHeight + halfHeight * av.getAudioBuffer().get(i) * 1.6f;
            float y2 = PApplet.lerp(halfHeight, l2, 0.5f);

            av.line(i, halfHeight, i, y1);
            
            //Inner waveform
            av.stroke(
            PApplet.map(i, 0, av.getAudioBuffer().size(), 0, 255) + offset
                , 180
                , 100
            );
            av.line(i, halfHeight, i, y2);

            av.stroke(30);
            av.line(border + 10, halfHeight, av.width, halfHeight);
            
        }
        
        if(av.frameCount % 60 == 0)
        {
            offset+= 150/255.0f;
        }
    }
}