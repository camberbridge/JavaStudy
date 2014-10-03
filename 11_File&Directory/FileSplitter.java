import java.io.*;

//引数3つ -> 分割するファイル名 出力するファイル名 出力するファイルのサイズ(省略可)
//分割するファイル内のすべてのバイトを読み取るまで、分割生成する
public class FileSplitter {
	public static void main(String args[]){
		try{
			FileInputStream fis = new FileInputStream(args[0]);
			int size = 1024;  //バッファのサイズをの標準1024とする
			if(args.length > 2){  //引数3つ目を省略した場合、バッファサイズは標準の1024
				size = Integer.parseInt(args[2]);  //String型をint型に変換(String -> Integer -> int)
			}
			byte buffer[] = new byte[size]; //byte型の配列bufferが必要だから生成
			int i, count = 0;
			
			while((i = fis.read(buffer, 0, size)) != -1){  /*入力ストリームからsizeバイト、
			                                                *配列bufferに書き込む。
				                                            *iには正しく読み取った実際のバイト数。
			                                                *無い場合は、-1を返す。
			                                                */
				//出力ファイルを作成する
				String filename = args[1] + count;
				FileOutputStream fos = new FileOutputStream(filename);
				
				fos.write(buffer, 0, i);  //iには、バイト数はいっているからOK
				fos.flush();  /*出力ストリームをフラッシュする。つまり、内部バッファに格納されていた
				               *データが物理デバイスに書き込まれる。ここ重要。
				               *溜まっていたものがドーン
				               */
				fos.close();
				
				++count;
			}
			fis.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
