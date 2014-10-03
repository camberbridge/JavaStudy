import java.io.*;

public class LetterCounter {
	private static final int n = 26;
	
	public static void main(String args[]){
		try{
			int count[] = new int[n];
			String s;
			FileReader fr = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(fr);
			
			//•¶š‚ğ“Ç‚İæ‚é
			while((s = br.readLine()) != null){  //1s‚¸‚Â
				char c[] = s.toCharArray();  //StringŒ^•¶š—ñ‚ğA1•¶š‚¸‚ÂcharŒ^”z—ñ‚É•ÏŠ·
				for(int i = 0; i < c.length; i++){
					int k = Character.toLowerCase(c[i])/*‰pš‚ğ‰p¬•¶š‚É•ÏŠ·*/ - 'a';  
					if(k >= 0 && k < n){
						++count[k];
					}
				}
			}
			
			//•¶š‚ğ•\¦‚·‚é
			for(int j = 0; j < n; j++){
				char c = (char)('a' + j);
				System.out.print(c + "=");
				System.out.print(count[j] + "; ");
			}
			System.out.println("");
			
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
