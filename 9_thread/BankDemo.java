class Account {
	private int balance = 0;
	
	synchronized void deposit(int amount){  //このメソッドをsynchronizedでロック
		balance += amount;
	}
	
	int getBalance(){  //ゲッター
		return balance;
	}
}

class Customer extends Thread{
	Account account;  //オブジェクト宣言
	
	Customer(Account account){  //コンストラクタ
		this.account = account;
	}
	
	public void run(){  //Threadクラスからオーバーライドしたrun()メソッドに処理を書く
		try{
			for(int i = 0; i < 100000; i++){
				account.deposit(10);
			}
		}
		catch(Exception e){  /*別にdeposit()クラス(自作)は例外を出さないので、
		                      *例外ハンドラそのもの(try分自体)を施さなくてもよいが、
		                      *一応すべての例外キャッチを施す
		                      */
			e.printStackTrace();
		}
	}
}

public class BankDemo {
	private static final int n = 10;
	
	public static void main(String args[]){
		Account account = new Account();
		
		Customer customer[] = new Customer[n];   
		for(int i = 0; i < n; i++){  //スレッドを10個生成&起動
			customer[i] = new Customer(account);  //初期化
			customer[i].start();  //スレッド起動
		}
		
		try{
			for(int i = 0; i < n; i++){
				customer[i].join();  //インスタンスメソッド。
				                     //customer[i]オブジェクト参照先のスレッドが破棄されるまで待機
			}
		}
		catch(InterruptedException e){  //join()メソッドは、例外(InterruptedEXception)を
			                            //投げる可能性があるため、キャッチするか、throwsで
			                            //投げる処理を施さなければ、コンパイルエラーになる。
			e.printStackTrace();
		}
		
		System.out.println(account.getBalance());
	}
}
