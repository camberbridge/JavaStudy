class Account {
	private int balance = 0;
	
	synchronized void deposit(int amount){  //���̃��\�b�h��synchronized�Ń��b�N
		balance += amount;
	}
	
	int getBalance(){  //�Q�b�^�[
		return balance;
	}
}

class Customer extends Thread{
	Account account;  //�I�u�W�F�N�g�錾
	
	Customer(Account account){  //�R���X�g���N�^
		this.account = account;
	}
	
	public void run(){  //Thread�N���X����I�[�o�[���C�h����run()���\�b�h�ɏ���������
		try{
			for(int i = 0; i < 100000; i++){
				account.deposit(10);
			}
		}
		catch(Exception e){  /*�ʂ�deposit()�N���X(����)�͗�O���o���Ȃ��̂ŁA
		                      *��O�n���h�����̂���(try������)���{���Ȃ��Ă��悢���A
		                      *�ꉞ���ׂĂ̗�O�L���b�`���{��
		                      */
			e.printStackTrace();
		}
	}
}

public class BankDemo {
	private static final int n = 10;
	
	public static void main(String args[]){
		Account account = new Account();
		
		Customer customer[] = new Customer[n];   
		for(int i = 0; i < n; i++){  //�X���b�h��10����&�N��
			customer[i] = new Customer(account);  //������
			customer[i].start();  //�X���b�h�N��
		}
		
		try{
			for(int i = 0; i < n; i++){
				customer[i].join();  //�C���X�^���X���\�b�h�B
				                     //customer[i]�I�u�W�F�N�g�Q�Ɛ�̃X���b�h���j�������܂őҋ@
			}
		}
		catch(InterruptedException e){  //join()���\�b�h�́A��O(InterruptedEXception)��
			                            //������\�������邽�߁A�L���b�`���邩�Athrows��
			                            //�����鏈�����{���Ȃ���΁A�R���p�C���G���[�ɂȂ�B
			e.printStackTrace();
		}
		
		System.out.println(account.getBalance());
	}
}
