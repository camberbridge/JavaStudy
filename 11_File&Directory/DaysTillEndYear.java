import java.util.*;

public class DaysTillEndYear {
	public static void main(String args[]){
		GregorianCalendar gc = new GregorianCalendar();
		int dayOfYear = gc.get(Calendar.DAY_OF_YEAR);
		int year = gc.get(Calendar.YEAR);
		gc = new GregorianCalendar(year, 11, 31);
		int dayOfYear2 = gc.get(Calendar.DAY_OF_YEAR);
		
		System.out.println(dayOfYear2 - dayOfYear);
	}
}
