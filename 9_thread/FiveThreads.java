class MyThread extends Thread{
	public void run(){
		try{
			for(int i = 0; i < 10; i++){
				int msec = (int)(300 + 500 * Math.random());  //int�^�ŃL���X�g
				Thread.sleep(msec);
				System.out.print("x");
			}
		}
		catch(InterruptedException e){  //sleep()���\�b�h�̗�O����
			e.printStackTrace();
		}
	}
}

public class FiveThreads {
	private static final int n = 5;
	
	public static void main(String args[]){
		MyThread t[] = new MyThread[n];
		
		for(int i = 0; i < n; i++){
			t[i] = new MyThread();
		}
	
		for(int i = 0; i < n; i++){
			t[i].start();
		}
		
		for(int i = 0; i < n; i++){  //���̃u���b�N�ɂ��A5�̃X���b�h�����ׂĔj�������܂ŁA
			                         //���̃u���b�N�ȍ~�̏�����ҋ@������B
			                         //�܂�A�����ł�41�s�ڂ�ҋ@������B
			try{
				t[i].join();
			}
			catch(InterruptedException e){  /*join()���\�b�h�́AInterruptedException
			                                 *��O�I�u�W�F�N�g�𐶐�����\�������邩��A
			                                 *���炩���߃L���b�`�����܂��́Athrows�œ�����
			                                 *���������Ȃ��ƃR���p�C���G���[�ɂȂ��B
			                                 */
				e.printStackTrace();
			}
		}
		
		System.out.println("\nCompleted");  //5�̃X���b�h���j�������܂ő҂��Ă܂�
	}
}
