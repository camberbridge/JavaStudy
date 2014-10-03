
import java.util.*;

public class GregorianCalendarDemo {
	private static int year;
	
	public static void main(String args[]){
		//GregorianCalendar�N���X�́ACalendar�N���X�̃T�u�N���X�ł���B
		GregorianCalendar g = new GregorianCalendar(TimeZone.getTimeZone("Asia/Tokyo"));
		//GregorianCalendar�N���X�̃I�u�W�F�N�g�����B
		//���݂̓��t�Ǝ����ŃI�u�W�F�N�g���������B
		//�R���X�g���N�^�����ɁATimeZone�N���X��
		//gettimeZone()���\�b�h�ŁA"Asia/Tokyo"��TimeZone�I�u�W�F�N�g��^����
		
		year = g.get(Calendar.YEAR);  /*Calendar�N���X�̃C���X�^���X���\�b�hget()�́A
		                               *int�^�ł��邽�߁Aint�^�̒l��Ԃ��BCalendar.YEAR�́A
		                               *Calendar�N���X�̐ÓI�ϐ��B
		                               */
		System.out.println(year);
		if(g.isLeapYear(year)){  /*Calendar�N���X�̃C���X�^���X���\�b�h
		                          *isLeapYear()�̈��������邤�N�ł�������A
		                          *�^��Ԃ��B�����łȂ���΋U��Ԃ��B
		                          */
			System.out.println(year + " is LeapYear");
		}else{
			System.out.println(year + " is nonLeapYear");
		}
		
		System.out.println("Month = " + (g.get(Calendar.MONTH) + 1));
		//Calendar.MONTH�̒l�́A0����n�܂�B
		System.out.println("Week of year = " + g.get(Calendar.WEEK_OF_YEAR));
		System.out.println("Week of month = " + g.get(Calendar.WEEK_OF_MONTH));
		System.out.println("Day of year = " + g.get(Calendar.DAY_OF_YEAR));
		System.out.println("Day of week = " + g.get(Calendar.DAY_OF_WEEK));
		System.out.println(g.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, new Locale("ja", "JP")));
		//Calendar�N���X�̃C���X�^���X���\�b�hgetDisplayName()�́AString�^�ł��邽�߁A�������Ԃ��B
		//�������́AcalendarField�B
		//�������́ACalendar.SHORT �� Calendar.LONG �̂ǂ��炩�B
		//��O�����́A���P�[���Bnew���Z�q�ŁA�I�u�W�F�N�g�𒼐ڂԂ����ށB
	}
}
