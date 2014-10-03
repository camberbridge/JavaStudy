import java.util.*;

public class MonthCalendar {
	private static String dayNames[] = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
	private static String monthNames[] = {"January", "February", "March", "April", "May",
										  "June", "July", "August", "September", "October", "November",
										  "December"};
	private static int daysInMonths[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static void main(String args[]){
		//今日の年月日曜日を取得
		GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone("Asia/Tokyo"));
		int year = gc.get(Calendar.YEAR);
		int month = gc.get(Calendar.MONTH);
		int date = gc.get(Calendar.DATE);
		int dow = gc.get(Calendar.DAY_OF_WEEK);  //無くてもよい。25行目で新たに生成しているから。
		
		//うるう年の処理
		daysInMonths[1] += gc.isLeapYear(year) ? 1 : 0;  //三項演算子 1か0が日にちに足される
		
		//月の最初の日に変更する
		gc.add(Calendar.DATE, -date + 1);  //...(1)
		
	    // 曜日を確認する
	    int fdow = gc.get(Calendar.DAY_OF_WEEK);  //∵(1)
		
		//変数domを計算(必要な場合、値は負になる)
		int dom = 2 - fdow;
		
		//月と年を表示
		System.out.println(monthNames[month] + " " + year);
		
		//曜日を表示
		for(int i = 0; i < dayNames.length; i++){
			System.out.print(dayNames[i] + " ");
		}
		System.out.println("");
		
		//日を表示する
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 7; j++){
				if(dom > daysInMonths[month]){
					break;  //直近のforを抜ける
				}
				
				if(dom > 0){
					//グリッド内に日を表示する
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
