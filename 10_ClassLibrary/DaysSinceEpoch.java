import java.util.*;

public class DaysSinceEpoch {
		public static void main(String args[]){
			Date date = new Date();
			long msec = date.getTime();  //�������̌o�ߎ��Ԃ��~���b�P�ʂŕԂ�
			
			long days = msec / (24 * 60 * 60 * 1000L);  //24h * 60min * 60sec * 1000 = ���
			
			System.out.println(days);
		}
}
