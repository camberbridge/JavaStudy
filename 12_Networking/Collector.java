import java.net.*;

//DatagramReceiverSide
public class Collector {
	private static final int n = 20;
	
	public static void main(String args[]){
		try{
			int port = Integer.valueOf(args[0]).intValue();
			DatagramSocket ds = new DatagramSocket(port);  //データグラムソケット生成
			byte buffer[] = new byte[n];  //受信したデータを保持するbyte型配列生成
			
			while(true){
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length);  //データグラムパケット生成
				
				ds.receive(dp);  //データグラムを受け取る。受け取るまで待機
				
				String s = new String(dp.getData());  //データグラムパケットからデータを得る
				System.out.println(s);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
