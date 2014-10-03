import java.util.*;

public class DaysSinceEpoch {
		public static void main(String args[]){
			Date date = new Date();
			long msec = date.getTime();  //Šî€‚©‚ç‚ÌŒo‰ßŠÔ‚ğƒ~ƒŠ•b’PˆÊ‚Å•Ô‚·
			
			long days = msec / (24 * 60 * 60 * 1000L);  //24h * 60min * 60sec * 1000 = ˆê“ú
			
			System.out.println(days);
		}
}
