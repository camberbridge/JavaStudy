import java.io.*;

//����3�� -> ��������t�@�C���� �o�͂���t�@�C���� �o�͂���t�@�C���̃T�C�Y(�ȗ���)
//��������t�@�C�����̂��ׂẴo�C�g��ǂݎ��܂ŁA������������
public class FileSplitter {
	public static void main(String args[]){
		try{
			FileInputStream fis = new FileInputStream(args[0]);
			int size = 1024;  //�o�b�t�@�̃T�C�Y���̕W��1024�Ƃ���
			if(args.length > 2){  //����3�ڂ��ȗ������ꍇ�A�o�b�t�@�T�C�Y�͕W����1024
				size = Integer.parseInt(args[2]);  //String�^��int�^�ɕϊ�(String -> Integer -> int)
			}
			byte buffer[] = new byte[size]; //byte�^�̔z��buffer���K�v�����琶��
			int i, count = 0;
			
			while((i = fis.read(buffer, 0, size)) != -1){  /*���̓X�g���[������size�o�C�g�A
			                                                *�z��buffer�ɏ������ށB
				                                            *i�ɂ͐������ǂݎ�������ۂ̃o�C�g���B
			                                                *�����ꍇ�́A-1��Ԃ��B
			                                                */
				//�o�̓t�@�C�����쐬����
				String filename = args[1] + count;
				FileOutputStream fos = new FileOutputStream(filename);
				
				fos.write(buffer, 0, i);  //i�ɂ́A�o�C�g���͂����Ă��邩��OK
				fos.flush();  /*�o�̓X�g���[�����t���b�V������B�܂�A�����o�b�t�@�Ɋi�[����Ă���
				               *�f�[�^�������f�o�C�X�ɏ������܂��B�����d�v�B
				               *���܂��Ă������̂��h�[��
				               */
				fos.close();
				
				++count;
			}
			fis.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
