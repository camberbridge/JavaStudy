
public class ClassDemo {
  public static void main(String args[]){
	  Integer itg = new Integer(5);  //Integer�N���X�̃I�u�W�F�N�g����
	  Class cls = itg.getClass();  /*Object�N���X����p������getClass()���\�b�h
	                                *�̌Ăяo���B���A�����Class�I�u�W�F�N�g��
	                                *������ăI�u�W�F�N�g�����B
	                                *Class�́AtoString()���\�b�h���I�[�o�[���C�h
	                                *����̂ŁA�I�u�W�F�N�g�Ɋւ������println()
	                                *���\�b�h�ŕ\���ł���
	                                */
	  System.out.println(cls);
  }
}
