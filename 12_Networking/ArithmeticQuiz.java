import java.io.*;

public class ArithmeticQuiz {
	static BufferedReader br;
	
	public static void main(String args[]){
		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			
			while(true){
				//適当なオペランドと演算子を生成
				String q;
				int a;
				int i = (int)(12 * Math.random());
				int j = (int)(12 * Math.random());
				int op = (int)(2 * Math.random());
				
				if(op > 1){
					q = i + " + " + j + "?";
					a = i + j;
					question(q, a);
				}else{
					q = i + " - " + j + "?";
					a = i - j;
					question(q, a);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static void question(String q, int a) throws IOException{
		System.out.println(q);
		String s = br.readLine();
		int answer = Integer.valueOf(s).intValue();
		
		if(answer == a){
			System.out.println("Correct!!");
		}else{
			System.out.println("Incorrect!!\n" + "The answer is " + a);
		}
		//問題ループさせるから、br.close(); しないよ
	}
}
