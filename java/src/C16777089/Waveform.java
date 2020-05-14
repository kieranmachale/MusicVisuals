package C16777089;

import processing.core.*;

public class Waveform {
    
    AudioVisual av;
    float halfHeight;
    float border;

    public Waveform(AudioVisual av)
    {
        this.av = av;
        halfHeight = this.av.height / 2;
        border = 110;
    }

    public void drawWaveform()
    {
        av.colorMode(PApplet.HSB);
        for(int i = (int)border; i < av.getAudioBuffer().size(); i++)
        {
            av.stroke(
            PApplet.map(i, 0, av.getAudioBuffer().size(), 0, 255)
                , 255
                , 255
            );

            av.line(i, halfHeight, i, halfHeight + halfHeight * av.getAudioBuffer().get(i) * 1.2f);
            
        }
    }
}