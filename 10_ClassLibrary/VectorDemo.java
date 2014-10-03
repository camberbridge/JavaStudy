import java.util.*;

public class VectorDemo {
	public static void main(String args[]){
		//ベクトルとその要素を作成する
		Vector<Object> vector = new Vector<Object>();  /*Objectクラスをジェネリクスの型として
		                                                *明示し、オブジェクト生成
		                                                */
		System.out.println(vector);
		vector.add(new Integer(5));
		vector.add(new Float(-14.14f));
		vector.add(new String("Hello"));
		vector.add(new Long(120000000));
		vector.add(new Double(-23.45e-11));
		/*Vectorクラスのインスタンスメソッドadd()に、引数としてオブジェクト(⊂ Objectクラス)を生成
		 * して与えている。(ジェネリクス範囲内(∵すべてのラップクラスはObjectクラスの配下))
		 * それぞれのオブジェクトが持つ引数を、ベクトルの末尾に追加。
		 */
		System.out.println(vector);
		
		//ベクトルに要素を挿入する
		String s = new String("String to be inserted");  //String s = "--"でもよい
		vector.insertElementAt(s, 1);  //Stringクラスは、ジェネリクスで指定可。1の位置にsの中身を追加
		System.out.println(vector);
		
		//ベクトルから要素を削除する
		Object r = vector.remove(3);  //単にvector.remove(3)でもよい。3の位置の要素を削除し、
		                              //削除した要素は、rに格納されている
		System.out.println(r);  
		System.out.print(vector);
	}
}
