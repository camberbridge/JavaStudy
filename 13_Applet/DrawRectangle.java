import java.awt.Graphics;
import java.applet.Applet;
/*
 * <applet code="DrawRectangle" width=500 height=300>
 * </applet>
 */

public class DrawRectangle extends Applet {
	public void paint(Graphics g){
		int x = 100, xwidth = 300;
		int y = 50, yheight = 200;
		
		g.drawRect(x, y, xwidth, yheight);
	}
}
