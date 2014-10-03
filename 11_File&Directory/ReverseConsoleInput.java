import java.io.*;

public class ReverseConsoleInput {
	public static void main(String args[]){
		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String s;
		
			while((s = br.readLine()) != null){
				for(int i = s.length() - 1; i >= 0; i--){
					char c = s.charAt(i);
					System.out.print(c);
				}
				System.out.println("");
			}
			
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
