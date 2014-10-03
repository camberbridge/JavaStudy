import java.util.*;

public class StringTokenizerDemo2 {
	public static void main (String args[]){
		String s = "123/45.6/-11.2/41/-90.1/100/99.99/-50/-20";
		
		StringTokenizer st = new StringTokenizer(s, "/");
		while(st.hasMoreElements()){
			System.out.println(st.nextElement());
		}
	}
}
