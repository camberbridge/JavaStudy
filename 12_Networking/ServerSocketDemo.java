import java.net.*;
import java.io.*;
import java.util.*;

//ServerSoftware(ServerSide)
//�R�}���h���C������: �|�[�g�ԍ�(�N���C�A���g����̗v�����Ď�����\�t�g�E�F�A�|�[�g��1�w��)
public class ServerSocketDemo {
	public static void main(String args[]){
		try{
			int port = Integer.valueOf(args[0]).intValue();  //�|�[�g�ԍ��̎擾
			Random r = new Random();  //�킴�킴�����W�F�l���[�^�̐���
			ServerSocket ss = new ServerSocket(port);  //ServerSocket�N���X�̃I�u�W�F�N�g����
			
			while(true){
				Socket s = ss.accept();  /*�\�P�b�g����
				                          *ServerSocket�N���X�̃C���X�^���X���\�b�h
				                          *�N���C�A���g����̗v���҂�&�󂯎��
				                          *Socket�N���X�^�I�u�W�F�N�g��Ԃ�
				                          */
				OutputStream os = s.getOutputStream();  /*Socket�N���X�̃C���X�^���X���\�b�h
				                                         *OutputStream�N���X�^�I�u�W�F�N�g
				                                         *��Ԃ�
				                                         */
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeInt(r.nextInt());  //�o�C�g�o�̓X�g���[���ɗ���(����)����������
				
				dos.close();
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
