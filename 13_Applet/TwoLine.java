import java.awt.*;
import java.applet.*;
/*
 * <applet code="TwoLine" width=200 height=200>
 * </applet
 */

public class TwoLine extends Applet{
	public void paint(Graphics g){
		setBackground(Color.yellow);
		Dimension d = getSize();
		int xc = d.width;
		int yc = d.height;
		int r = (int)((d.width < d.height) ? 0.4 * d.width : 0.4 * d.height);
		
		g.setColor(Color.blue);
		g.drawLine(0, 0, d.width, d.height);
		g.drawLine(0, d.height, d.width, 0);
		g.drawOval(0, 0, 2 * r, 2 * r);
	}
}
