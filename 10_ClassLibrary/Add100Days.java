import java.util.*;

public class Add100Days {
	public static void main(String args[]){
		Date date = new Date();
		
		long msec = date.getTime();  //基準時からの経過時間(ミリ秒)を取得する。
		
		msec += 100 * 24 * 60 * 60 * 1000L;  //100日足す
		
		date.setTime(msec);
		System.out.println(date);
	}
}
