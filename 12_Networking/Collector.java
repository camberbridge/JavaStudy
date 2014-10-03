import java.net.*;

//DatagramReceiverSide
public class Collector {
	private static final int n = 20;
	
	public static void main(String args[]){
		try{
			int port = Integer.valueOf(args[0]).intValue();
			DatagramSocket ds = new DatagramSocket(port);  //�f�[�^�O�����\�P�b�g����
			byte buffer[] = new byte[n];  //��M�����f�[�^��ێ�����byte�^�z�񐶐�
			
			while(true){
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length);  //�f�[�^�O�����p�P�b�g����
				
				ds.receive(dp);  //�f�[�^�O�������󂯎��B�󂯎��܂őҋ@
				
				String s = new String(dp.getData());  //�f�[�^�O�����p�P�b�g����f�[�^�𓾂�
				System.out.println(s);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
