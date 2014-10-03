import java.net.*;

//��M��
public class DatagramReceiver {
	private static final int BUFSIZE = 20;
	
	public static void main(String args[]){
		try{
			int port = Integer.valueOf(args[0]).intValue();  //�|�[�g�ԍ��擾
			DatagramSocket ds = new DatagramSocket(port);  /*�f�[�^�O�����\�P�b�g�����B
			                                                *DatagramSocket�N���X�^
			                                                *�I�u�W�F�N�g�̐����B
			                                                *�w��port�ɁA�f�[�^�O����
			                                                *�\�P�b�g���o�C���h�B
			                                                */
			byte buffer[] = new byte[BUFSIZE];  //���M�����f�[�^��ێ�����byte�^�z��𐶐�
			
			while(true){
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length);  
				  //�f�[�^�O�����p�P�b�g�̐����BDatagramPacket�N���X�^�I�u�W�F�N�g�̐���
				
				ds.receive(dp); /*�f�[�^���󂯎��BDatagramSocket�N���X�̃C���X�^���X���\�b�h�B
				                 *�f�[�^�O�������󂯎��܂ŁA�ҋ@
				                 */	
				String s = new String(dp.getData());  //�f�[�^�O�����p�P�b�g����f�[�^���󂯎��
				 
				System.out.println(s);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
