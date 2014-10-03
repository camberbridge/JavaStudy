import java.util.*;

public class HashtableDemo {
	public static void main(String args[]){
		Hashtable<String, String> h = new Hashtable<String, String>();  //�n�b�V���\�����B
		//�W�F�l���N�X�͈̔͂́AString�^�B������2�^��ݒ肵���̂ŁAHashtable�N���X�̃C���X�^���X���\�b�h
		//�ŁA�V�O�l�`����2�K�v�ȃ��\�b�h�́A2�̈����Ƃ�String�^�łȂ���΂Ȃ�Ȃ��B
		
		h.put("apple", "red");  /*Hashtable�N���X�̃C���X�^���X���\�b�hput()�ɁA
		                         *(�L�[, �l)��String�^�ŗ^���A�n�b�V���\�ɒǉ�����B
		                         */
		h.put("strawberry", "red");
		h.put("lime", "green");
		h.put("banana", "yellpw");
		h.put("orange", "orange");
		
		//�n�b�V���\�̗v�f��\������
		Enumeration<String> e = h.keys();  /*�n�b�V���\�Ɋi�[����Ă���L�[�̗񋓂�Enumeration
		                                        *�^�I�u�W�F�N�ge�Ɋi�[�B�W�F�l���N�X�͈͂́AString�B
		                                        *�n�b�V���\�ł́A�l�����o���ɂ͈�ӂł���L�[���g���B
		                                        */
		while(e.hasMoreElements()){  //�I�u�W�F�N�ge�ɗv�f(�L�[)���܂�����ꍇ�ɐ^��Ԃ�
			String k = e.nextElement();  //���ɂ���v�f(�L�[)��Ԃ�
			String v = h.get(k);  //�n�b�V���\�̒��ŁA�L�[�ɂЂ��t������Ă���l���Q�b�g����
			System.out.println("key = " + k + "; value = " + v);
		}
		
		//apple�̒l��\������
		System.out.println("The color of an apple is: ");
		String v = h.get("apple");  //�n�b�V���\�̒��ŁA�L�[("apple")�ɂЂ��t������Ă���l���Q�b�g����
		System.out.println(v);
	}
}
