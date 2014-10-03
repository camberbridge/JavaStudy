import java.awt.*;
import java.applet.*;
/*
 * <applet code="MovingDot" width=250 height=250>
 * </applet>
 */

public class MovingDot extends Applet implements Runnable {
	private Thread t;
	private static final int r = 100, n = 5;
	private int x, y, xc, yc;
	private double radian = 0;
	
	public void init(){
		t = new Thread(this);
		t.start();
	}
	
	public void run(){
		try{
			while(true){
				repaint();
				
				Thread.sleep(10);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void paint(Graphics g){
		Dimension d = getSize();
		xc = d.width / 2;
		yc = d.height / 2;
		x = xc + (int)(r * Math.cos(radian));
		y = yc - (int)(r * Math.sin(radian));
		
		g.fillRect(x - 2, y - 2, n, n);
		radian += Math.PI / 1000;
	}

}
