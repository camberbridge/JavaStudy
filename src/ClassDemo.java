
public class ClassDemo {
  public static void main(String args[]){
	  Integer itg = new Integer(5);  //Integerクラスのオブジェクト生成
	  Class cls = itg.getClass();  /*Objectクラスから継承したgetClass()メソッド
	                                *の呼び出し。かつ、それをClassオブジェクトに
	                                *代入してオブジェクト生成。
	                                *Classは、toString()メソッドをオーバーライド
	                                *するので、オブジェクトに関する情報をprintln()
	                                *メソッドで表示できる
	                                */
	  System.out.println(cls);
  }
}
