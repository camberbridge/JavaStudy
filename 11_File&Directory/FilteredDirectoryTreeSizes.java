import java.io.*;

//�R�}���h���C������ -> �t�@�C�����@�g���q
public class FilteredDirectoryTreeSizes {
	static File f;
	
	public static void main(String args[]){
		f = new File(args[0]);
		if((!f.exists()) || (args.length < 1 || args.length > 2)){
			System.out.println("FileNotFound");
		}else{
			tree(args[0], args[1]);
		}
	}
	
	public static void tree(String filename, String kaku){
		f= new File(filename);
		if(f.isFile()){
			if(filename.endsWith(kaku)){
				long len = f.length();
				System.out.println(f + ": " + len);
			}
		}else{
			String files[] = f.list();
			for(int i = 0; i < files.length; i++){
				tree(filename + File.separator + files[i], kaku);
			}
		}
	}
}
