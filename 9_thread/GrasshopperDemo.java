class Grasshopper extends Thread{
	public final static int n = 6;
	private int x, y;  //���W
	
	Grasshopper(){  //�R���X�g���N�^
		this.x = (int)(100 * Math.random());
		this.y = (int)(100 * Math.random());
	}
	
	public void run(){
		try{
			while(true){
				Thread.sleep((int)(2000 + 10000 * Math.random()));  //2�b�ȏ�12�b�����ҋ@
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
