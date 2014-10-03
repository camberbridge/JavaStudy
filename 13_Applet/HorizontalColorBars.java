import java.awt.*;
import java.applet.*;
/*
 * <applet code="HorizontalColorBars" width=260 height=260>
 * </applet>
 */

public class HorizontalColorBars extends Applet{
	public void paint(Graphics g){
		Color color[] = {Color.black, Color.blue, Color.cyan,
			    Color.darkGray, Color.gray, Color.green, Color.lightGray,
			    Color.magenta, Color.orange, Color.pink, Color.red,
			    Color.white, Color.yellow};
		int interval = 260 / color.length;
		for(int i = 0; i < color.length; i++){
			g.setColor(color[i]);
			g.fillRect(0, i * interval, 260, interval);
		}
	}
}
