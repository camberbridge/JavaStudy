import java.util.*;

public class RandomDoubleVector {
	public static void main(String args[]){
		Random r = new Random();  //Randomクラスのオブジェクト生成
		int x = (int)(10 + 15 * Math.random());  //10以上25未満の整数を生成
		Vector<Double> v = new Vector<Double>();  //ベクトル生成。ジェネリクス範囲は、Double型のみ。
		Enumeration<Double> e = v.elements();  //ベクトルに格納されている要素の列挙を、Enumeration型
		                                       //オブジェクトeに格納
		
		for(int i = 0; i < x; i++){
			double d = r.nextGaussian();  //ガウス分布生成
			v.add(d);  //Vectorクラスのインスタンスメソッドadd()で、
			           //オブジェクトd(= double型のガウス分布)を
			           //ベクトル(Double型のみ許容)の末尾に追加
		}
		
		while(e.hasMoreElements()){  //オブジェクトeに要素がまだある場合に真を返す
			System.out.println(e.nextElement());  //次にある要素を返す
		}
		/*イテレータで書き直すと、これだけでよい。
		 * for(Double e: v) System.out.println(e);	
		 */
		
		
	}
}
