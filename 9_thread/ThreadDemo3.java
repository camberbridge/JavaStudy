
class MyThread3 extends Thread{
	private String s;
	private long msec;
	
	MyThread3(String s, long msec){  //�R���X�g���N�^
		this.s = s;
		this.msec = msec;
	}
	
	public void run(){
		try{
			while(true){  //�������[�v
				Thread.sleep(this.msec);  //Thread�N���X�̐ÓI���\�b�h�B��O��InterruptedException�𔭐�
				System.out.println(this.s);
			}
		}
		catch(InterruptedException e){  //sleep()���\�b�h����N���肤���O�n���h���̃L���b�`����
			                            //Exception��O�N���X�ŃL���b�`���Ă��悢
			e.printStackTrace();
		}
	}
}

public class ThreadDemo3 {
	public static void main(String args[]){
		MyThread3 mythread3 = new MyThread3("A", 1000);
		mythread3.start();  //�X���b�h�̎��s
		mythread3 = new MyThread3("B", 3000);
		mythread3.start();
	}
}
