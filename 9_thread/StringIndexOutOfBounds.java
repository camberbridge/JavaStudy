
public class StringIndexOutOfBounds {
	public static void main(String args[]){
		try{
		  String s = "This is a string";
		  int l = s.length();  //Stringクラスのインスタンスメソッド。現在のオブジェクトの文字数を返す->16
		  System.out.println(s.charAt(l));  /*Stringクラスのインスタンスメソッド。
		                                     *引数のlの値で指定される位置の文字を返す。
		                                     *配列として考えるため、0から数える。
		                                     *よって、16番目は何もないnull。
		                                     */
		}
		catch(Exception /*StringIndexOutOfBoundsExceptionでもよい*/ e){
			System.out.println(e);
		}
	}
}
