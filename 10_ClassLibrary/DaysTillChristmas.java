import java.util.*;

public class DaysTillChristmas {
	public static void main(String args[]){
		//今日付けのカレンダーを生成する
		GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone("Asia/Tokyo"));
		
		//現在の月, 日, 年を取得する
		int todayMonth = gc.get(Calendar.MONTH);
		int todayDayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
		int todayYear = gc.get(Calendar.YEAR);
		
		//今日が、今年の何日目かを取得する
		int todayDayOfYear = gc.get(Calendar.DAY_OF_YEAR);
		
		//クリスマスまでの日数を計算する
		int numDays;
		if(todayMonth == 11 && todayDayOfMonth > 25){  //Calendar.MONTHの値は、0から始まる。
			                                           //12月25日以降だったら、来年になる
			gc = new GregorianCalendar(todayYear + 1, 11, 25);  //来年の12月25日で、カレンダ生成
			int xmasDaysOfYear = gc.get(Calendar.DAY_OF_YEAR);  //来年の12/25が、来年の何日目か
			numDays = xmasDaysOfYear - todayDayOfYear;  //日数計算
		}else{
			gc = new GregorianCalendar(todayYear, 11, 25);  //今年の12月25日で、カレンダー生成
			int xmasDaysOfYear = gc.get(Calendar.DAY_OF_YEAR);  //今年の12/25が、今年の何日目か
			numDays = xmasDaysOfYear - todayDayOfYear;  //日数計算
		}
		
		System.out.println(numDays);
	}
}
