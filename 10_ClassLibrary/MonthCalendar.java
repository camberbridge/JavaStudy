import java.util.*;

public class MonthCalendar {
	private static String dayNames[] = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
	private static String monthNames[] = {"January", "February", "March", "April", "May",
										  "June", "July", "August", "September", "October", "November",
										  "December"};
	private static int daysInMonths[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static void main(String args[]){
		//�����̔N�����j�����擾
		GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone("Asia/Tokyo"));
		int year = gc.get(Calendar.YEAR);
		int month = gc.get(Calendar.MONTH);
		int date = gc.get(Calendar.DATE);
		int dow = gc.get(Calendar.DAY_OF_WEEK);  //�����Ă��悢�B25�s�ڂŐV���ɐ������Ă��邩��B
		
		//���邤�N�̏���
		daysInMonths[1] += gc.isLeapYear(year) ? 1 : 0;  //�O�����Z�q 1��0�����ɂ��ɑ������
		
		//���̍ŏ��̓��ɕύX����
		gc.add(Calendar.DATE, -date + 1);  //...(1)
		
	    // �j�����m�F����
	    int fdow = gc.get(Calendar.DAY_OF_WEEK);  //��(1)
		
		//�ϐ�dom���v�Z(�K�v�ȏꍇ�A�l�͕��ɂȂ�)
		int dom = 2 - fdow;
		
		//���ƔN��\��
		System.out.println(monthNames[month] + " " + year);
		
		//�j����\��
		for(int i = 0; i < dayNames.length; i++){
			System.out.print(dayNames[i] + " ");
		}
		System.out.println("");
		
		//����\������
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 7; j++){
				if(dom > daysInMonths[month]){
					break;  //���߂�for�𔲂���
				}
				
				if(dom > 0){
					//�O���b�h���ɓ���\������
					if(dom  < 10){
						System.out.print("  " + dom + " ");
					}else{
						System.out.print(" " + dom + " ");
					}
				}else{
					System.out.print("    ");
				}
				++dom;
			}
			System.out.println("");
		}
	}
}
