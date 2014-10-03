
class Producer extends Thread{
	Queue queue;  
	
	Producer(Queue queue){  //コンストラクタ
		this.queue = queue;
	}
	
	public void run(){
		int i = 0;
		while(true){  //無限ループ
			queue.add(i++);
		}
	}
}

class Consumer extends Thread{
	String str;
	Queue queue;
	
	Consumer(String str, Queue queue){  //コンストラクタ
		this.str = str;
		this.queue = queue;
	}
	
	public void run(){
		while(true){  //無限ループ
			System.out.println(str + ": " + queue.remove());
		}
	}
}

class Queue{
	private static final int  n = 10;
	int array[] = new int[n];
	int r, w, count = 0;
	
	synchronized void add(int i){
		while(count == n){  //待ち行列がいっぱいの場合は待機する
			try{
				wait();  //無期限に待機
			}
			catch(InterruptedException e){  //wait()メソッドの例外
				e.printStackTrace();
				System.exit(0);  //Systemクラスのexit()メソッド
			}
		}
		
		array[w++] = i;  //配列にデータを追加して書き込みポインタを更新する
		if(w >= n){
			w = 0;
		}
		++count;
		notifyAll();  //待機中のスレッドに通知する
	}
	
	synchronized int remove(){
		while(count == 0){  //待ち行列が空の場合は待機する
			try{
				wait();  //無期限待機
			}
			catch(InterruptedException e){
				e.printStackTrace();
				System.exit(0);
			}
		}
		
		int element = array[r++];  //配列からデータを読み取って読み取りポインタを更新する
		if(r >= n){
			r = 0;
		}
		--count;
		notifyAll();  //待機中のスレッドに通知する
		
		return element;
	}
}

public class ProducerConsumers {
	public static void main(String args[]){
		Queue queue = new Queue();
		
		new Producer(queue).start();
		//Producer p = new Producer(queue);
		//p.start();
		
		new Consumer("ConsumerA", queue).start();
		//Consumer c = new Consumer("ConsumerA", queue);
		//c.start();
		
		new Consumer("ConsumerB", queue).start();
		//c = new Consumer("ConsumerB", queue);
		//c.start();
		
		new Consumer("ConsumerC", queue).start();
		//c = new Consumer("ConsumerC", queue);
		//c.start();
	}
}
