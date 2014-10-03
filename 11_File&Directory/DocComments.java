/** Documentation comment */
/** Multiple */ /** Documentation comments */ /** in one line */

import java.io.*;

public class DocComments {
	public static void main(String args[]){
		try{
			FileReader fr = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(fr);
			boolean display = false;
			String s;
			
			while((s = br.readLine()) != null){
				char array[] = s.toCharArray();  //StringŒ^”z—ñ‚ğcharŒ^”z—ñ‚É
				int len = array.length;
				int i = 0;
				
				while(true){
					if(i >= len){
						break;
					}
					if(array[i] == '/'){
						if((i + 1) < len && array[i + 1]  == '*'){
							if((i + 2) < len && array[i + 2] == '*'){
								i += 3;
								display = true;
								continue;
							}
						}
					}else if(array[i] == '*'){
						if((i + 1) < len && array[i + 1] == '/'){
							System.out.println("");
							i += 2;
							display = false;
							continue;
						}
					}
					if(display){
						System.out.print(array[i]);
					}
					++i;
				}
			}
			br.close();
			return;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}