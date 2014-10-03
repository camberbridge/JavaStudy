import java.util.*;

public class Add100Days {
	public static void main(String args[]){
		Date date = new Date();
		
		long msec = date.getTime();  //Šî€‚©‚ç‚ÌŒo‰ßŠÔ(ƒ~ƒŠ•b)‚ğæ“¾‚·‚éB
		
		msec += 100 * 24 * 60 * 60 * 1000L;  //100“ú‘«‚·
		
		date.setTime(msec);
		System.out.println(date);
	}
}
