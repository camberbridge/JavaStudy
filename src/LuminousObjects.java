
interface LuminousObject{
	void lightOff();
	void lightOn();
}

abstract class SolidObject{
}

class Cone extends SolidObject{
	
}

class Cube extends SolidObject{
	
}

class LuminousCone extends Cone implements LuminousObject{
	public void lightOff(){
		System.out.println("LuminousCone: lightOff");
	}
	
	public void lightOn(){
		System.out.println("LuminousCone: lightOn");
	}
	
}

class LuminousCube extends Cube implements LuminousObject{
	public void lightOff(){
		System.out.println("LuminousCube: lightOff");
	}
	
	public void lightOn(){
		System.out.println("LuminousCube: lightOn");
	}
}


public class LuminousObjects {
	private final static int n = 2;
	
	public static void main (String args[]){
		LuminousObject luminousobject[] = new LuminousObject[n];
		
		luminousobject[0] = new LuminousCone();  //�p���Ɠ��l�̎g�����B�܂�C���^�t�F�[�X�����������N���X�ŃI�u�W�F�N�g����
		luminousobject[1] = new LuminousCube();  //������
		
		for(int i = 0; i < n; i++){
			luminousobject[i].lightOn();  //�C���^�t�F�[�X���\�b�h�̎Q��
		}
		for(int i = 0; i < n; i++){
			luminousobject[i].lightOff();  //�C���^�t�F�[�X���\�b�h�̎Q��
		}
	}
}
