import java.awt.*;
import java.applet.*;
/*
 * <applet code="DrawImage" width=400 height=400>
 * <param name="file" value="sphere.jpg">
 * </applet>
 */

public class DrawImage extends Applet {
	Image img;
	public void init(){
		img = getImage(getDocumentBase(), getParameter("file"));
	}
	public void paint(Graphics g){
		g.drawImage(img, 0, 0, this/*new DrawImage()*/);
	}
}
