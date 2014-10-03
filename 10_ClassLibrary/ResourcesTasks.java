import java.util.*;

class Task extends Thread{
	ResourceCoordinator2 rc;
	int id;
	
	Task(ResourceCoordinator2 rc, int id){
		this.rc = rc;
		this.id = id;
	}
	
	public void run(){
		try{
			while(true){  //無限ループ
				//リソース取得
				Resource2 r = rc.getResource();  
				
				//リソースを使う
				int t = (int)(1000 + 100000 * Math.random());
				Thread.sleep(t);  //1秒以上9秒未満待機。下の処理にはまだいかない
				
				//リソースを解放
				rc.releaseResource(r);
				
				//次の作業をする前に休眠
				Thread.sleep(8000);  //8秒待機
			}
		}
		catch(InterruptedException e){  //Thread.sleep()の例外キャッチ
			e.printStackTrace();
		}
	}
}

class Resource2{
	int id;
	
	Resource2(int id){
		this.id = id;
	}
	
	public String toString(){
		return "" + id;
	}
}

class ResourceCoordinator2{
	Stack<Resource2> stack = new Stack<Resource2>();  //スタック生成。ジェネリクスの範囲は、Resource2クラス型
	
	ResourceCoordinator2(){
		for(int i = 0; i < 4; i++){
			stack.push(new Resource2(i));  //オブジェクト生成と同時に、そのオブジェクトをスタックにプッシュ
		}
	}
	
	public synchronized Resource2 getResource(){
		while(true){
			//リソースが使用可能かチェックする
			if(!stack.empty()){  //スタックが空でない場合に真
				Resource2 r = stack.pop();  //スタックの一番上のオブジェクトを返し、それをスタックから削除
				System.out.println("Get resource " + r);
				return r;
			}
			
			//使用可能なリソースを待機する
			try{
				wait();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void releaseResource(Resource2 r){
		//リリースをスタックにプッシュ
		 System.out.println("Release resource " + r);
		 stack.push(r);
		 
		 //待機中のスレッドすべてに通知を送る
		 notifyAll();
	}
}

public class ResourcesTasks {
	public static void main(String args[]){
		//リソースの調整役を作成
		ResourceCoordinator2 rc = new ResourceCoordinator2();
		
		//作業を作成する
		for(int i = 0; i < 10; i++){
			new Task(rc, i).start();
			//Task t = new Task(rc, i);
			//t.start();
		}
	}

}
