import java.net.*;

//送信側
public class DatagramSender {
	public static void main(String args[]){
		try{
			InetAddress ia = InetAddress.getByName(args[0]);  /*宛先のインターネット
			                                                   *アドレスの取得
			                                                   */
			int port = Integer.valueOf(args[1]).intValue();  //ポート取得
			DatagramSocket ds = new DatagramSocket();  /*データグラムソケット生成。
			                                            *DatagramSocketクラス型オブジェクト
			                                            *の生成。利用可能ないずれかのportに、
			                                            *データグラムソケットをバインド。
			                                            */
			byte buffer[] = args[2].getBytes();  /*発信するデータのbyte型配列生成。
			                                      *Stringクラスのインスタンスメソッド(現在の
			                                      *オブジェクトを含む文字のbyte型配列を返す)
			                                      */
			
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length, ia, port);
			  //データグラムパケット生成。DatagramPacketクラス型オブジェクトの生成。
			
			ds.send(dp);  //データグラムを送信
			
			ds.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
