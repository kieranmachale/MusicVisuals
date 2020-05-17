# Music Visualiser Project

Name: Kieran Mac Hale

Student Number: C16777089


# Description of the assignment

For this assignment I created an audio visual java program that uses the PApplet processing library to process
visuals that respond to audio information such as amplitude, frequency and sample rate. I used the audio library 
'minim' to get audio information from an mp3 file that is loaded at the beginning of runtime. 

# Instructions

After running the program from 'Main.java', the visualiser can be started by hitting the space bar. By default,
the waveform visualiser will play, but if you wish to cycle between the three variations I created, you can access them
by using the keys 1,2,3 and 4. I have included these instructions in the window of the visualiser. You can pause and resume
the audio and visuals by hitting space.

Youtube video showing the program running: 
[![YouTube](https://www.youtube.com/watch?v=_Bv1tinv_IQ&feature=youtu.be);

# How it works

The code for each visualiser is stored in separate classes of the same package. This program uses inheritance and polymorphism
to create objects of these classes from the 'driver' class, called AudioVisual.java. This class contains three central methods
which accomodate the visual processing aspect of this program; setup(), which is called once at the beginning of runtime, settings()
a method which is used to specify the dimensions of the window, and draw(), a built in method of PApplet which is called sixty times a second, 
allowing for the screen to be redrawn that many times per second. 

In the draw method I have included some boilerplate code which calculates things like the number of frequency bands in an FFT array.
This information can be used to map the co-ordinates of shapes within the program. The three visualisers mentioned above are called 
from draw(), and are nested inside if statements which check for the keyboard inputs of the user. 

I have also used some tertiary processing libraries that I learned about in class, such as the Table and TableRow libraries. In order
to make the displaying of instructions in my program easier, I wrote them in a .csv format and read them into my program using these
libraries. 

# What I am most proud of in the assignment

I wanted to use this assignment as a way to compound the learning outcomes of the semester 2 OOP module. 
Before this assignment I was only familiar basic OOP learned concepts from the first semester. Through this assignment I am 
satisfied that I was able to incorporate much of the new concepts I learned in semester 2 into my project; inheritance, polymorphism,
the use of processing libraries, storing data from text files, and more. As far as my vision for this assignment,
I wanted to create a dynamic visualiser with multiple modes that could be switched between during runtime, and I'm happy that I was able to do so. 


# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](https://www.youtube.com/watch?v=_Bv1tinv_IQ&feature=youtu.be)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

