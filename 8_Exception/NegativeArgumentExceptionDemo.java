
public class NegativeArgumentExceptionDemo{
	public static void main(String args[]) throws ExceptionA{ /*このクラスで自作ExceptionA
	                                                           *例外をキャッチしていないので、
	                                                           *投げる
	                                                           */
		for(int i = 0; i < args.length; i++){
			double d = Double.valueOf(args[i]).doubleValue(); //文字列型をdouble型の値に
			
			if(d < 0){
				String s = "Negative command line argument: ";
				s += d;
				throw new ExceptionA(s);
			}
		}
	}
}

class ExceptionA extends Exception{
	ExceptionA(String message){  //コンストラクタ
		super(message);  //親クラスのコンストラクタへ
	}
}