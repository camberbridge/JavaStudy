
class Singleton{
	static Singleton singleton;  /*静的オブジェクト宣言。
	                              *この時点では静的変数singletonを初期化していない
	                              *ため、nullが格納されている。
	                              *また、自クラスであるため、自クラスのオブジェクト
	                              *生成ができているが、staticを付加しているため、
	                              *他クラスからは静的な手続きでアクセスしなければ
	                              *ならない。
	                              */
	private Singleton(){ //既定コンストラクタをprivateで宣言
	}
	
	public static Singleton getInstance(){  //静的メソッド
		if(singleton == null){  
			//singletonオブジェクトがまだないときには作成
			singleton = new Singleton();  //静的オブジェクトの初期化
		}
		
		//singletonオブジェクトを返す
		return singleton;
	}
}

public class SingletonDemo {
  public static void main(String args[]){
	  Singleton s1 = Singleton.getInstance(); //静的な手続きでアクセス
	  Singleton s2 = Singleton.getInstance();
	  if(s1 == s2){
		  System.out.println("Equal");
	  }else{
		  System.out.println("Not equal");
	  }
  }
}
