import java.io.*;
import java.net.*;

//ClientSide
public class AdderClient {
	public static void main(String args[]){
		try{
			int port = Integer.valueOf(args[1]).intValue();  //�|�[�g�ԍ��̎擾
			String hostname = args[0];  //�z�X�g�l�[���̎擾
			Socket s = new Socket(hostname, port);  //�\�P�b�g����
			//�\�P�b�g�p�̓���/�o�̓X�g���[��
			InputStream is = s.getInputStream();  //�ǂݎ��p
			DataInputStream dis = new DataInputStream(is);
			OutputStream os = s.getOutputStream();  //�������ݗp
			DataOutputStream dos = new DataOutputStream(os);
			
			//���[�U�̃R���\�[���ォ��̓��͂��X�g���[������B���[�U�C���^�t�F�[�X�p�̃X�g���[��
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			while(true){  //�\�P�b�g�ʐM������B�̖������[�v
				System.out.println("Input number: ");
				String str = br.readLine();  //���s�I�[�����܂ŁA1�s�ǂݎ��AString�^�I�u�W�F�N�gs�Ɋi�[
				double d = Double.valueOf(str).doubleValue();  //String�^ -> double�^
				
				dos.writeDouble(d);  //�T�[�o�Ƀf�[�^�𑗐M
				
				double total = dis.readDouble();  //�T�[�o����̃f�[�^����M&�ǂݎ��
				
				System.out.println(total);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
