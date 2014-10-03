import java.util.*;

public class PushPop2 {
	public static void main(String args[]){
		Stack<Integer> stack = new Stack<Integer>();  //スタック生成。ジェネリクスの範囲は、Integer
		
		//要素はスタックにプッシュ
		for(int i = 0; i < args.length; i++){
			Integer itg = new Integer(args[i]);
			if(stack.search(itg) == -1){
				stack.push(itg);  /*コマンドライン引数を、Integer型でオブジェクト
				 				   *生成して、それをStackクラスのインスタンスメソッド
				 		           *push()に与える。push()は、受け取ったオブジェクト
				 		           *をスタックにプッシュする。
				 		           */
			}			
		}
		
		//スタックから要素をポップして表示する
		while(!stack.empty()){
			System.out.println(stack.pop());  //スタックの一番上のオブジェクトを返し、
			                                  //それをスタックから削除する
		}
	}
}
