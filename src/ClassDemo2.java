
public class ClassDemo2 {
  public static void main(String args[]){
	  Integer itg = new Integer(7);  //integerクラスのオブジェクト生成
	  Class cls = itg.getClass();  /*先のクラスに継承してある
	                                *ObjectクラスのgetClass()メソッド
	                                *を呼び出して&Class型オブジェクトに代入して
	                                *オブジェクト生成。
	                                */
	  Class sucls = cls.getSuperclass();
	  System.out.println(sucls.getName());
  }
}
