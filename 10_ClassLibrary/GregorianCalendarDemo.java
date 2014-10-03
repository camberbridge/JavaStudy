
import java.util.*;

public class GregorianCalendarDemo {
	private static int year;
	
	public static void main(String args[]){
		//GregorianCalendarクラスは、Calendarクラスのサブクラスである。
		GregorianCalendar g = new GregorianCalendar(TimeZone.getTimeZone("Asia/Tokyo"));
		//GregorianCalendarクラスのオブジェクト生成。
		//現在の日付と時刻でオブジェクトを初期化。
		//コンストラクタ引数に、TimeZoneクラスの
		//gettimeZone()メソッドで、"Asia/Tokyo"のTimeZoneオブジェクトを与える
		
		year = g.get(Calendar.YEAR);  /*Calendarクラスのインスタンスメソッドget()は、
		                               *int型であるため、int型の値を返す。Calendar.YEARは、
		                               *Calendarクラスの静的変数。
		                               */
		System.out.println(year);
		if(g.isLeapYear(year)){  /*Calendarクラスのインスタンスメソッド
		                          *isLeapYear()の引数がうるう年であったら、
		                          *真を返す。そうでなければ偽を返す。
		                          */
			System.out.println(year + " is LeapYear");
		}else{
			System.out.println(year + " is nonLeapYear");
		}
		
		System.out.println("Month = " + (g.get(Calendar.MONTH) + 1));
		//Calendar.MONTHの値は、0から始まる。
		System.out.println("Week of year = " + g.get(Calendar.WEEK_OF_YEAR));
		System.out.println("Week of month = " + g.get(Calendar.WEEK_OF_MONTH));
		System.out.println("Day of year = " + g.get(Calendar.DAY_OF_YEAR));
		System.out.println("Day of week = " + g.get(Calendar.DAY_OF_WEEK));
		System.out.println(g.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, new Locale("ja", "JP")));
		//CalendarクラスのインスタンスメソッドgetDisplayName()は、String型であるため、文字列を返す。
		//第一引数は、calendarField。
		//第二引数は、Calendar.SHORT か Calendar.LONG のどちらか。
		//第三引数は、ロケール。new演算子で、オブジェクトを直接ぶっ込む。
	}
}
