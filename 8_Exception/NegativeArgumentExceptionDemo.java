
public class NegativeArgumentExceptionDemo{
	public static void main(String args[]) throws ExceptionA{ /*���̃N���X�Ŏ���ExceptionA
	                                                           *��O���L���b�`���Ă��Ȃ��̂ŁA
	                                                           *������
	                                                           */
		for(int i = 0; i < args.length; i++){
			double d = Double.valueOf(args[i]).doubleValue(); //������^��double�^�̒l��
			
			if(d < 0){
				String s = "Negative command line argument: ";
				s += d;
				throw new ExceptionA(s);
			}
		}
	}
}

class ExceptionA extends Exception{
	ExceptionA(String message){  //�R���X�g���N�^
		super(message);  //�e�N���X�̃R���X�g���N�^��
	}
}