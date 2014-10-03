import java.io.*;
import java.net.*;

//ClientSide
public class TCPRandomNumberClient {
	public static void main(String args[]){
		try{
			int port = Integer.valueOf(args[1]).intValue();
			String hostname = args[0];
			
			Socket s = new Socket(hostname, port);  //ソケット生成
			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			while(true){
				System.out.println(dis.readInt());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
