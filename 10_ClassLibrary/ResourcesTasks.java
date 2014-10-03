import java.util.*;

class Task extends Thread{
	ResourceCoordinator2 rc;
	int id;
	
	Task(ResourceCoordinator2 rc, int id){
		this.rc = rc;
		this.id = id;
	}
	
	public void run(){
		try{
			while(true){  //�������[�v
				//���\�[�X�擾
				Resource2 r = rc.getResource();  
				
				//���\�[�X���g��
				int t = (int)(1000 + 100000 * Math.random());
				Thread.sleep(t);  //1�b�ȏ�9�b�����ҋ@�B���̏����ɂ͂܂������Ȃ�
				
				//���\�[�X�����
				rc.releaseResource(r);
				
				//���̍�Ƃ�����O�ɋx��
				Thread.sleep(8000);  //8�b�ҋ@
			}
		}
		catch(InterruptedException e){  //Thread.sleep()�̗�O�L���b�`
			e.printStackTrace();
		}
	}
}

class Resource2{
	int id;
	
	Resource2(int id){
		this.id = id;
	}
	
	public String toString(){
		return "" + id;
	}
}

class ResourceCoordinator2{
	Stack<Resource2> stack = new Stack<Resource2>();  //�X�^�b�N�����B�W�F�l���N�X�͈̔͂́AResource2�N���X�^
	
	ResourceCoordinator2(){
		for(int i = 0; i < 4; i++){
			stack.push(new Resource2(i));  //�I�u�W�F�N�g�����Ɠ����ɁA���̃I�u�W�F�N�g���X�^�b�N�Ƀv�b�V��
		}
	}
	
	public synchronized Resource2 getResource(){
		while(true){
			//���\�[�X���g�p�\���`�F�b�N����
			if(!stack.empty()){  //�X�^�b�N����łȂ��ꍇ�ɐ^
				Resource2 r = stack.pop();  //�X�^�b�N�̈�ԏ�̃I�u�W�F�N�g��Ԃ��A������X�^�b�N����폜
				System.out.println("Get resource " + r);
				return r;
			}
			
			//�g�p�\�ȃ��\�[�X��ҋ@����
			try{
				wait();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void releaseResource(Resource2 r){
		//�����[�X���X�^�b�N�Ƀv�b�V��
		 System.out.println("Release resource " + r);
		 stack.push(r);
		 
		 //�ҋ@���̃X���b�h���ׂĂɒʒm�𑗂�
		 notifyAll();
	}
}

public class ResourcesTasks {
	public static void main(String args[]){
		//���\�[�X�̒��������쐬
		ResourceCoordinator2 rc = new ResourceCoordinator2();
		
		//��Ƃ��쐬����
		for(int i = 0; i < 10; i++){
			new Task(rc, i).start();
			//Task t = new Task(rc, i);
			//t.start();
		}
	}

}
