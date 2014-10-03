import java.net.*;
import java.io.*;

//ServerSide
public class ThreadedServer {
	public static void main(String args[]){
		try{
			int port = Integer.valueOf(args[0]).intValue();  //�|�[�g����
			ServerSocket ss = new ServerSocket(port);  //�T�[�o�\�P�b�g�̐���
			
			while(true){//�\�P�b�g�ʐM������B�̖������[�v
				Socket s = ss.accept();  //�\�P�b�g�̐����B�N���C�A���g����̗v�����󂯂�B�󂯂�܂őҋ@
				
				new Thread(new ServerThread(s)).start();  //�X���b�h�̌Ăяo��
				/*ServerThread st = new ServerThread(s);
				*Thread t = new Thread(st)
				*t.start();
				**/
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

class ServerThread implements Runnable{
	private Socket s;
	private double total;
	
	ServerThread(Socket s){
		this.s = s;
		this.total = 0;
	}
	
	public void run(){  //����/�o�̓X�g���[���̏���
		try{
			InputStream is = s.getInputStream();  //�ǂݎ��p
			DataInputStream dis = new DataInputStream(is);
			OutputStream os = s.getOutputStream();  //�������ݗp
			DataOutputStream dos = new DataOutputStream(os);
			
			while(true){  //�X�g���[��������B�̖������[�v
				double value = dis.readDouble();  //�N���C�A���g(���̓X�g���[��)����l��ǂݎ��
				this.total += value;
				dos.writeDouble(total);  //�N���C�A���g(�o�̓X�g���[��)�ɏ�������
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
