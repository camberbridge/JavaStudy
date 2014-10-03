import java.io.*;

//複数ファイルを、1つのファイルに
//コマンドライン引数 -> 読み取りファイル名 出力ファイル名
public class FileMarger {
	private static final int n = 1024;  //標準バッファサイズ
	
	public static void main(String args[]){
		try{
			FileOutputStream fos = new FileOutputStream(args[1]);
			
			byte buffer[] = new byte[n];  //配列(バッファ)生成
			int i, count = 0;
			
			//入力ファイルからのデータを処理する
			while(true){
				String filename = args[0] + count;
				FileInputStream fis;
				
				try{
					fis = new FileInputStream(filename);
				}
				catch(FileNotFoundException e){  //読み取るファイルが無くなったら、ループを抜ける
					break;
				}
				
				while((i = fis.read(buffer, 0, n)) != -1){  /*配列bufferに書き込む
				                                             *iには正しく読み取ったバイト数
				                                             *無い場合は、-1
				                                             */
					fos.write(buffer, 0, i);  //配列bufferに格納されているiバイトをストリームに書き込む
					fos.flush();   //一回一回溜まっていたものドーン
				}
				fis.close();
				
				++count;
			}
			//fos.flush();  //ドーンするのは最後でもよい ∵すべてストリームに格納してあるから
			fos.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
