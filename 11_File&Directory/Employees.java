import java.io.*;
import java.util.*;

public class Employees {
	public static void main(String args[]){
		try{
			FileReader fr = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(fr);
			StringTokenizer st;
			String s;
			
			while((s = br.readLine()) != null){
				st = new StringTokenizer(s, ";");
				
				//à»â∫ÅA3éÌóﬁÇÃèoóÕï˚ñ@
				System.out.println("Name: " + st.nextToken());
				System.out.format("Location: %s\n", st.nextElement());
				System.out.format("Phons: %s\n\n", st.nextToken());
				
			}
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
