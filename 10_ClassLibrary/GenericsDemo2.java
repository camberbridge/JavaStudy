import java.util.*;

public class GenericsDemo2 {
	public static void main(String srga[]){
		Vector<Integer> v = new Vector<Integer>();  //�x�N�g���ɂ�Integer�^�̃I�u�W�F�N�g�̂�
		                                            //���i�[����邱�Ƃ𖾎�
		
		v.add(1);
		v.add(2);
		v.add(3);
		//v.add("4"); //����̓R���p�C���G���[�ɂȂ�B�Ȃ��Ȃ�AVector�N���X�̃I�u�W�F�N�g�������ɁA
		              //�W�F�l���N�X�Ƃ���Integer�̌^���w�肵�Ă���̂ŁA
		              //String�^�̕�����ȂǁAInteger�ȊO�̌^�̗v�f�́A�x�N�g���Ɋi�[�ł��Ȃ��B
		
		int sum = 0;
		for(int i = 0; i < v.size(); i++){  //Vector�N���X�̃C���X�^���X���\�b�hsize()��
			                                //�x�N�g���Ɋi�[����Ă���v�f�̐���Ԃ�
			sum += v.get(i);
		}
		System.out.println(sum);
	}
}
