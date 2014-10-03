import java.io.*;

public class ReadConsole {
	public static void main(String args[]){
		try{
			InputStreamReader isr = new InputStreamReader(System.in);  /*InputStreamReader
			                                                            *オブジェクトの生成。
			                                                            *System.inは、
			                                                            *Systemクラスの静的
			                                                            *変数で、InputStream
			                                                            *オブジェクトへの参照
			                                                            *が入っている。
			                                                            */
			BufferedReader br = new BufferedReader(isr);
			String s;
			
			while((s = br.readLine()) != null){  //文字ストリームバッファから、改行終端文字列を読み取る
				System.out.println(s.length());
			}
			
			br.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
