class MyThread4 implements Runnable{  //Runnableインタフェースの実装
	private String s;
	private long msec;
	
	MyThread4(String s, long msec){
		this.s = s;
		this.msec = msec;
	}
	
	public void run(){
		try{
			while(true){
				Thread.sleep(this.msec);
				System.out.println(this.s);
			}
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

public class ThreadDemo4 {
	public static void main(String args[]){
		MyThread4 mythread4 = new MyThread4("A", 1000);
		Thread t = new Thread(mythread4);
		t.start();
		mythread4 = new MyThread4("B", 3000);
		t = new Thread(mythread4);
		t.start();
		
	}
}
