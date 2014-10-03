import java.net.*;

//éÛêMë§
public class DatagramReceiver2 {
	private static final int n = 20;
	
	public static void main(String args[]){
		try{
			int port = Integer.valueOf(args[0]).intValue();
			DatagramSocket ds = new DatagramSocket(port);
			byte buffer[] = new byte[n];
			
			while(true){
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
				ds.receive(dp);
				
				InetAddress ia = dp.getAddress();
				int machinePort = dp.getPort();
				System.out.println(ia);
				System.out.println(dp.getAddress());
				System.out.println(machinePort);
				System.out.println(dp.getPort());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
