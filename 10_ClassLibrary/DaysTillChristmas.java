import java.util.*;

public class DaysTillChristmas {
	public static void main(String args[]){
		//�����t���̃J�����_�[�𐶐�����
		GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone("Asia/Tokyo"));
		
		//���݂̌�, ��, �N���擾����
		int todayMonth = gc.get(Calendar.MONTH);
		int todayDayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
		int todayYear = gc.get(Calendar.YEAR);
		
		//�������A���N�̉����ڂ����擾����
		int todayDayOfYear = gc.get(Calendar.DAY_OF_YEAR);
		
		//�N���X�}�X�܂ł̓������v�Z����
		int numDays;
		if(todayMonth == 11 && todayDayOfMonth > 25){  //Calendar.MONTH�̒l�́A0����n�܂�B
			                                           //12��25���ȍ~��������A���N�ɂȂ�
			gc = new GregorianCalendar(todayYear + 1, 11, 25);  //���N��12��25���ŁA�J�����_����
			int xmasDaysOfYear = gc.get(Calendar.DAY_OF_YEAR);  //���N��12/25���A���N�̉����ڂ�
			numDays = xmasDaysOfYear - todayDayOfYear;  //�����v�Z
		}else{
			gc = new GregorianCalendar(todayYear, 11, 25);  //���N��12��25���ŁA�J�����_�[����
			int xmasDaysOfYear = gc.get(Calendar.DAY_OF_YEAR);  //���N��12/25���A���N�̉����ڂ�
			numDays = xmasDaysOfYear - todayDayOfYear;  //�����v�Z
		}
		
		System.out.println(numDays);
	}
}
