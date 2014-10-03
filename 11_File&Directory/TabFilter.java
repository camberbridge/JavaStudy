import java.io.*;

public class TabFilter {
	public static void main(String args[]){
		try{
			FileReader fr = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(args[1]);
			BufferedWriter bw = new BufferedWriter(fw);
			String s;
			StringBuffer sb;
			
			while((s = br.readLine()) != null){  //1�s���ǂݎ��
				sb = new StringBuffer();  //StringBuffer�N���X�^�I�u�W�F�N�g�̏�����
				for(int i = 0; i < s.length(); i++){
					char c = s.charAt(i);  //i�Ŏw�肳�ꂽ�ʒu�̕�����Ԃ�
					
					if(c == '\t'){  //�^�u��������
						c = ' ';  //�^�u����to�X�y�[�X����
					}
					
					sb.append(c);  //StringBuffer�I�u�W�F�N�g�ɁAc��t�����Ă���
				}
				s = sb.toString() + "\n";  //StringBuffer�I�u�W�F�N�g�̕������String�^�ŕԂ�
				bw.write(s, 0, s.length());  //bw.write(s);�ł��悢  
				//�X�g���[���Ɉʒu0��擪�Ƃ��āAString�I�u�W�F�N�gs����s.length()��������������
			}
				
				br.close();
				bw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
