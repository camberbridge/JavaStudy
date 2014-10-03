import java.net.*;
import java.io.*;

//ServerSide
public class SquareServer {
	public static void main(String args[]){
		try{
			int port = Integer.valueOf(args[0]).intValue();
			ServerSocket ss = new ServerSocket(port);
			
			while(true){
				Socket s = ss.accept();  //ソケット生成、クライアントからの要求待ち&受け取る
				
				//クライアントからの値を読み取る
				InputStream is = s.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				double value = dis.readDouble();
				
				//クライアントから読み取ったデータの処理
				value *= value; //value * value
				
				//処理の結果をクライアントに書き込む
				OutputStream os = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeDouble(value);
				
				dis.close();
				dos.close();
			}	
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
