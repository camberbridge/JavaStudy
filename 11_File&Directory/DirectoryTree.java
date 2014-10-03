import java.io.*;

public class DirectoryTree {
	static File f;
	
	public static void main(String args[]){
		DirectoryTree.f = new File(args[0]);
		if(!f.exists()){
			System.out.println(args[0] + " does not exists.");
		}else{
			tree(args[0]);
		}
	}
	
	public static void tree(String filename){
		DirectoryTree.f = new File(filename);
		
		if(f.isFile()){  //ファイルの場合
			System.out.println(filename);
		}else{  //ディレクトリの場合
			String files[] = f.list();
			
			for(int i = 0; i < files.length; i++){
				tree(filename + File.separator + files[i]);
			}
		}		
	}
}
