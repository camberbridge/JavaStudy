import java.util.*;

public class Add100Days {
	public static void main(String args[]){
		Date date = new Date();
		
		long msec = date.getTime();  //�������̌o�ߎ���(�~���b)���擾����B
		
		msec += 100 * 24 * 60 * 60 * 1000L;  //100������
		
		date.setTime(msec);
		System.out.println(date);
	}
}
