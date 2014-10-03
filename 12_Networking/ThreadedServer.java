import java.net.*;
import java.io.*;

//ServerSide
public class ThreadedServer {
	public static void main(String args[]){
		try{
			int port = Integer.valueOf(args[0]).intValue();  //ポート生成
			ServerSocket ss = new ServerSocket(port);  //サーバソケットの生成
			
			while(true){//ソケット通信何回も。の無限ループ
				Socket s = ss.accept();  //ソケットの生成。クライアントからの要求を受ける。受けるまで待機
				
				new Thread(new ServerThread(s)).start();  //スレッドの呼び出し
				/*ServerThread st = new ServerThread(s);
				*Thread t = new Thread(st)
				*t.start();
				**/
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

class ServerThread implements Runnable{
	private Socket s;
	private double total;
	
	ServerThread(Socket s){
		this.s = s;
		this.total = 0;
	}
	
	public void run(){  //入力/出力ストリームの処理
		try{
			InputStream is = s.getInputStream();  //読み取り用
			DataInputStream dis = new DataInputStream(is);
			OutputStream os = s.getOutputStream();  //書き込み用
			DataOutputStream dos = new DataOutputStream(os);
			
			while(true){  //ストリーム何回も。の無限ループ
				double value = dis.readDouble();  //クライアント(入力ストリーム)から値を読み取る
				this.total += value;
				dos.writeDouble(total);  //クライアント(出力ストリーム)に書き込む
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
