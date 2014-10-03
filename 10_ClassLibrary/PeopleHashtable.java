import java.util.*;

class Person{
	private String name, tel, fax, mail;
	
	Person(String name, String tel, String fax, String mail){
		this.name = name;
		this.tel = tel;
		this.fax = fax;
		this.mail = mail;
	}
	
	public String toString(){  //toStringメソッド
		return name + "; " + tel + "; " + fax + "; " + mail + "; ";
	}
}


public class PeopleHashtable {
	public static void main(String args[]){
		Hashtable<String, Person> h = new Hashtable<String, Person>();  //ハッシュ表生成。
		//ジェネリクスの範囲は、2つで、String型とPerson型。よって、Hashtableクラスの
		//インスタンスメソッドで、シグネチャが2つ必要なメソッドは、2つの引数のうち
		//1つがString型で1つがPerson型でなければならない。
		
		Person p = new Person("Susan", "1-1", "2-1", "@a");  //オブジェクト生成
		h.put("111111111", p);  //(キー, 値) -> (String型, Person型)
		p = new Person("Claire", "1-2", "2-2", "@b");
		h.put("222222222", p);
		p = new Person("Kim", "1-3", "2-3", "@c");
		h.put("333333333", p);
		p = new Person("Viviane", "1-4", "2-4", "@d");
		h.put("444444444", p);
		p = new Person("Barbara", "1-5", "2-5", "@e");
		h.put("555555555", p);
		
		//ハッシュ表の要素を表示
		Enumeration<String> e = h.keys();
		while(e.hasMoreElements()){
			String k = e.nextElement();
			Person v = h.get(k);  //ハッシュ表の中で、キーにひも付けされている値をゲットする
			System.out.println("keys = " + k + "; value = " + v);
		}
	}
}
