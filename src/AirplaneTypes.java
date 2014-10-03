
abstract class Airplane{
	String serial;
	
	public Airplane(String serial){  //コンストラクタ
		this.serial = serial;
	}
	
	abstract int getPassengers();
	
	public String toString(){  //public String hoge()
		Class cls = getClass();  /*ObjectクラスのgetClass()メソッドを
		                          *Class型のオブジェクトに代入&生成
		                          */
		return cls.getName() + ": " + this.serial + " " + getPassengers();
	}
}

class B747 extends Airplane{
	final static int PASSENGERS = 500;
	
	public B747(String serial){
		super(serial);  //スーパークラスのコンストラクタの呼び出し
	}
	
	public int getPassengers(){
		return PASSENGERS;
	}
}

class B757 extends Airplane{
	final static int PASSENGERS = 300;
	
	public B757(String serial){
		super(serial);
	}
	
	public int getPassengers(){
		return PASSENGERS;
	}
}

class B767 extends Airplane{
	final static int PASSENGERS = 400;
	
	public B767(String serial){
		super(serial);
	}
	
	public int getPassengers(){
		return PASSENGERS;
	}
}

public class AirplaneTypes {
  final static int n = 6;
  
  public static void main(String args[]){
	  Airplane airplane[] = new Airplane[n];  /*Airplaneは抽象クラスだが、これは
	                                           *オブジェクト配列の生成だから大丈夫
	                                           */
	  
	  airplane[0] = new B747("UA1233");
	  airplane[1] = new B767("UA8793");
	  airplane[2] = new B757("UA6733");
	  airplane[3] = new B757("UA4523");
	  airplane[4] = new B747("UA9772");
	  airplane[5] = new B767("UA2331");
	  
	  for(int i = 0; i < n; i++){
		  System.out.println(airplane[i]);  /*toSting()メソッドはオーバーライドされるため、
		                                     *メソッド名を指定しなくても実行される
		                                     */
		  /*System.out.println(airplane[i].hoge()); 
		   *でもよいが、toString()メソッドはprintln()メソッドにオーバーライドされるので、
		   *上述の呼び出しのように手間が省けるよ!!!
		   */
	  }
  }
}
