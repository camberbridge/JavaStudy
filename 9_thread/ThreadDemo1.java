class ThreadX extends Thread{
	public void run(){  //Thread�N���X����I�[�o�[���C�h����run()���\�b�h�ɏ���������
		try{
			while(true){  //�U�ɂȂ鏈�����ǂ��ɂ��{���Ă��Ȃ����߁A�������[�v
				Thread.sleep(2000);  /*Thread�N���X�̐ÓI���\�b�h�B
				                      *���݂̃X���b�h��2000�~���b�ԑҋ@������B
				                      *�܂��Asleep()���\�b�h�́A��O�𓊂���\����
				                      *���邽�߁A��O�n���h�����{���Ȃ���΂Ȃ�Ȃ��B
				                      */
				System.out.println("Hello");
			}
		}
		catch(InterruptedException/*Exception*/ e){  //sleep()���\�b�h���瓊������\���̂����O�I�u�W�F�N�g
			                                         //Exception��O�N���X�ł��悢
			e.printStackTrace();
		}
	}
}

public class ThreadDemo1 {
	public static void main(String args[]){
		ThreadX tx = new ThreadX();  //�X���b�h���N�����邽�߂ɁA�C���X�^���X��
		tx.start();  //start()���\�b�h�́Arun()���\�b�h���Ăяo���A�X���b�h�����s����
	}
}
