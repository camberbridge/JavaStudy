import java.io.*;

public class FileReaderDemo {
	public static void main(String args[]){
		try{
			FileReader fr = new FileReader(args[0]);  //FileReader�N���X�^�I�u�W�F�N�g�̐���
			int i;
			
			while((i = fr.read()) != -1){  //������ǂݎ���āA�\������
				System.out.print((char)i);
			}
			
			//FileReader�I�u�W�F�N�g���N���[�Y����
			fr.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
