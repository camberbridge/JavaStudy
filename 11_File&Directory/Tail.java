import java.io.*;

//コマンドライン引数 -> ファイル名　バイト数
public class Tail {
	public static void main(String args[]){
		try{
			RandomAccessFile raf = new RandomAccessFile(args[0], "r");  //ファイル名, オプション
			long count = Long.valueOf(args[1]).longValue();  //String => Long
			long position = raf.length();  //ファイル内のバイト数を返す
			
			position -= count;
			if(position < 0){
				position = 0;
			}
			raf.seek(position);  //ファイルポインタを位置づけ
			
			while(true){
				try{
					byte b = raf.readByte();  //位置づけたファイルポインタの位置からバイトを取得　
					
					System.out.print((char)(b));
				}
				catch(IOException e){
					break;
				}
			}
			raf.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
