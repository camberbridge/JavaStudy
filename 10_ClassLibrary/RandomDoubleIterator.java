import java.util.*;

public class RandomDoubleIterator {
	public static void main(String args[]){
		Random r = new Random();
		int x = (int)(10 + 15 * Math.random());
		Vector<Double> v = new Vector<Double>();
		
		for(int i = 0; i < x; i++){
			double d = r.nextGaussian();
			v.add(d);
		}
		
		for(Double e: v) System.out.println(e);		
	}
}

