import java.net.*;

//DatagramSenderSide
public class Sensor {
	public static void main(String args[]){
		try{
			InetAddress ia = InetAddress.getByName(args[0]);  //�C���^�[�l�b�g�A�h���X�̎擾�@
			int port = Integer.valueOf(args[1]).intValue();  //�|�[�g�̎擾
			
			DatagramSocket ds = new DatagramSocket();  //�f�[�^�O�����\�P�b�g�����B���p�\port�Ƀo�C���h
			byte buffer[];  //���M����f�[�^��byte�^�z�񐶐�
			
			while(true){
				int value = (int)(10 * Math.random());
				String s = "" + value;  //""�́Aint�^��String�^�ɃL���X�g���邽�߂̃e�N�j�b�N
				System.out.println("Sensor value is " + s);
				
				buffer = s.getBytes();  //String�^�������byte�^�z���Ԃ�
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length, ia, port);  //�f�[�^�O�����p�P�b�g����
				
				ds.send(dp);  //�f�[�^�O�����̑��M
				
				Thread.sleep(7000);  //7�b�ԑҋ@
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
