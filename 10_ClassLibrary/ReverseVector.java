import java.util.*;

public class ReverseVector {
	public static void main(String args[]){
		Vector<Double> v = new Vector<Double>();
		
		for(int i = 0; i < args.length; i++){
			v.add(new Double(args[i]));
			//Double d = new Double(args[i]);
			//v.add(d);
		}
		
		for(int i = v.size() - 1; i >= 0; i--){
			System.out.print(v.elementAt(i) + " ");
		}
		System.out.println("");
	}
}
