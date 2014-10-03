class MyThread extends Thread{
	public void run(){
		try{
			for(int i = 0; i < 10; i++){
				int msec = (int)(300 + 500 * Math.random());  //int型でキャスト
				Thread.sleep(msec);
				System.out.print("x");
			}
		}
		catch(InterruptedException e){  //sleep()メソッドの例外処理
			e.printStackTrace();
		}
	}
}

public class FiveThreads {
	private static final int n = 5;
	
	public static void main(String args[]){
		MyThread t[] = new MyThread[n];
		
		for(int i = 0; i < n; i++){
			t[i] = new MyThread();
		}
	
		for(int i = 0; i < n; i++){
			t[i].start();
		}
		
		for(int i = 0; i < n; i++){  //このブロックにより、5つのスレッドがすべて破棄されるまで、
			                         //このブロック以降の処理を待機させる。
			                         //つまり、ここでは41行目を待機させる。
			try{
				t[i].join();
			}
			catch(InterruptedException e){  /*join()メソッドは、InterruptedException
			                                 *例外オブジェクトを生成する可能性があるから、
			                                 *あらかじめキャッチ処理または、throwsで投げる
			                                 *処理をしないとコンパイルエラーになるよ。
			                                 */
				e.printStackTrace();
			}
		}
		
		System.out.println("\nCompleted");  //5つのスレッドが破棄されるまで待ってまぁ
	}
}
