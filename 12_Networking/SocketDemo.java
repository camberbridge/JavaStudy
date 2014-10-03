import java.io.*;
import java.net.*;

//ClientSoftware(ClientSide)
//�R�}���h���C������: �T�[�o�[�̖��O_�|�[�g�ԍ�
public class SocketDemo {
	public static void main(String args[]){
		try{
			String server = args[0];  //�T�[�o(�z�X�g)�l�[���̎擾
			int port = Integer.valueOf(args[1]).intValue();  //�|�[�g�ԍ��̎擾
			Socket s = new Socket(server, port);  //�\�P�b�g�����ASocket�N���X�̃I�u�W�F�N�g����
			
			InputStream is = s.getInputStream();  /*Socket�N���X�̃C���X�^���X���\�b�h
			                                       *InputStream�N���X�^�I�u�W�F�N�g��
			                                       *�Ԃ�
			                                       */
			DataInputStream dis = new DataInputStream(is);
			int i = dis.readInt();  //�o�C�g���̓X�g���[�����琮����ǂݎ��
			
			System.out.println(i);
			
			dis.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
