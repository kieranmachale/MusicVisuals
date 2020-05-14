package ie.tudublin;

import C16777089.AudioVisual;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new AudioVisual());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}