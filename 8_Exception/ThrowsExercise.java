public class ThrowsExercise {
	public static void main(String args[]){
		String s[] = new String[6];
		
		s[0] = "45";
		s[1] = "-578";
		s[2] = "22";
		s[3] = "100";
		s[4] = "-1";
		s[5] = "3000";  //この行を削除すると、NullPointerExceptionが生成される
      //s[5] = "300.."; //この行を有効にすると、NumberFormatExceptionが生成される
		
		try{
			System.out.println(average(s));
		}
		catch(NullPointerException e){
			System.out.println(e);
		}
		catch(NumberFormatException e){
			System.out.println(e);
		}
	}
	
	static double average(String array[]) //s[]をarray[]で受けとる
	throws NullPointerException, NumberFormatException{  /*配列の要素が1つもない場合と、
	                                                      *要素が不正な形式の場合の
	                                                      *例外を明示しておく。
	                                                      *また、このクラスでは、
	                                                      *NPE, NFEをキャッチしたいないため、
	                                                      *theowsで、上位スタックへ投げる。
	                                                      */
		double sum = 0;
		
		for(int i = 0; i < array.length; i++){  //配列に格納さてれている要素の長さ分だけループ
			double d = Double.valueOf(array[i]).doubleValue();  
			//Doubleクラスの静的&インスタンスメソッドの使い方は、p71参照
			
			sum += d;
		}
		
		return sum;
	}
}
