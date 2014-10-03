import java.io.*;
import java.net.*;
import java.util.*;

//ServerSide
public class TCPRandomNumberServer {
	static TCPBroadcastThread tcp = new TCPBroadcastThread();
	
	public static void main(String args[]){
		try{
			int port = Integer.valueOf(args[0]).intValue();
			ServerSocket ss = new ServerSocket(port);  //�T�[�o�[�\�P�b�g����
			new Thread(tcp).start();  
			  //�X���b�h�X�^�[�g(�N���C�A���g�ɗ������u���[�h�L���X�g���邽�߂ɓƗ������X���b�h)
			
			while(true){  //�\�P�b�g�ʐM�p�������[�v
				Socket s = ss.accept();  //�\�P�b�g����
				OutputStream os = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				
				tcp.adder(dos);  //�u���[�h�L���X�g�p�X���b�h�ɏo�̓X�g���[���I�u�W�F�N�g��^����
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

class TCPBroadcastThread implements Runnable{
	Vector<DataOutputStream> v = new Vector<DataOutputStream>();  //�x�N�g������
	
	void adder(DataOutputStream dos){
		v.add(dos);  //vector�N���X�̃C���X�^���X���\�b�h�B�x�N�g���ɏo�̓X�g���[���I�u�W�F�N�g���Ԃ�����
	}
	
	public void run(){
		try{
			while(true){
				Thread.sleep(2000);
				int num = (int)(100 * Math.random());
				
				Enumeration<DataOutputStream> e = v.elements();
				while(e.hasMoreElements()){
					try{
						DataOutputStream dos = e.nextElement();
						dos.writeInt(num);  //�o�̓X�g���[���ɗ�������������
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
				}
			}
		}
		catch(Exception e2){
			e2.printStackTrace();
		}
	}
}
