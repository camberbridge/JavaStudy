import java.util.*;

class Person{
	private String name, tel, fax, mail;
	
	Person(String name, String tel, String fax, String mail){
		this.name = name;
		this.tel = tel;
		this.fax = fax;
		this.mail = mail;
	}
	
	public String toString(){  //toString���\�b�h
		return name + "; " + tel + "; " + fax + "; " + mail + "; ";
	}
}


public class PeopleHashtable {
	public static void main(String args[]){
		Hashtable<String, Person> h = new Hashtable<String, Person>();  //�n�b�V���\�����B
		//�W�F�l���N�X�͈̔͂́A2�ŁAString�^��Person�^�B����āAHashtable�N���X��
		//�C���X�^���X���\�b�h�ŁA�V�O�l�`����2�K�v�ȃ��\�b�h�́A2�̈����̂���
		//1��String�^��1��Person�^�łȂ���΂Ȃ�Ȃ��B
		
		Person p = new Person("Susan", "1-1", "2-1", "@a");  //�I�u�W�F�N�g����
		h.put("111111111", p);  //(�L�[, �l) -> (String�^, Person�^)
		p = new Person("Claire", "1-2", "2-2", "@b");
		h.put("222222222", p);
		p = new Person("Kim", "1-3", "2-3", "@c");
		h.put("333333333", p);
		p = new Person("Viviane", "1-4", "2-4", "@d");
		h.put("444444444", p);
		p = new Person("Barbara", "1-5", "2-5", "@e");
		h.put("555555555", p);
		
		//�n�b�V���\�̗v�f��\��
		Enumeration<String> e = h.keys();
		while(e.hasMoreElements()){
			String k = e.nextElement();
			Person v = h.get(k);  //�n�b�V���\�̒��ŁA�L�[�ɂЂ��t������Ă���l���Q�b�g����
			System.out.println("keys = " + k + "; value = " + v);
		}
	}
}
