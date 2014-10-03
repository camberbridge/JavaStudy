
class Producer extends Thread{
	Queue queue;  
	
	Producer(Queue queue){  //�R���X�g���N�^
		this.queue = queue;
	}
	
	public void run(){
		int i = 0;
		while(true){  //�������[�v
			queue.add(i++);
		}
	}
}

class Consumer extends Thread{
	String str;
	Queue queue;
	
	Consumer(String str, Queue queue){  //�R���X�g���N�^
		this.str = str;
		this.queue = queue;
	}
	
	public void run(){
		while(true){  //�������[�v
			System.out.println(str + ": " + queue.remove());
		}
	}
}

class Queue{
	private static final int  n = 10;
	int array[] = new int[n];
	int r, w, count = 0;
	
	synchronized void add(int i){
		while(count == n){  //�҂��s�񂪂����ς��̏ꍇ�͑ҋ@����
			try{
				wait();  //�������ɑҋ@
			}
			catch(InterruptedException e){  //wait()���\�b�h�̗�O
				e.printStackTrace();
				System.exit(0);  //System�N���X��exit()���\�b�h
			}
		}
		
		array[w++] = i;  //�z��Ƀf�[�^��ǉ����ď������݃|�C���^���X�V����
		if(w >= n){
			w = 0;
		}
		++count;
		notifyAll();  //�ҋ@���̃X���b�h�ɒʒm����
	}
	
	synchronized int remove(){
		while(count == 0){  //�҂��s�񂪋�̏ꍇ�͑ҋ@����
			try{
				wait();  //�������ҋ@
			}
			catch(InterruptedException e){
				e.printStackTrace();
				System.exit(0);
			}
		}
		
		int element = array[r++];  //�z�񂩂�f�[�^��ǂݎ���ēǂݎ��|�C���^���X�V����
		if(r >= n){
			r = 0;
		}
		--count;
		notifyAll();  //�ҋ@���̃X���b�h�ɒʒm����
		
		return element;
	}
}

public class ProducerConsumers {
	public static void main(String args[]){
		Queue queue = new Queue();
		
		new Producer(queue).start();
		//Producer p = new Producer(queue);
		//p.start();
		
		new Consumer("ConsumerA", queue).start();
		//Consumer c = new Consumer("ConsumerA", queue);
		//c.start();
		
		new Consumer("ConsumerB", queue).start();
		//c = new Consumer("ConsumerB", queue);
		//c.start();
		
		new Consumer("ConsumerC", queue).start();
		//c = new Consumer("ConsumerC", queue);
		//c.start();
	}
}
