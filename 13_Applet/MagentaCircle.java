import java.applet.*;
import java.awt.*;
/*
 * <applet code="MagentaCircle" width=120 height=120>
 * </applet>
 */

public class MagentaCircle extends Applet {
	public void paint(Graphics g){
		setBackground(Color.cyan);
		Dimension d = getSize();
		int xc = d.width / 2;
		int yc = d.height / 2;
		int r = 50;
		g.setColor(Color.magenta);
		
		g.fillOval(xc - r, yc - r, 2 * r, 2 * r);
	}
}
