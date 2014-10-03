import java.io.*;

public class CircleArea {
	public static void main(String args[]){
		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String s;
			
			System.out.println("Radius? ");
			while((s = br.readLine()) != null){
				double r;
				
				try{
					r = Double.valueOf(s).doubleValue();
				}
				catch(NumberFormatException e){
					System.out.println("Incorrect format!");
					System.out.println("Radius? ");
					continue;
				}
				if(r < 0){
					System.out.println("Radius must be positive!");
					System.out.println("Radius? ");
					continue; 
				}
				
				System.out.println(Math.PI * r * r);
				br.close();
				return;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
