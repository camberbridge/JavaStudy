import java.awt.*;
import java.applet.*;
/*
 * <applet code="CounterThread" width=250 height=100>
 * </applet>
 */

public class CounterThread extends Applet implements Runnable {
	private int counter;
	private Thread t;
	
	public void init(){  //1�ԍŏ��ɌĂяo�����
		counter = 0;  //������
		
		t = new Thread(this);  //�X���b�h����
		t.start();  //�X���b�h�X�^�[�g
	}
	
	public void run(){  
		try{
			while(true){
				repaint();  //�ĕ`��(�w�i�F���w�肵�Ȃ��̂ŁA�w�i�͊���F�ōĕ`��)
				
				Thread.sleep(1000);  //1�b�ҋ@
				
				++counter;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g){
		g.setFont(new Font("Serif", Font.BOLD, 36));  //�t�H���g�̐ݒ�
		FontMetrics fm = g.getFontMetrics();  //�t�H���g���g���b�N�X�̎擾
		
		String s = "" + counter;  //""�́Aint�^�̐�����String�^�ɃL���X�g���邽�߂̈��q
		Dimension d = getSize();
		int x = d.width / 2 - fm.stringWidth(s) / 2;
		g.drawString(s, x, d.height / 2);
	}
}
