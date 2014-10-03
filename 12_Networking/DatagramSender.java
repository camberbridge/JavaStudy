import java.net.*;

//���M��
public class DatagramSender {
	public static void main(String args[]){
		try{
			InetAddress ia = InetAddress.getByName(args[0]);  /*����̃C���^�[�l�b�g
			                                                   *�A�h���X�̎擾
			                                                   */
			int port = Integer.valueOf(args[1]).intValue();  //�|�[�g�擾
			DatagramSocket ds = new DatagramSocket();  /*�f�[�^�O�����\�P�b�g�����B
			                                            *DatagramSocket�N���X�^�I�u�W�F�N�g
			                                            *�̐����B���p�\�Ȃ����ꂩ��port�ɁA
			                                            *�f�[�^�O�����\�P�b�g���o�C���h�B
			                                            */
			byte buffer[] = args[2].getBytes();  /*���M����f�[�^��byte�^�z�񐶐��B
			                                      *String�N���X�̃C���X�^���X���\�b�h(���݂�
			                                      *�I�u�W�F�N�g���܂ޕ�����byte�^�z���Ԃ�)
			                                      */
			
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length, ia, port);
			  //�f�[�^�O�����p�P�b�g�����BDatagramPacket�N���X�^�I�u�W�F�N�g�̐����B
			
			ds.send(dp);  //�f�[�^�O�����𑗐M
			
			ds.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
