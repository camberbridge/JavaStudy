import java.awt.*;
import java.applet.*;
/*
 * <applet code="DotsThread" width=250 height=250>
 * </applet>
 */

public class DotsThread extends Applet implements Runnable {
	private Thread t;
	
	public void init(){  //1�ԍŏ��ɌĂ΂��
		t = new Thread(this);  //�X���b�h����
		t.start();  //�X���b�h�X�^�[�g
	}
	
	public void run(){  //�X���b�h�̖{����������
		try{
			while(true){
				repaint();  //�ĕ`��
				
				Thread.sleep(200);  //0.2�b�ҋ@
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void update(Graphics g){  /*update()���\�b�h�Ŋ���̔w�i�F�ŃA�v���b�g��h��Ԃ�����
	                                  *����������paint()���\�b�h���Ăяo�����ƂŁA�O�̕`���
	                                  *�c�����܂܏㏑������B
	                                  */
		paint(g);  //paint()���\�b�h�̌Ăяo��
	}
	
	public void paint(Graphics g){
		Dimension d = getSize();
		int x = (int)(Math.random() * d.width);
		int y = (int)(Math.random() * d.height);
		g.fillRect(x, y, 2, 2);
	}
}
