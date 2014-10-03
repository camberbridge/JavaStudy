import java.io.*;
import java.net.*;

//ClientSide
public class AdderClient {
	public static void main(String args[]){
		try{
			int port = Integer.valueOf(args[1]).intValue();  //ポート番号の取得
			String hostname = args[0];  //ホストネームの取得
			Socket s = new Socket(hostname, port);  //ソケット生成
			//ソケット用の入力/出力ストリーム
			InputStream is = s.getInputStream();  //読み取り用
			DataInputStream dis = new DataInputStream(is);
			OutputStream os = s.getOutputStream();  //書き込み用
			DataOutputStream dos = new DataOutputStream(os);
			
			//ユーザのコンソール上からの入力をストリームする。ユーザインタフェース用のストリーム
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			while(true){  //ソケット通信何回も。の無限ループ
				System.out.println("Input number: ");
				String str = br.readLine();  //改行終端文字まで、1行読み取り、String型オブジェクトsに格納
				double d = Double.valueOf(str).doubleValue();  //String型 -> double型
				
				dos.writeDouble(d);  //サーバにデータを送信
				
				double total = dis.readDouble();  //サーバからのデータを受信&読み取る
				
				System.out.println(total);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
