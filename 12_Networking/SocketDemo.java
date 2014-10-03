import java.io.*;
import java.net.*;

//ClientSoftware(ClientSide)
//コマンドライン引数: サーバーの名前_ポート番号
public class SocketDemo {
	public static void main(String args[]){
		try{
			String server = args[0];  //サーバ(ホスト)ネームの取得
			int port = Integer.valueOf(args[1]).intValue();  //ポート番号の取得
			Socket s = new Socket(server, port);  //ソケット生成、Socketクラスのオブジェクト生成
			
			InputStream is = s.getInputStream();  /*Socketクラスのインスタンスメソッド
			                                       *InputStreamクラス型オブジェクトを
			                                       *返す
			                                       */
			DataInputStream dis = new DataInputStream(is);
			int i = dis.readInt();  //バイト入力ストリームから整数を読み取る
			
			System.out.println(i);
			
			dis.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
