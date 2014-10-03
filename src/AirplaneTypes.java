
abstract class Airplane{
	String serial;
	
	public Airplane(String serial){  //�R���X�g���N�^
		this.serial = serial;
	}
	
	abstract int getPassengers();
	
	public String toString(){  //public String hoge()
		Class cls = getClass();  /*Object�N���X��getClass()���\�b�h��
		                          *Class�^�̃I�u�W�F�N�g�ɑ��&����
		                          */
		return cls.getName() + ": " + this.serial + " " + getPassengers();
	}
}

class B747 extends Airplane{
	final static int PASSENGERS = 500;
	
	public B747(String serial){
		super(serial);  //�X�[�p�[�N���X�̃R���X�g���N�^�̌Ăяo��
	}
	
	public int getPassengers(){
		return PASSENGERS;
	}
}

class B757 extends Airplane{
	final static int PASSENGERS = 300;
	
	public B757(String serial){
		super(serial);
	}
	
	public int getPassengers(){
		return PASSENGERS;
	}
}

class B767 extends Airplane{
	final static int PASSENGERS = 400;
	
	public B767(String serial){
		super(serial);
	}
	
	public int getPassengers(){
		return PASSENGERS;
	}
}

public class AirplaneTypes {
  final static int n = 6;
  
  public static void main(String args[]){
	  Airplane airplane[] = new Airplane[n];  /*Airplane�͒��ۃN���X�����A�����
	                                           *�I�u�W�F�N�g�z��̐�����������v
	                                           */
	  
	  airplane[0] = new B747("UA1233");
	  airplane[1] = new B767("UA8793");
	  airplane[2] = new B757("UA6733");
	  airplane[3] = new B757("UA4523");
	  airplane[4] = new B747("UA9772");
	  airplane[5] = new B767("UA2331");
	  
	  for(int i = 0; i < n; i++){
		  System.out.println(airplane[i]);  /*toSting()���\�b�h�̓I�[�o�[���C�h����邽�߁A
		                                     *���\�b�h�����w�肵�Ȃ��Ă����s�����
		                                     */
		  /*System.out.println(airplane[i].hoge()); 
		   *�ł��悢���AtoString()���\�b�h��println()���\�b�h�ɃI�[�o�[���C�h�����̂ŁA
		   *��q�̌Ăяo���̂悤�Ɏ�Ԃ��Ȃ����!!!
		   */
	  }
  }
}
