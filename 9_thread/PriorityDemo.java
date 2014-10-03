class NormPriorityThread extends Thread {
  public void run() {
    for(int i = 0; i < 20; i++)
      System.out.println("Normal priority thread: " + i);
  }
}

class LowPriorityThread extends Thread {
  public void run() {
    setPriority(MIN_PRIORITY);
    try {
      for(int i = 0; i < 1000; i++){
    	  //Thread.sleep(1000);
    	  System.out.println("Low priority thread: " + i);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}

class PriorityDemo {
  public static void main(String args[]) {
    // �D�揇�ʂ̒Ⴂ�X���b�h���쐬���ċN������
    LowPriorityThread lpt = new LowPriorityThread();
    lpt.start();

    // 2000�~���b�ԑҋ@����
    try {
      Thread.sleep(2000);  //�D�揇�ʂ������X���b�h��2000�~���b�ҋ@��������
    }
    catch(Exception e) {
      e.printStackTrace();
    }

    // �ʏ�̗D�揇�ʂ̃X���b�h���쐬���ċN������
    NormPriorityThread npt = new NormPriorityThread();
    npt.start();
  }
}