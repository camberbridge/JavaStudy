import java.io.*;

public class DigitCounter {
	public static void main(String args[]){
		try{
			FileReader fr = new FileReader(args[0]);
			int count[] = new int[10];  //各数字のカウント保持用配列
			int i, k;  //読み取り文字格納用変数
			char c;
			
			while((i = fr.read()) != -1){
				c = (char)i;
				k = c - '0';
				if(k >= 0 && k < 10){
					++count[k];
				}
			}
			
			for(int j = 0; j < count.length; j++){
				c = (char)('0' + j);
				System.out.print(c + "=");
				System.out.println(count[j] + ": ");
			}
			System.out.println("");
			
			fr.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
