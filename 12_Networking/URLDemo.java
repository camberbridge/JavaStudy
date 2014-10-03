import java.net.*;
import java.io.*;

public class URLDemo {
	public static void main(String args[]){
		try{
			URL url = new URL(args[0]);
			InputStream is = url.openStream();
			byte buffer[] = new byte[1024];
			int i;
			
			while((i = is.read(buffer)) != -1){
				System.out.write(buffer, 0, i);
				System.out.println("•¶Žš" + i + "ŒÂ“Ç‚ÝŽæ‚Á‚½");
			}
			
			String protocol = url.getProtocol(), host = url.getHost(), file = url.getFile();
			int port = url.getPort();
			
			System.out.println("URL = " + url + "\n" + "protocol = " + protocol + "\n" + 
								"host = " + host + "\n" + "port = " + port + "\n" + 
								"file = " + file + "\n");
			
			is.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
