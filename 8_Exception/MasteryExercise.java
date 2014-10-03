
public class MasteryExercise {
	public static void main(String args[]){
		try{
			System.out.println("The sum is " + add(args));
		}
		catch(NumberFormatException e){
			System.out.println(e);
		}
		catch(RangeException e){
			System.out.println(e);
		}
		finally{
			System.out.println("Thanks");
		}
	}
	
	static double add(String array[]) 
	throws NumberFormatException, RangeException{  /*このクラスではNFE, REを
	                                                *キャッチしていないため、
	                                                *投げる
	                                                */
		double sum = 0;
		
		for(int i = 0; i < array.length; i++){
			double d = Double.valueOf(array[i]).doubleValue();  //String to double
			
			if(d < 0 || d > 1){
				throw new RangeException(d);  //明示的に新しい例外オブジェクトの投入
			}
			
			sum += d;
		}
		
		return sum;
	}
}

class RangeException extends Exception{  //独自の例外クラス
	double a;
	
	RangeException(double a){  //コンストラクタ
		this.a = a;
	}
	
	public String toString(){  //println()メソッドにオーバーライドされるため、指定しなくても実行される
		return "Argument " + a + " must be between 0 and 1";
	}
}
