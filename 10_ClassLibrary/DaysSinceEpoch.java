import java.util.*;

public class DaysSinceEpoch {
		public static void main(String args[]){
			Date date = new Date();
			long msec = date.getTime();  //基準時からの経過時間をミリ秒単位で返す
			
			long days = msec / (24 * 60 * 60 * 1000L);  //24h * 60min * 60sec * 1000 = 一日
			
			System.out.println(days);
		}
}
