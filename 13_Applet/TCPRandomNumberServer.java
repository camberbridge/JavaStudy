import java.io.*;
import java.net.*;
import java.util.*;

//ServerSide
public class TCPRandomNumberServer {
	static TCPBroadcastThread tcp = new TCPBroadcastThread();
	
	public static void main(String args[]){
		try{
			int port = Integer.valueOf(args[0]).intValue();
			ServerSocket ss = new ServerSocket(port);  //サーバーソケット生成
			new Thread(tcp).start();  
			  //スレッドスタート(クライアントに乱数をブロードキャストするために独立したスレッド)
			
			while(true){  //ソケット通信用無限ループ
				Socket s = ss.accept();  //ソケット生成
				OutputStream os = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				
				tcp.adder(dos);  //ブロードキャスト用スレッドに出力ストリームオブジェクトを与える
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

class TCPBroadcastThread implements Runnable{
	Vector<DataOutputStream> v = new Vector<DataOutputStream>();  //ベクトル生成
	
	void adder(DataOutputStream dos){
		v.add(dos);  //vectorクラスのインスタンスメソッド。ベクトルに出力ストリームオブジェクトをぶっ込む
	}
	
	public void run(){
		try{
			while(true){
				Thread.sleep(2000);
				int num = (int)(100 * Math.random());
				
				Enumeration<DataOutputStream> e = v.elements();
				while(e.hasMoreElements()){
					try{
						DataOutputStream dos = e.nextElement();
						dos.writeInt(num);  //出力ストリームに乱数を書き込む
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
				}
			}
		}
		catch(Exception e2){
			e2.printStackTrace();
		}
	}
}
