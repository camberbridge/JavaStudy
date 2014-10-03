import java.net.*;
import java.io.*;
import java.util.*;

//ServerSoftware(ServerSide)
//コマンドライン引数: ポート番号(クライアントからの要求を監視するソフトウェアポートを1つ指定)
public class ServerSocketDemo {
	public static void main(String args[]){
		try{
			int port = Integer.valueOf(args[0]).intValue();  //ポート番号の取得
			Random r = new Random();  //わざわざ乱数ジェネレータの生成
			ServerSocket ss = new ServerSocket(port);  //ServerSocketクラスのオブジェクト生成
			
			while(true){
				Socket s = ss.accept();  /*ソケット生成
				                          *ServerSocketクラスのインスタンスメソッド
				                          *クライアントからの要求待ち&受け取る
				                          *Socketクラス型オブジェクトを返す
				                          */
				OutputStream os = s.getOutputStream();  /*Socketクラスのインスタンスメソッド
				                                         *OutputStreamクラス型オブジェクト
				                                         *を返す
				                                         */
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeInt(r.nextInt());  //バイト出力ストリームに乱数(整数)を書き込む
				
				dos.close();
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
