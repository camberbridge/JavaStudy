import java.net.*;
import java.io.*;

//ClientSide
public class SquareClient {
	public static void main(String args[]){
		try{
			int port = Integer.valueOf(args[1]).intValue();
			String hostname = args[0];
			double d = Double.valueOf(args[2]).doubleValue();
			Socket s = new Socket(hostname, port);  //ソケット生成
						
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			dos.writeDouble(d);
			
			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			System.out.println(dis.readDouble());
			
			dos.close();
			dis.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
