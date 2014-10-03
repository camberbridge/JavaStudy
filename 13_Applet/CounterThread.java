import java.awt.*;
import java.applet.*;
/*
 * <applet code="CounterThread" width=250 height=100>
 * </applet>
 */

public class CounterThread extends Applet implements Runnable {
	private int counter;
	private Thread t;
	
	public void init(){  //1番最初に呼び出される
		counter = 0;  //初期化
		
		t = new Thread(this);  //スレッド生成
		t.start();  //スレッドスタート
	}
	
	public void run(){  
		try{
			while(true){
				repaint();  //再描画(背景色を指定しないので、背景は既定色で再描画)
				
				Thread.sleep(1000);  //1秒待機
				
				++counter;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g){
		g.setFont(new Font("Serif", Font.BOLD, 36));  //フォントの設定
		FontMetrics fm = g.getFontMetrics();  //フォントメトリックスの取得
		
		String s = "" + counter;  //""は、int型の整数をString型にキャストするための因子
		Dimension d = getSize();
		int x = d.width / 2 - fm.stringWidth(s) / 2;
		g.drawString(s, x, d.height / 2);
	}
}
