class Foo{
  static int i = 7;  //�ÓI�ϐ�
  int j;  //�C���X�^���X�ϐ�
  
  Foo(int j){  //�R���X�g���N�^
	  this.j = j;
  }
  
  public String toString(){
	  return "Foo: i = " + i + ": j = " + j; //Foo�̕ϐ��̓��e�𕶎���Ƃ��ĕ\������
  }
}

public class ToString {
  public static void main (String args[]){
	  Foo foo = new Foo(23);
	  System.out.println(foo.toString());  /*println()���\�b�h�̈����Ƃ��ĒP��foo�ł��悢�B
	                                        *��toString()���\�b�h�́Aprintln()���\�b�h��
	                                        *�I�[�o�[���C�h����
	                                        */
  }
}
