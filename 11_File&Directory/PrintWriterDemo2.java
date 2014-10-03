import java.io.*;

public class PrintWriterDemo2 {
	public static void main(String args[]){
		try{
			FileWriter fw = new FileWriter(args[0]);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw, false); //明示的に、フラッシュさせない
			
			pw.println(true);
		    pw.println('A');
		    pw.println(500);
		    pw.println(40000L);
		    pw.println(45.67f);
		    pw.println(45.67);
		    pw.println("Hello");
		    pw.println(new Integer("99"));
			
		    pw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
