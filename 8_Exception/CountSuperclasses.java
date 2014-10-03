
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
	throws ClassNotFoundException, Exception{  //���̃N���X��CNFE��E���L���b�`�������Ȃ����߁A������
		int count = 0;
		Class cls = Class.forName(classname);  //Class�N���X��forName()���\�b�h����
		//forname()���\�b�h�́ACNFE�𓊂��郁�\�b�h�̂��߁A��O�n���h����CNFE���������Ȃ��ƁA�G���[�ɂȂ�
		//�܂��Aforname()���\�b�h�́A�C���X�^���X���\�b�h�ł��邽�߁A�ÓI�Ȏ葱���ŌĂяo����
		
		while((cls = cls.getSuperclass()) != null){  //cls�I�u�W�F�N�g�ɃX�[�p�[�N���X���������
			++count;
		}
		
		return count;
	}
}
