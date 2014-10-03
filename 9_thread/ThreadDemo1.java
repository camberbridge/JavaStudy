class ThreadX extends Thread{
	public void run(){  //Threadクラスからオーバーライドしたrun()メソッドに処理を書く
		try{
			while(true){  //偽になる処理をどこにも施していないため、無限ループ
				Thread.sleep(2000);  /*Threadクラスの静的メソッド。
				                      *現在のスレッドを2000ミリ秒間待機させる。
				                      *また、sleep()メソッドは、例外を投げる可能性が
				                      *あるため、例外ハンドラを施さなければならない。
				                      */
				System.out.println("Hello");
			}
		}
		catch(InterruptedException/*Exception*/ e){  //sleep()メソッドから投げられる可能性のある例外オブジェクト
			                                         //Exception例外クラスでもよい
			e.printStackTrace();
		}
	}
}

public class ThreadDemo1 {
	public static void main(String args[]){
		ThreadX tx = new ThreadX();  //スレッドを起動するために、インスタンス化
		tx.start();  //start()メソッドは、run()メソッドを呼び出し、スレッドを実行する
	}
}
