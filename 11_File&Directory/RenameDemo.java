import java.io.*;

public class RenameDemo {
	public static void main(String args[]){
		File newName = new File(args[0]);  //File�^�I�u�W�F�N�g����
		File oldName = new File(args[1]);  //File�^�I�u�W�F�N�g����
		
		System.out.println(newName.renameTo(oldName));
	}
}
