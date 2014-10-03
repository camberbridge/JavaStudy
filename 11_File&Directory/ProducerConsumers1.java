import java.util.*;

class Producer1 extends Thread {  //�����̗�𐶐�(�x�N�g���ɒl���Ԃ�����)����X���b�h�N���X
  Queue1 queue;
  int i = 0;

  Producer1(Queue1 queue) {
    this.queue = queue;
  }

  public void run() {
    while(true) {
      queue.add(i++);  /*Queue1�N���X�̃C���X�^���X���\�b�hadd()�ɐ�����n��*/
      //synchronized�ɂ���K�v����
    }
  }
}

class Consumer1 extends Thread {  //�x�N�g��(�����̗�)����l��ǂݎ���ĕ\������X���b�h�N���X
  String str;
  Queue1 queue;

  Consumer1(String str, Queue1 queue) {
    this.str = str;
    this.queue = queue;
  }

  public void run() {
    while(true) {
      System.out.println(str + ": " + queue.remove());  /*Queue1�N���X�̃C���X�^���X���\�b�h
                                                         *remove()���Ă�
                                                         */
      //synchronized�ɂ���K�v����
    }
  }
}

class Queue1 {  //�҂��s��(�x�N�g��)�̃N���X
  private final static int SIZE = 5;  //�҂��s��ɐ�������邱�Ƃ��ł��鍀�ڂ̍ő吔
  private Vector<Integer> v = new Vector<Integer>();  //�x�N�g�������B�W�F�l���N�X�͈̔͂�Integer�N���X�^
  private int count = 0;

  synchronized void add(int i) {
    // �҂��s�񂪂����ς��ł���Ԃ͑ҋ@����
    while(count == SIZE) {
      try {
        wait();
      }
      catch(InterruptedException e) {
        e.printStackTrace();
        System.exit(0);
      }
    }

    // �x�N�g��(�҂��s��)�Ƀf�[�^��ǉ�����
    v.add(i);  //i�I�u�W�F�N�g�Q�Ɛ�̒l���x�N�g���ɒǉ�

    ++count;

    // �ҋ@�X���b�h�ɒʒm����
    notifyAll();
  }

  synchronized int remove() {
    // �҂��s�񂪋�̊Ԃ͑ҋ@����
    while(count == 0) {
      try {
        wait();
      }
      catch(InterruptedException e) {
        e.printStackTrace();
        System.exit(0);
      }
    }

    // �҂��s�񂩂�f�[�^��ǂݎ��B77, 78�s�ڂ́Aremove(int index)�̑���
    Integer integerObj = v.firstElement();  //�x�N�g����1�ڂ̗v�f��Ԃ�
    v.removeElement(integerObj);  //�x�N�g����1�ڂ̃I�u�W�F�N�g(�l(�v�f))���폜

    --count;

    // �ҋ@�X���b�h�ɒʒm����
    notifyAll();

    // �҂��s��̗v�f��Ԃ�
    return integerObj.intValue();  //���݂̃I�u�W�F�N�g�̒l���Aint�^�ŕԂ�
  }
}

class ProducerConsumers1 {
  public static void main(String args[]) {
    Queue1 queue = new Queue1();
    new Producer1(queue).start();
    new Consumer1("ConsumerA", queue).start();
    new Consumer1("ConsumerB", queue).start();
    new Consumer1("ConsumerC", queue).start();
  }
}