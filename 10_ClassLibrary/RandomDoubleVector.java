import java.util.*;

public class RandomDoubleVector {
	public static void main(String args[]){
		Random r = new Random();  //Random�N���X�̃I�u�W�F�N�g����
		int x = (int)(10 + 15 * Math.random());  //10�ȏ�25�����̐����𐶐�
		Vector<Double> v = new Vector<Double>();  //�x�N�g�������B�W�F�l���N�X�͈͂́ADouble�^�̂݁B
		Enumeration<Double> e = v.elements();  //�x�N�g���Ɋi�[����Ă���v�f�̗񋓂��AEnumeration�^
		                                       //�I�u�W�F�N�ge�Ɋi�[
		
		for(int i = 0; i < x; i++){
			double d = r.nextGaussian();  //�K�E�X���z����
			v.add(d);  //Vector�N���X�̃C���X�^���X���\�b�hadd()�ŁA
			           //�I�u�W�F�N�gd(= double�^�̃K�E�X���z)��
			           //�x�N�g��(Double�^�̂݋��e)�̖����ɒǉ�
		}
		
		while(e.hasMoreElements()){  //�I�u�W�F�N�ge�ɗv�f���܂�����ꍇ�ɐ^��Ԃ�
			System.out.println(e.nextElement());  //���ɂ���v�f��Ԃ�
		}
		/*�C�e���[�^�ŏ��������ƁA���ꂾ���ł悢�B
		 * for(Double e: v) System.out.println(e);	
		 */
		
		
	}
}
