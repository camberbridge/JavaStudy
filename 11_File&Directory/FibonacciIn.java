import java.io.*;

public class FibonacciIn {
	public static void main(String args[]){
		try{
			FileInputStream fis = new FileInputStream(args[0]);
			DataInputStream dis = new DataInputStream(fis);
			
			for(int i = 0; i < 15; i++){
				System.out.format("%3d\n", dis.readShort());
			}
			System.out.println("");
			
			fis.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
