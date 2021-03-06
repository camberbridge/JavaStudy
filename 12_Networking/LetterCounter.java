import java.io.*;

public class LetterCounter {
	private static final int n = 26;
	
	public static void main(String args[]){
		try{
			int count[] = new int[n];
			String s;
			FileReader fr = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(fr);
			
			//文字を読み取る
			while((s = br.readLine()) != null){  //1行ずつ
				char c[] = s.toCharArray();  //String型文字列を、1文字ずつchar型配列に変換
				for(int i = 0; i < c.length; i++){
					int k = Character.toLowerCase(c[i])/*英字を英小文字に変換*/ - 'a';  
					if(k >= 0 && k < n){
						++count[k];
					}
				}
			}
			
			//文字を表示する
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
