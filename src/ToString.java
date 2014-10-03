class Foo{
  static int i = 7;  //静的変数
  int j;  //インスタンス変数
  
  Foo(int j){  //コンストラクタ
	  this.j = j;
  }
  
  public String toString(){
	  return "Foo: i = " + i + ": j = " + j; //Fooの変数の内容を文字列として表現する
  }
}

public class ToString {
  public static void main (String args[]){
	  Foo foo = new Foo(23);
	  System.out.println(foo.toString());  /*println()メソッドの引数として単にfooでもよい。
	                                        *∵toString()メソッドは、println()メソッドを
	                                        *オーバーライドする
	                                        */
  }
}
