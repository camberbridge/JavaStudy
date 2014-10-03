import java.awt.Graphics;
import java.applet.Applet;
/*
 * <applet code="DrawLine" width=200 height=200>
 * </applet>
 */

public class DrawLine extends Applet{
	public void paint(Graphics g){
		for(int i = 0; i < 10; i++){
			g.drawLine(10, 10 * i, 180, 110);
		}
		g.drawString("hagehogehage", 50, 100);
	}
}
