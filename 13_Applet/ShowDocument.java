import java.applet.*;
import java.awt.*;
import java.net.*;
/*
 * <applet code="ShowDocument" width=200 height=50>
 * </applet>
 */

public class ShowDocument extends Applet {
	public void init(){
		AppletContext ac = getAppletContext();
		try{
			URL url = new URL("http://www.osborne.com");
			ac.showDocument(url, "frame2");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g){
		g.drawString("ShowDocument Applet", 10, 25);
	}
}
