import java.io.*;
import java.util.*;

public class FileSlice {
	public static void main(String args[]){
		try{
			FileReader fr = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(fr);
			int f1 = Integer.valueOf(args[1]).intValue();
			int f2 = Integer.valueOf(args[2]).intValue();
			String s, output;
			int f;
			
			while((s = br.readLine()) != null){
				StringTokenizer st = new StringTokenizer(s);
				f = 0;
				output = "";
				
				while(st.hasMoreElements()){
					++f;
					String token = st.nextToken();
					if(f >= f1 && f <= f2){
						output += token + " ";
					}
				}
				System.out.println(output);
			}
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
