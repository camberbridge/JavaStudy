import java.applet.*;
import java.awt.*;
import java.util.*;
/*
 * <applet code="AnalogClock" width=200 height=200>
 * </applet>
 */

public class AnalogClock extends Applet implements Runnable {
	private Thread t;
	
	public void init(){
		t = new Thread(this);
		t.start();
	}
	
	public void run(){
		try{
			while(true){
				Thread.sleep(1000);  //1•b‘Ò‹@
				repaint();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g){
		GregorianCalendar gc = new GregorianCalendar();
		
		//‰~‚Ì•`‰æ
		Dimension d = getSize();
		int xc = d.width / 2;
		int yc = d.height / 2;
		int r = (int)((d.width > d.height) ? 0.4 * d.height : 0.4 * d.width);
		g.drawOval(xc - r, yc -r, 2 * r, 2 * r);
		
		//Œv‚Ì–Ú·‚è‚Ì•`‰æ
	    for(int i = 0; i < 12; i++) {  //12–Ú·‚èì‚é
	        double degrees = i * 30;  //1–Ú·‚è30“x
	        double radians = degrees * Math.PI / 180;  //Šp“x~ƒ‰ƒWƒAƒ“
	        int xa = xc + (int)(0.9 * r * Math.cos(radians));
	        int ya = yc - (int)(0.9 * r * Math.sin(radians));
	        int xb = xc + (int)(r * Math.cos(radians));
	        int yb = yc - (int)(r * Math.sin(radians));
	        g.drawLine(xa, ya, xb, yb);
	    }
	    
	    // •ªj‚ğ•`‰æ‚·‚é
	    int second = gc.get(Calendar.SECOND);
	    double degrees = 90 - 6 * second;  //12‚ğ‹N“_‚Ì+90“x
	    double radians = degrees * Math.PI / 180;
	    int xh = xc + (int)(0.8 * r * Math.cos(radians));
	    int yh = yc - (int)(0.8 * r * Math.sin(radians));
	    g.setColor(Color.red);
	    g.drawLine(xc, yc, xh, yh);
	    
	    // •ªj‚ğ•`‰æ‚·‚é
	    int minute = gc.get(Calendar.MINUTE);
	    degrees = 90 - 6 * minute;  //12‚ğ‹N“_‚Ì+90“x
	    radians = degrees * Math.PI / 180;
	    xh = xc + (int)(0.8 * r * Math.cos(radians));
	    yh = yc - (int)(0.8 * r * Math.sin(radians));
	    g.setColor(Color.blue);
	    g.drawLine(xc, yc, xh, yh);
	    
	    // j‚ğ•`‰æ‚·‚é
	    int hour = gc.get(Calendar.HOUR_OF_DAY) % 24;
	    degrees = 90 - 30 * hour - 30 * (minute / 60.0f);
	    radians = degrees * Math.PI / 180;
	    int xm = xc + (int)(0.5 * r * Math.cos(radians));
	    int ym = yc - (int)(0.5 * r * Math.sin(radians));
	    g.drawLine(xc, yc, xm, ym);
	    
	    g.setFont(new Font("Serif", Font.BOLD, 50));
	    FontMetrics fm = g.getFontMetrics();
	    String s = hour + ":" + minute + ":" + second;
	    int s_start = xc - fm.stringWidth(s) / 2;
	    
	    g.setColor(Color.magenta);
	    g.drawString(s, s_start, yc);
	}
}
