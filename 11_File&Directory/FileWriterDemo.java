import java.io.*;

public class FileWriterDemo {
	public static void main(String args[]){
		try{
			FileWriter fw = new FileWriter(args[0]);  //FileWriter�N���X�^�I�u�W�F�N�g�̐���
			
			for(int i = 0; i < 12; i++){  //�t�@�C���ɕ��������������
				fw.write("Line " + i + "\n");  //write�N���X�̃C���X�^���X���\�b�h
				                               //�X�g���[���ɏ�������
			}
			fw.close();  //FileWriter�I�u�W�F�N�g���N���[�Y
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
