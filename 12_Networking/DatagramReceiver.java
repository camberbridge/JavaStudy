import java.net.*;

//受信側
public class DatagramReceiver {
	private static final int BUFSIZE = 20;
	
	public static void main(String args[]){
		try{
			int port = Integer.valueOf(args[0]).intValue();  //ポート番号取得
			DatagramSocket ds = new DatagramSocket(port);  /*データグラムソケット生成。
			                                                *DatagramSocketクラス型
			                                                *オブジェクトの生成。
			                                                *指定portに、データグラム
			                                                *ソケットをバインド。
			                                                */
			byte buffer[] = new byte[BUFSIZE];  //着信したデータを保持するbyte型配列を生成
			
			while(true){
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length);  
				  //データグラムパケットの生成。DatagramPacketクラス型オブジェクトの生成
				
				ds.receive(dp); /*データを受け取る。DatagramSocketクラスのインスタンスメソッド。
				                 *データグラムを受け取るまで、待機
				                 */	
				String s = new String(dp.getData());  //データグラムパケットからデータを受け取る
				 
				System.out.println(s);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
