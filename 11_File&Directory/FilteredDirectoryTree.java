import java.io.*;

//コマンドライン引数 -> ファイル名 拡張子
public class FilteredDirectoryTree {
	static File f;
	public static void main(String args[]){
		f = new File(args[0]);
		if((!f.exists() ) || (args.length < 1 || args.length > 2)){
			System.out.println("FileNotFound");
		}else{
			tree(args[0], args[1]);
		}
	}
	
	public static void tree(String filename, String s){
		f = new File(filename);
		
		if(f.isFile()){  //ファイルの場合
			if(filename.endsWith(s)){  //現在のString型オブジェクトの中身が、String型オブジェクトsと同じなら真
				System.out.println(f);
			}
		}else{  //ディレクトリの場合
			String files[] = f.list();  //File型オブジェクトのディレクトリ内のファイルをString型配列で返す
			for(int i = 0; i < files.length; i++){
				tree(filename + File.separator + files[i], s);  //再帰手続き
			}
		}
	}
}