
public class Divider {
	public static void main(String args[]){
		try{
			System.out.println("Before Division");
			int i = Integer.parseInt(args[0]);  //コマンドライン引数(1つ目)を基底10の整数で受け取る
			int j = Integer.parseInt(args[1]);  //コマンドライン引数(2つ目)を基底10の整数で受け取る
			System.out.println(i / j);
			System.out.println("After Division");
		}
		//0で除算時の例外
		catch (ArithmeticException e){
			System.out.println("ArithmeticException");
		}
		//引数不足時の例外
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("ArrayIndex" + "OutOfBoundsException");
		}
		//非整数時の例外
		catch (NumberFormatException e){
			System.out.println("NumberFormatException");
		}
		//必ず呼び出される
		finally{
			System.out.println("Finally block");
		}
	}
}
