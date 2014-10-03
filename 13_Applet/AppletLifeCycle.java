import java.applet.Applet;
import java.awt.Graphics;
/*
 * <applet code="AppletLifeCycle" width=200 height=200>
 * </applet>
 */

public class AppletLifeCycle extends Applet{
	private String s = "";
	
	public void init(){
		s += "init: ";
	}
	
	public void start(){
		s+= "start: ";
	}
	
	public void stop(){
		s+= "stop: ";
	}
	
	public void destroy(){
		System.out.println("destroy");
	}
	
	public void paint(Graphics g){
		g.drawString(s, 10, 25);
	}
}
