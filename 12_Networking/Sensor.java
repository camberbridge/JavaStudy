import java.net.*;

//DatagramSenderSide
public class Sensor {
	public static void main(String args[]){
		try{
			InetAddress ia = InetAddress.getByName(args[0]);  //インターネットアドレスの取得　
			int port = Integer.valueOf(args[1]).intValue();  //ポートの取得
			
			DatagramSocket ds = new DatagramSocket();  //データグラムソケット生成。利用可能portにバインド
			byte buffer[];  //送信するデータのbyte型配列生成
			
			while(true){
				int value = (int)(10 * Math.random());
				String s = "" + value;  //""は、int型をString型にキャストするためのテクニック
				System.out.println("Sensor value is " + s);
				
				buffer = s.getBytes();  //String型文字列のbyte型配列を返す
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length, ia, port);  //データグラムパケット生成
				
				ds.send(dp);  //データグラムの送信
				
				Thread.sleep(7000);  //7秒間待機
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
