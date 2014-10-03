import java.util.*;

public class RandomSeed {
	private static final int n = 10;
	private static final int seed = 100;
	
	public static void main(String args[]){
		int array[] = new int[n];
		
		Random generator = new Random(seed);
		for(int i = 0; i < n; i++){
			array[i] = generator.nextInt();
			System.out.println(array[i]);
		}
		int array2[] = array;
		
		System.out.println("----------");
		
		generator = new Random(seed);
		for(int i = 0; i < n; i++){
			array[i] = generator.nextInt();
			System.out.println(array[i]);
		}
		
		if(array2.equals(array)){
			System.out.println("WooFoo");
		}
	}
}
