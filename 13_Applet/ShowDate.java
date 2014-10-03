import java.applet.*;
import java.awt.*;
import java.util.*;
/*
 * <applet code="ShowDate" width=200 height=200>
 * </applet>
 */

public class ShowDate extends Applet{
	GregorianCalendar gc = new GregorianCalendar();
	String months[] = {"January", "February", "March",
		    "April", "May", "June",
		    "July", "August", "September",
		    "October", "November", "December" };
	
	public void paint(Graphics g){
		int month = gc.get(Calendar.MONTH);
		System.out.println(month);
		int date = gc.get(Calendar.DATE);
		int year = gc.get(Calendar.YEAR);
		String s = months[month] + " " + date + " " + year;
		Font f = getFont();
		FontMetrics fm = getFontMetrics(f);
		Dimension d = getSize();
		int x = (d.width - fm.stringWidth(s)) / 2;
		int y = d.height / 2;
		g.drawString(s, x, y);
		
		showStatus(s);
	}
}
