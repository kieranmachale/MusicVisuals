package C16777089;

import processing.core.*;

public class Waveform {
    
    AudioVisual av;
    float halfHeight;
    float border, numDots, r;

    public Waveform(AudioVisual av)
    {
        this.av = av;
        halfHeight = this.av.height / 2;
        border = this.av.width * 0.02f;
        numDots = this.av.width / 16;
    }

    public void drawWaveform()
    {
        av.colorMode(PApplet.HSB);
        for(int i = 0; i < av.getAudioBuffer().size(); i++)
        {
            av.stroke(
            PApplet.map(i, 0, av.getAudioBuffer().size(), 0, 255)
                , 255
                , 255
            );

            av.line(i, halfHeight, i, halfHeight + halfHeight * av.getAudioBuffer().get(i));
            
            float x = PApplet.map(i, 0, numDots, border, av.width - border + 10);

            av.stroke(255);
            av.ellipse(x, border * 3, 10, 10);
        }
    }
}