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
    // 優先順位の低いスレッドを作成して起動する
    LowPriorityThread lpt = new LowPriorityThread();
    lpt.start();

    // 2000ミリ秒間待機する
    try {
      Thread.sleep(2000);  //優先順位が高いスレッドが2000ミリ秒待機させられる
    }
    catch(Exception e) {
      e.printStackTrace();
    }

    // 通常の優先順位のスレッドを作成して起動する
    NormPriorityThread npt = new NormPriorityThread();
    npt.start();
  }
}