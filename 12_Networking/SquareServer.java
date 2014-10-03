import java.net.*;
import java.io.*;

//ServerSide
public class SquareServer {
	public static void main(String args[]){
		try{
			int port = Integer.valueOf(args[0]).intValue();
			ServerSocket ss = new ServerSocket(port);
			
			while(true){
				Socket s = ss.accept();  //�\�P�b�g�����A�N���C�A���g����̗v���҂�&�󂯎��
				
				//�N���C�A���g����̒l��ǂݎ��
				InputStream is = s.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				double value = dis.readDouble();
				
				//�N���C�A���g����ǂݎ�����f�[�^�̏���
				value *= value; //value * value
				
				//�����̌��ʂ��N���C�A���g�ɏ�������
				OutputStream os = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeDouble(value);
				
				dis.close();
				dos.close();
			}	
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
