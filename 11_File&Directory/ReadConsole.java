import java.io.*;

public class ReadConsole {
	public static void main(String args[]){
		try{
			InputStreamReader isr = new InputStreamReader(System.in);  /*InputStreamReader
			                                                            *�I�u�W�F�N�g�̐����B
			                                                            *System.in�́A
			                                                            *System�N���X�̐ÓI
			                                                            *�ϐ��ŁAInputStream
			                                                            *�I�u�W�F�N�g�ւ̎Q��
			                                                            *�������Ă���B
			                                                            */
			BufferedReader br = new BufferedReader(isr);
			String s;
			
			while((s = br.readLine()) != null){  //�����X�g���[���o�b�t�@����A���s�I�[�������ǂݎ��
				System.out.println(s.length());
			}
			
			br.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
