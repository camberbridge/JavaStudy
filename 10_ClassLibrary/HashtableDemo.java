import java.util.*;

public class HashtableDemo {
	public static void main(String args[]){
		Hashtable<String, String> h = new Hashtable<String, String>();  //ハッシュ表生成。
		//ジェネリクスの範囲は、String型。しかも2つ型を設定したので、Hashtableクラスのインスタンスメソッド
		//で、シグネチャが2つ必要なメソッドは、2つの引数ともString型でなければならない。
		
		h.put("apple", "red");  /*Hashtableクラスのインスタンスメソッドput()に、
		                         *(キー, 値)をString型で与え、ハッシュ表に追加する。
		                         */
		h.put("strawberry", "red");
		h.put("lime", "green");
		h.put("banana", "yellpw");
		h.put("orange", "orange");
		
		//ハッシュ表の要素を表示する
		Enumeration<String> e = h.keys();  /*ハッシュ表に格納されているキーの列挙をEnumeration
		                                        *型オブジェクトeに格納。ジェネリクス範囲は、String。
		                                        *ハッシュ表では、値を取り出すには一意であるキーを使う。
		                                        */
		while(e.hasMoreElements()){  //オブジェクトeに要素(キー)がまだある場合に真を返す
			String k = e.nextElement();  //次にある要素(キー)を返す
			String v = h.get(k);  //ハッシュ表の中で、キーにひも付けされている値をゲットする
			System.out.println("key = " + k + "; value = " + v);
		}
		
		//appleの値を表示する
		System.out.println("The color of an apple is: ");
		String v = h.get("apple");  //ハッシュ表の中で、キー("apple")にひも付けされている値をゲットする
		System.out.println(v);
	}
}
