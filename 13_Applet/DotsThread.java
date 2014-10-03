import java.awt.*;
import java.applet.*;
/*
 * <applet code="DotsThread" width=250 height=250>
 * </applet>
 */

public class DotsThread extends Applet implements Runnable {
	private Thread t;
	
	public void init(){  //1番最初に呼ばれる
		t = new Thread(this);  //スレッド生成
		t.start();  //スレッドスタート
	}
	
	public void run(){  //スレッドの本処理を書く
		try{
			while(true){
				repaint();  //再描画
				
				Thread.sleep(200);  //0.2秒待機
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void update(Graphics g){  /*update()メソッドで既定の背景色でアプレットを塗りつぶす処理
	                                  *をさせずにpaint()メソッドを呼び出すことで、前の描画を
	                                  *残したまま上書きする。
	                                  */
		paint(g);  //paint()メソッドの呼び出し
	}
	
	public void paint(Graphics g){
		Dimension d = getSize();
		int x = (int)(Math.random() * d.width);
		int y = (int)(Math.random() * d.height);
		g.fillRect(x, y, 2, 2);
	}
}
