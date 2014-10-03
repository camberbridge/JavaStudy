import java.net.*;

public class InetAddressDEmo {
	public static void main(String args[]){
		try{
			InetAddress ia[] = InetAddress.getAllByName(args[0]);
			/*InetAddress ia = InetAddress.getLocalHost();
		     *System.out.println(ia.getHostName());
		     *System.out.println(ia.getHostAddress());
		     */
			for(int i = 0; i < ia.length; i++){
				System.out.println(ia[i].getHostName());
				System.out.println(ia[i].getHostAddress());
				byte b[] = ia[i].getAddress();
				for(int j = 0; j < b.length; j++){
					if(j > 0){
						System.out.print(".");
					}
					if(j >= 0){
						System.out.print(b[j]);
					}else{
						System.out.print(b[j] + 256);
					}
				}
				System.out.println("");
			}
		}
		catch(UnknownHostException e){
			e.printStackTrace();
		}
	}
}
