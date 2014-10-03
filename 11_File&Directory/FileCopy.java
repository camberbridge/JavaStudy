import java.io.*;

public class FileCopy {
	public static void main(String args[]){
		try{
			FileReader fr = new FileReader(args[0]);
			FileWriter fw = new FileWriter(args[1]);
			int i;
			
			while((i = fr.read()) != -1){
				//fw.write((char)i); �ł��悢
				fw.write(i);
			}
			
			fw.close();
			fr.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
