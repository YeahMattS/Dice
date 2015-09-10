import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

public void setup()
{
	size(610, 610);
	background(0);
	noLoop();
}

int sum;
float num1;
float num2;
float num3;
float num4;
float num5;
float num6;

public void draw()
{
	sum = 0;
	num1 = 0;
	num2 = 0;
	num3 = 0;
	num4 = 0;
	num5 = 0;
	num6 = 0;
	background(0);
	// 10 x 12 grid
	for (int i = 0; i < 12; i++)
	{
		for (int j = 0; j < 10; j++)
		{
			Die d = new Die(50*i+10, 50*j+10);
			d.roll();
			d.show();	
		}
	}

	fill(255);
	textSize(16);
	text("Sum: " + sum, 10, 520);
	text("frequency of 1: " + nf(100*num1/120, 2, 2) + "%", 110, 520);
	text("frequency of 2: " + nf(100*num2/120, 2, 2) + "%", 110, 540);
	text("frequency of 3: " + nf(100*num3/120, 2, 2) + "%", 110, 560);
	text("frequency of 4: " + nf(100*num4/120, 2, 2) + "%", 300, 520);
	text("frequency of 5: " + nf(100*num5/120, 2, 2) + "%", 300, 540);
	text("frequency of 6: " + nf(100*num6/120, 2, 2) + "%", 300, 560);

	fill(128);

	rect(500, 560, 10, 200/6);
	rect(520, 560, 10, 200/6);
	rect(540, 560, 10, 200/6);
	rect(560, 560, 10, 200/6);
	rect(580, 560, 10, 200/6);
	rect(600, 560, 10, 200/6);

	fill(255);

	rect(500, 560, 10, -200*num1/120);
	rect(520, 560, 10, -200*num2/120);
	rect(540, 560, 10, -200*num3/120);
	rect(560, 560, 10, -200*num4/120);
	rect(580, 560, 10, -200*num5/120);
	rect(600, 560, 10, -200*num6/120);
}


public void mousePressed()
{
	redraw();
}
class Die //models one single dice cube
{
	int x, y, dot;
	Die(int x, int y) //constructor
	{
		this.x = x;
		this.y = y;
	}
	public void roll()
	{
		dot = (int)(Math.random()*6)+1;
	}
	public void show()
	{
		fill(255);
		rect(x, y, 40, 40);
		fill(0);
		noStroke();
		if (dot == 1)
		{
			sum+=1;
			num1++;
			ellipse(x + 20, y + 20, 5, 5);
		}
		else if (dot == 2)
		{
			sum+=2;
			num2++;
			ellipse(x+10, y+10, 5, 5);
			ellipse(x+30, y+30, 5, 5);
		}
		else if (dot == 3)
		{
			sum+=3;
			num3++;
			ellipse(x+10, y+10, 5, 5);
			ellipse(x+20, y+20, 5, 5);
			ellipse(x+30, y+30, 5, 5);
		}
		else if (dot == 4)
		{
			sum+=4;
			num4++;
			ellipse(x+10, y+10, 5, 5);
			ellipse(x+30, y+10, 5, 5);
			ellipse(x+10, y+30, 5, 5);
			ellipse(x+30, y+30, 5, 5);
		}
		else if (dot == 5)
		{
			sum+=5;
			num5++;
			ellipse(x+10, y+10, 5, 5);
			ellipse(x+30, y+10, 5, 5);
			ellipse(x+10, y+30, 5, 5);
			ellipse(x+30, y+30, 5, 5);
			ellipse(x+20, x+20, 5, 5);
		}
		else if (dot == 6)
		{
			sum+=6;
			num6++;
			ellipse(x+10, y+10, 5, 5);
			ellipse(x+10, y+20, 5, 5);
			ellipse(x+10, y+30, 5, 5);
			ellipse(x+30, y+10, 5, 5);
			ellipse(x+30, y+20, 5, 5);
			ellipse(x+30, y+30, 5, 5);
		}
	}
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
