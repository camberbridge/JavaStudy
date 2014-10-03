import java.io.*;

//�R�}���h���C������ -> �t�@�C���� �g���q
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
		
		if(f.isFile()){  //�t�@�C���̏ꍇ
			if(filename.endsWith(s)){  //���݂�String�^�I�u�W�F�N�g�̒��g���AString�^�I�u�W�F�N�gs�Ɠ����Ȃ�^
				System.out.println(f);
			}
		}else{  //�f�B���N�g���̏ꍇ
			String files[] = f.list();  //File�^�I�u�W�F�N�g�̃f�B���N�g�����̃t�@�C����String�^�z��ŕԂ�
			for(int i = 0; i < files.length; i++){
				tree(filename + File.separator + files[i], s);  //�ċA�葱��
			}
		}
	}
}