
public class ClassDemo2 {
  public static void main(String args[]){
	  Integer itg = new Integer(7);  //integer�N���X�̃I�u�W�F�N�g����
	  Class cls = itg.getClass();  /*��̃N���X�Ɍp�����Ă���
	                                *Object�N���X��getClass()���\�b�h
	                                *���Ăяo����&Class�^�I�u�W�F�N�g�ɑ������
	                                *�I�u�W�F�N�g�����B
	                                */
	  Class sucls = cls.getSuperclass();
	  System.out.println(sucls.getName());
  }
}
