import java.awt.*;
import java.applet.*;
/*
 * <applet code="ConnectedDots" width=250 height=100>
 * </applet>
 */

public class ConnectedDots extends Applet implements Runnable{
	private Thread t;
	private int i = 0, j = 0;
	
	public void init(){
		t = new Thread(this);
		t.start();
	}
	
	public void run(){
		try{
			while(true){
				repaint();
				
				Thread.sleep(100);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void update(Graphics g){
		paint(g);
	}
	
	public void paint(Graphics g){
		Dimension d = getSize();
		int x = (int)(Math.random() * d.width);
		int y = (int)(Math.random() * d.height);
		
		g.fillRect(x,  y,  2,  2);
		if(i != 0 || j != 0){
			g.drawLine(i,  j,  x,  y);
		}
		
		i = x;
		j = y;
		}
}