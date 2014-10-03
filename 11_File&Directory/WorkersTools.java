import java.util.*;

class Worker extends Thread{
	protected static final int n = 10;  //10人の作業員
	private Toolbox toolbox;
	private int id;  //使ってねぇぇ
	private Tool tools[]; //Tool型配列宣言

	Worker(Toolbox toolbox, int id){
		this.toolbox = toolbox;
		this.id = id;
	}

	public void run(){
		try{
			while(true){
				tools = toolbox.getTools(); //2つの工具を取得する(Tool型配列の初期化)
				//synchronizedにする必要あり

				Thread.sleep((int)(10000 + 10000 * Math.random()));
				//10秒以上20秒未満待機

				toolbox.releaseTools(tools); //2つの工具を使用し、解放
				//synchronizedにする必要あり

				Thread.sleep((int)(20000)); //20秒待機
			}
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

class Tool{
	protected static final int n = 4;  //4つの工具
	private int id;

	Tool(int id){
		this.id = id;
	}

	public String toString(){  //toString()メソッド。オーバーライドしてくれるから、このクラスを呼び出すだけで、このメソッドも呼び出される
		return "" + id;  //String型の返り値を返す。オブジェクトとしてね。
	}
}

class Toolbox{
	private Stack<Tool> stack = new Stack<Tool>();  /*スタック生成。
	                                                 *ジェネリクス範囲は、Tool型クラス。
	                                                 *つまりint型整数を引数にするTool型。
	                                                 */

	Toolbox(){
		for(int i = 0; i < Tool.n; i++){
			stack.push(new Tool(i)); //スタックにプッシュ(Tool型オブジェクトを生成&渡す)
		}
	}

	synchronized Tool[] getTools(){  //Tool型配列を返す
		while(true){
			//2つのツールが利用可能であるかどうかをチェック
			if(stack.size() >= 2){  //StackクラスはVectorクラスの実装を再利用することにより、そのメソッドが使用できる
				Tool tool0 = stack.pop(); //スタックの1番上のオブジェクトを返し、それをスタックから削除
				Tool tool1 = stack.pop();
				System.out.println("Get tools " + tool0 + " " + tool1);
				
				Tool a[] = new Tool[2];  //返す用Tool型オブジェクト生成
				a[0] = tool0;
				a[1] = tool1;

				return a; //Tool型a配列を返す
			}
			
			//2つのツールが利用可能になるまで待機
			try{
				wait();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

	synchronized void releaseTools(Tool a[]){
		//ツールボックスにツールを戻す
		System.out.println("Release tools " + a[0] + " " + a[1]);
		stack.push(a[0]);
		stack.push(a[1]);

		//全ての待機スレッドに通知する
		notifyAll();
	}
}

public class WorkersTools {
	public static void main(String args[]){
		//Toolboxオブジェクトを作成する
		Toolbox toolbox = new Toolbox();
		
		//Workerオブジェクトを作成する
		for(int i = 0; i < Worker.n; i++){
			new Worker(toolbox, i).start();
			//Worker w = new Worker(toolbox, i);
			//w.start();
		}
	}
}