
public class MasteryExercise {
	public static void main(String args[]){
		try{
			System.out.println("The sum is " + add(args));
		}
		catch(NumberFormatException e){
			System.out.println(e);
		}
		catch(RangeException e){
			System.out.println(e);
		}
		finally{
			System.out.println("Thanks");
		}
	}
	
	static double add(String array[]) 
	throws NumberFormatException, RangeException{  /*���̃N���X�ł�NFE, RE��
	                                                *�L���b�`���Ă��Ȃ����߁A
	                                                *������
	                                                */
		double sum = 0;
		
		for(int i = 0; i < array.length; i++){
			double d = Double.valueOf(array[i]).doubleValue();  //String to double
			
			if(d < 0 || d > 1){
				throw new RangeException(d);  //�����I�ɐV������O�I�u�W�F�N�g�̓���
			}
			
			sum += d;
		}
		
		return sum;
	}
}

class RangeException extends Exception{  //�Ǝ��̗�O�N���X
	double a;
	
	RangeException(double a){  //�R���X�g���N�^
		this.a = a;
	}
	
	public String toString(){  //println()���\�b�h�ɃI�[�o�[���C�h����邽�߁A�w�肵�Ȃ��Ă����s�����
		return "Argument " + a + " must be between 0 and 1";
	}
}
