import java.io.*;

public class FibonacciOut {
	public static void main(String args[]){
		try{
			FileOutputStream fos = new FileOutputStream(args[0]);
			DataOutputStream dos = new DataOutputStream(fos);
			int i = 0, count = 0, j = 1;
			
			do{
				dos.writeShort(j);  //Short�^���o�C�g�o�̓X�g���[���ɏ�������
				int k = i + j;
				i = j;
				j = k;
			}while(++count < 15);
		
			dos.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
