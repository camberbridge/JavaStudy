class MyThread1 extends Thread{
	String s;
	
	MyThread1(String s){
		this.s = s;
	}
	
	public void run(){
		try{
			System.out.println("Thread " + s + " starting");
			Thread.sleep((int)(10000 + 20000 * Math.random()));
			System.out.println("Thread " + s + " terminating");
			
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

public class JoinDemo {
	public static void main(String args[]){
		MyThread1 a1 = new MyThread1("A1");
		MyThread1 a2 = new MyThread1("A2");
		MyThread1 a3 = new MyThread1("A3");
		
		a1.start();
		a2.start();
		a3.start();
		
		try{
			a1.join();
			a2.join();
			a3.join();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("Finished a");
		
		MyThread1 b1 = new MyThread1("B1");
		MyThread1 b2 = new MyThread1("B2");
		
		b1.start();
		b2.start();
		
		try{
			b1.join();
			b2.join();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("Finished b");
	}
}
