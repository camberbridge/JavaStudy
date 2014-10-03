import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/*
 * <applet code="MouseMotionEvent" width=300 height=300>
 * </applet>
 */

public class MouseMotionEvents extends Applet 
	implements MouseListener, MouseMotionListener {  /*マウスイベントを受けられるクラスにする*/
		Point point;  //ポイントオブジェクト宣言
		
		public void init(){
			addMouseListener(this);  //マウスイベントの登録
			addMouseMotionListener(this);
		}
		
		public void mouseClicked(MouseEvent me){
		}
		
		public void mouseEntered(MouseEvent me){
			setBackground(Color.green);
			repaint();
		}
		
		public void mouseExited(MouseEvent me){
		}
		
		public void mousePressed(MouseEvent me){
			point = me.getPoint();  
			repaint();
		}

		public void mouseReleased(MouseEvent me){
			point = null; 
			repaint();
		}
		
		public void mouseDragged(MouseEvent me){
			point = me.getPoint();
			repaint();
		}
		
		public void mouseMoved(MouseEvent me){
		}
		
		public void paint(Graphics g){
			if(point != null){
				Dimension d = getSize();
				int xc = d.width / 2;
				int yc = d.height / 2;
				g.drawLine(xc, yc, point.x, point.y);
			}
		}
}
