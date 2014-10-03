class Mouse extends Thread{
	Box box;
	
	Mouse(Box box){
		this.box = box;
	}
	
	public void run(){
		try{
			while(true){
				Thread.sleep((int)(10000 + 10000 * Math.random()));
				box.enter();
				Thread.sleep((int)(5000 + 3000 * Math.random()));
				box.exit();
			}
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

class Box{
	private static final int n = 4;
	int count;
	
	synchronized void enter(){
		//” ‚ª‚¢‚Á‚Ï‚¢‚Ì‚¤‚¿‚Í‘Ò‹@‚³‚¹‚é
		try{
			while(count == n){
				wait();
			}
		}
		catch(InterruptedException  e){
			e.printStackTrace();
			System.exit(0);
		}
		
		++this.count;
		
		System.out.println(this.count);
	}
	
	synchronized void exit(){
		--this.count;
		
		System.out.println(this.count);
		notifyAll();
	}
}

public class BoxAndMice {
	public static void main(String args[]){
		Box box = new Box();
		
		for(int i = 0; i < 10; i++){
			new Mouse(box).start();
			//Mouse m = new Mouse(box);
			//m.start();
		}
	}
}
