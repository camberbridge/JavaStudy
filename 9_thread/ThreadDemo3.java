
class MyThread3 extends Thread{
	private String s;
	private long msec;
	
	MyThread3(String s, long msec){  //コンストラクタ
		this.s = s;
		this.msec = msec;
	}
	
	public void run(){
		try{
			while(true){  //無限ループ
				Thread.sleep(this.msec);  //Threadクラスの静的メソッド。例外はInterruptedExceptionを発生
				System.out.println(this.s);
			}
		}
		catch(InterruptedException e){  //sleep()メソッドから起こりうる例外ハンドラのキャッチ処理
			                            //Exception例外クラスでキャッチしてもよい
			e.printStackTrace();
		}
	}
}

public class ThreadDemo3 {
	public static void main(String args[]){
		MyThread3 mythread3 = new MyThread3("A", 1000);
		mythread3.start();  //スレッドの実行
		mythread3 = new MyThread3("B", 3000);
		mythread3.start();
	}
}
