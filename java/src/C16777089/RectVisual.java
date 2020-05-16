package C16777089;

import processing.core.*;

public class RectVisual {
    
    AudioVisual av;
    float r, x, y1, y2;
    int[] nums = new int[8];

    public RectVisual(AudioVisual av)
    {
        this.av = av;
        r = 80;
        x = av.width/2;
        y1 = 20;
        y2 = r;
    }

    public void drawRects()
    {

        for(int i = 0; i < nums.length; i++)
        {
            nums[i] = 80;
        }

        float numRects = (float)(av.width - 240)/32;
        float gap = av.width/numRects;
        float r = 25;
        float offset = 0;

        for(int j = 1; j < numRects; j++)
        {
            for(int i = 1; i < numRects; i++)
            {
                x = (i * gap);
                y1 = (j * gap);
                float cGap = (i) + av.getAudioBuffer().get(i) + offset;

                av.noStroke();
                av.fill(cGap * i % 255);

                av.rect(x + 78, y1 - 20, r , r * av.getAudioBuffer().get(i) * 5.0f);

            }
            offset += 16;
        }
        
    }
}

