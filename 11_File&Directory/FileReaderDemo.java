import java.io.*;

public class FileReaderDemo {
	public static void main(String args[]){
		try{
			FileReader fr = new FileReader(args[0]);  //FileReaderクラス型オブジェクトの生成
			int i;
			
			while((i = fr.read()) != -1){  //文字を読み取って、表示する
				System.out.print((char)i);
			}
			
			//FileReaderオブジェクトをクローズする
			fr.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
