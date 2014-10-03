import java.io.*;

//�����t�@�C�����A1�̃t�@�C����
//�R�}���h���C������ -> �ǂݎ��t�@�C���� �o�̓t�@�C����
public class FileMarger {
	private static final int n = 1024;  //�W���o�b�t�@�T�C�Y
	
	public static void main(String args[]){
		try{
			FileOutputStream fos = new FileOutputStream(args[1]);
			
			byte buffer[] = new byte[n];  //�z��(�o�b�t�@)����
			int i, count = 0;
			
			//���̓t�@�C������̃f�[�^����������
			while(true){
				String filename = args[0] + count;
				FileInputStream fis;
				
				try{
					fis = new FileInputStream(filename);
				}
				catch(FileNotFoundException e){  //�ǂݎ��t�@�C���������Ȃ�����A���[�v�𔲂���
					break;
				}
				
				while((i = fis.read(buffer, 0, n)) != -1){  /*�z��buffer�ɏ�������
				                                             *i�ɂ͐������ǂݎ�����o�C�g��
				                                             *�����ꍇ�́A-1
				                                             */
					fos.write(buffer, 0, i);  //�z��buffer�Ɋi�[����Ă���i�o�C�g���X�g���[���ɏ�������
					fos.flush();   //����񗭂܂��Ă������̃h�[��
				}
				fis.close();
				
				++count;
			}
			//fos.flush();  //�h�[������͍̂Ō�ł��悢 �悷�ׂăX�g���[���Ɋi�[���Ă��邩��
			fos.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
