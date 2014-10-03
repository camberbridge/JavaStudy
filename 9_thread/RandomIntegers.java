
public class RandomIntegers {
	private static int x;
	
	public static void main(String args[]){
		try{
			while(true){
				Thread.sleep(3000);
				x = (int)(5 + 5 * Math.random());
				System.out.println(x);
			}
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
