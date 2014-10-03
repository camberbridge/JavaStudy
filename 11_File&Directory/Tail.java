import java.io.*;

//�R�}���h���C������ -> �t�@�C�����@�o�C�g��
public class Tail {
	public static void main(String args[]){
		try{
			RandomAccessFile raf = new RandomAccessFile(args[0], "r");  //�t�@�C����, �I�v�V����
			long count = Long.valueOf(args[1]).longValue();  //String => Long
			long position = raf.length();  //�t�@�C�����̃o�C�g����Ԃ�
			
			position -= count;
			if(position < 0){
				position = 0;
			}
			raf.seek(position);  //�t�@�C���|�C���^���ʒu�Â�
			
			while(true){
				try{
					byte b = raf.readByte();  //�ʒu�Â����t�@�C���|�C���^�̈ʒu����o�C�g���擾�@
					
					System.out.print((char)(b));
				}
				catch(IOException e){
					break;
				}
			}
			raf.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
