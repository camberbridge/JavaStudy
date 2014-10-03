
public class CountSuperclasses {
	public static void main(String args[]){
		try{
			System.out.println("Number of SuperClass : " + countSuperclasses(args[0]));
		}
		catch(ClassNotFoundException e){
			System.out.println(e);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	static int countSuperclasses(String classname) 
	throws ClassNotFoundException, Exception{  //このクラスでCNFEとEをキャッチしたいないため、投げる
		int count = 0;
		Class cls = Class.forName(classname);  //ClassクラスのforName()メソッドを代入
		//forname()メソッドは、CNFEを投げるメソッドのため、例外ハンドラでCNFEを実装しないと、エラーになる
		//また、forname()メソッドは、インスタンスメソッドであるため、静的な手続きで呼び出せる
		
		while((cls = cls.getSuperclass()) != null){  //clsオブジェクトにスーパークラスがある限り
			++count;
		}
		
		return count;
	}
}
