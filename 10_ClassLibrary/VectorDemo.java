import java.util.*;

public class VectorDemo {
	public static void main(String args[]){
		//�x�N�g���Ƃ��̗v�f���쐬����
		Vector<Object> vector = new Vector<Object>();  /*Object�N���X���W�F�l���N�X�̌^�Ƃ���
		                                                *�������A�I�u�W�F�N�g����
		                                                */
		System.out.println(vector);
		vector.add(new Integer(5));
		vector.add(new Float(-14.14f));
		vector.add(new String("Hello"));
		vector.add(new Long(120000000));
		vector.add(new Double(-23.45e-11));
		/*Vector�N���X�̃C���X�^���X���\�b�hadd()�ɁA�����Ƃ��ăI�u�W�F�N�g(�� Object�N���X)�𐶐�
		 * ���ė^���Ă���B(�W�F�l���N�X�͈͓�(�悷�ׂẴ��b�v�N���X��Object�N���X�̔z��))
		 * ���ꂼ��̃I�u�W�F�N�g�����������A�x�N�g���̖����ɒǉ��B
		 */
		System.out.println(vector);
		
		//�x�N�g���ɗv�f��}������
		String s = new String("String to be inserted");  //String s = "--"�ł��悢
		vector.insertElementAt(s, 1);  //String�N���X�́A�W�F�l���N�X�Ŏw��B1�̈ʒu��s�̒��g��ǉ�
		System.out.println(vector);
		
		//�x�N�g������v�f���폜����
		Object r = vector.remove(3);  //�P��vector.remove(3)�ł��悢�B3�̈ʒu�̗v�f���폜���A
		                              //�폜�����v�f�́Ar�Ɋi�[����Ă���
		System.out.println(r);  
		System.out.print(vector);
	}
}
