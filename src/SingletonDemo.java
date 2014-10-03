
class Singleton{
	static Singleton singleton;  /*�ÓI�I�u�W�F�N�g�錾�B
	                              *���̎��_�ł͐ÓI�ϐ�singleton�����������Ă��Ȃ�
	                              *���߁Anull���i�[����Ă���B
	                              *�܂��A���N���X�ł��邽�߁A���N���X�̃I�u�W�F�N�g
	                              *�������ł��Ă��邪�Astatic��t�����Ă��邽�߁A
	                              *���N���X����͐ÓI�Ȏ葱���ŃA�N�Z�X���Ȃ����
	                              *�Ȃ�Ȃ��B
	                              */
	private Singleton(){ //����R���X�g���N�^��private�Ő錾
	}
	
	public static Singleton getInstance(){  //�ÓI���\�b�h
		if(singleton == null){  
			//singleton�I�u�W�F�N�g���܂��Ȃ��Ƃ��ɂ͍쐬
			singleton = new Singleton();  //�ÓI�I�u�W�F�N�g�̏�����
		}
		
		//singleton�I�u�W�F�N�g��Ԃ�
		return singleton;
	}
}

public class SingletonDemo {
  public static void main(String args[]){
	  Singleton s1 = Singleton.getInstance(); //�ÓI�Ȏ葱���ŃA�N�Z�X
	  Singleton s2 = Singleton.getInstance();
	  if(s1 == s2){
		  System.out.println("Equal");
	  }else{
		  System.out.println("Not equal");
	  }
  }
}
