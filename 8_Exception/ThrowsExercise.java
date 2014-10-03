public class ThrowsExercise {
	public static void main(String args[]){
		String s[] = new String[6];
		
		s[0] = "45";
		s[1] = "-578";
		s[2] = "22";
		s[3] = "100";
		s[4] = "-1";
		s[5] = "3000";  //���̍s���폜����ƁANullPointerException�����������
      //s[5] = "300.."; //���̍s��L���ɂ���ƁANumberFormatException�����������
		
		try{
			System.out.println(average(s));
		}
		catch(NullPointerException e){
			System.out.println(e);
		}
		catch(NumberFormatException e){
			System.out.println(e);
		}
	}
	
	static double average(String array[]) //s[]��array[]�Ŏ󂯂Ƃ�
	throws NullPointerException, NumberFormatException{  /*�z��̗v�f��1���Ȃ��ꍇ�ƁA
	                                                      *�v�f���s���Ȍ`���̏ꍇ��
	                                                      *��O�𖾎����Ă����B
	                                                      *�܂��A���̃N���X�ł́A
	                                                      *NPE, NFE���L���b�`�������Ȃ����߁A
	                                                      *theows�ŁA��ʃX�^�b�N�֓�����B
	                                                      */
		double sum = 0;
		
		for(int i = 0; i < array.length; i++){  //�z��Ɋi�[���Ă�Ă���v�f�̒������������[�v
			double d = Double.valueOf(array[i]).doubleValue();  
			//Double�N���X�̐ÓI&�C���X�^���X���\�b�h�̎g�����́Ap71�Q��
			
			sum += d;
		}
		
		return sum;
	}
}
