import java.io.*;

public class FileWriterDemo {
	public static void main(String args[]){
		try{
			FileWriter fw = new FileWriter(args[0]);  //FileWriterクラス型オブジェクトの生成
			
			for(int i = 0; i < 12; i++){  //ファイルに文字列を書き込む
				fw.write("Line " + i + "\n");  //writeクラスのインスタンスメソッド
				                               //ストリームに書き込む
			}
			fw.close();  //FileWriterオブジェクトをクローズ
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
