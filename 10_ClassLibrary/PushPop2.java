import java.util.*;

public class PushPop2 {
	public static void main(String args[]){
		Stack<Integer> stack = new Stack<Integer>();  //�X�^�b�N�����B�W�F�l���N�X�͈̔͂́AInteger
		
		//�v�f�̓X�^�b�N�Ƀv�b�V��
		for(int i = 0; i < args.length; i++){
			Integer itg = new Integer(args[i]);
			if(stack.search(itg) == -1){
				stack.push(itg);  /*�R�}���h���C���������AInteger�^�ŃI�u�W�F�N�g
				 				   *�������āA�����Stack�N���X�̃C���X�^���X���\�b�h
				 		           *push()�ɗ^����Bpush()�́A�󂯎�����I�u�W�F�N�g
				 		           *���X�^�b�N�Ƀv�b�V������B
				 		           */
			}			
		}
		
		//�X�^�b�N����v�f���|�b�v���ĕ\������
		while(!stack.empty()){
			System.out.println(stack.pop());  //�X�^�b�N�̈�ԏ�̃I�u�W�F�N�g��Ԃ��A
			                                  //������X�^�b�N����폜����
		}
	}
}
