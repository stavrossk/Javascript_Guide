import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class colors extends Applet implements Runnable {

	Font f = new Font("TimesRoman", Font.BOLD, 48);
	Color colors[] = new Color[12];
	Thread myThread;
	String myString;

	public void init() {
		// init color array
		colors[0] = Color.black;
		colors[1] = Color.blue;
		colors[2] = Color.cyan;
		colors[3] = Color.darkGray;
		colors[4] = Color.gray;
		colors[5] = Color.green;
		colors[6] = Color.magenta;
		colors[7] = Color.orange;
		colors[8] = Color.pink;
		colors[9] = Color.red;
		colors[10] = Color.white;
		colors[11] = Color.yellow;

		myString = new String("Hello, world!");
	}

	public void start() {
		if (myThread == null) {
			myThread = new Thread(this);
			myThread.start();
		}
	}

	public void stop() {
		if (myThread != null)  {
			myThread.stop();
			myThread = null;
		}
	}

	public void run() {

		// display array of colors
		int i = 0;
		while (true) {
			setForeground(colors[i]);
			repaint();
			i++;
			try {Thread.sleep(500);}
			catch(InterruptedException e) {}
			if (i == colors.length) 
				i = 0;
		}
	}

	public void setString(String aString) {
		myString = aString;
		System.out.println("myString = " +  myString);
		repaint();
	}

	public void paint(Graphics g) {
		g.setFont(f);
		g.drawString(myString, 15, 50);
	}
}