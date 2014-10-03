import java.io.*;

public class TabFilter {
	public static void main(String args[]){
		try{
			FileReader fr = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(args[1]);
			BufferedWriter bw = new BufferedWriter(fw);
			String s;
			StringBuffer sb;
			
			while((s = br.readLine()) != null){  //1行ずつ読み取る
				sb = new StringBuffer();  //StringBufferクラス型オブジェクトの初期化
				for(int i = 0; i < s.length(); i++){
					char c = s.charAt(i);  //iで指定された位置の文字を返す
					
					if(c == '\t'){  //タブ文字判定
						c = ' ';  //タブ文字toスペース文字
					}
					
					sb.append(c);  //StringBufferオブジェクトに、cを付加していく
				}
				s = sb.toString() + "\n";  //StringBufferオブジェクトの文字列をString型で返す
				bw.write(s, 0, s.length());  //bw.write(s);でもよい  
				//ストリームに位置0を先頭として、Stringオブジェクトs内のs.length()字分を書き込む
			}
				
				br.close();
				bw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
