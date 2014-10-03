import java.applet.*;
import java.awt.*;
/*
 * <applet cose="Ellipse" width=200 height=200 allign=BOTTOM vspace=100 hspace=100>
 * <param name="major" value=140>
 * <param name="minor" value=70>
 * </applet>
 */

public class Ellipse extends Applet {
	public void paint(Graphics g){
		Dimension d = getSize();
		String major = getParameter("major");
		String minor = getParameter("minor");
		int ma = Integer.valueOf(major).intValue();
		int mi = Integer.valueOf(minor).intValue();
		int x = d.width / 2 - ma / 2;
		int y = d.height / 2 - mi / 2;
		
		g.drawOval(x, y, ma, mi);
	}
}
