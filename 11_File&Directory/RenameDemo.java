import java.io.*;

public class RenameDemo {
	public static void main(String args[]){
		File newName = new File(args[0]);  //File型オブジェクト生成
		File oldName = new File(args[1]);  //File型オブジェクト生成
		
		System.out.println(newName.renameTo(oldName));
	}
}
