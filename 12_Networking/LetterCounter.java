import java.io.*;

public class LetterCounter {
	private static final int n = 26;
	
	public static void main(String args[]){
		try{
			int count[] = new int[n];
			String s;
			FileReader fr = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(fr);
			
			//������ǂݎ��
			while((s = br.readLine()) != null){  //1�s����
				char c[] = s.toCharArray();  //String�^��������A1��������char�^�z��ɕϊ�
				for(int i = 0; i < c.length; i++){
					int k = Character.toLowerCase(c[i])/*�p�����p�������ɕϊ�*/ - 'a';  
					if(k >= 0 && k < n){
						++count[k];
					}
				}
			}
			
			//������\������
			for(int j = 0; j < n; j++){
				char c = (char)('a' + j);
				System.out.print(c + "=");
				System.out.print(count[j] + "; ");
			}
			System.out.println("");
			
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
