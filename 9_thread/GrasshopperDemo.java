class Grasshopper extends Thread{
	public final static int n = 6;
	private int x, y;  //座標
	
	Grasshopper(){  //コンストラクタ
		this.x = (int)(100 * Math.random());
		this.y = (int)(100 * Math.random());
	}
	
	public void run(){
		try{
			while(true){
				Thread.sleep((int)(2000 + 10000 * Math.random()));  //2秒以上12秒未満待機
				x = (int)(100 * Math.random());
				y = (int)(100 * Math.random());
				
				System.out.println("Grasshopper at x = " + x + "y = " + y);
			}
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

public class GrasshopperDemo {
	public static void main(String args[]){
		for(int i = 0; i < Grasshopper.n; i++){
			new Grasshopper().start();
			//Grasshopper grasshopper = new Grasshopper();
			//grasshopper.start();
		}
	}
}
