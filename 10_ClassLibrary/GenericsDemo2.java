import java.util.*;

public class GenericsDemo2 {
	public static void main(String srga[]){
		Vector<Integer> v = new Vector<Integer>();  //ベクトルにはInteger型のオブジェクトのみ
		                                            //が格納されることを明示
		
		v.add(1);
		v.add(2);
		v.add(3);
		//v.add("4"); //これはコンパイルエラーになる。なぜなら、Vectorクラスのオブジェクト生成時に、
		              //ジェネリクスとしてIntegerの型を指定しているので、
		              //String型の文字列など、Integer以外の型の要素は、ベクトルに格納できない。
		
		int sum = 0;
		for(int i = 0; i < v.size(); i++){  //Vectorクラスのインスタンスメソッドsize()は
			                                //ベクトルに格納されている要素の数を返す
			sum += v.get(i);
		}
		System.out.println(sum);
	}
}
