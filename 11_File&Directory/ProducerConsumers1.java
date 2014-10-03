import java.util.*;

class Producer1 extends Thread {  //整数の列を生成(ベクトルに値をぶっこむ)するスレッドクラス
  Queue1 queue;
  int i = 0;

  Producer1(Queue1 queue) {
    this.queue = queue;
  }

  public void run() {
    while(true) {
      queue.add(i++);  /*Queue1クラスのインスタンスメソッドadd()に整数を渡す*/
      //synchronizedにする必要あり
    }
  }
}

class Consumer1 extends Thread {  //ベクトル(整数の列)から値を読み取って表示するスレッドクラス
  String str;
  Queue1 queue;

  Consumer1(String str, Queue1 queue) {
    this.str = str;
    this.queue = queue;
  }

  public void run() {
    while(true) {
      System.out.println(str + ": " + queue.remove());  /*Queue1クラスのインスタンスメソッド
                                                         *remove()を呼ぶ
                                                         */
      //synchronizedにする必要あり
    }
  }
}

class Queue1 {  //待ち行列(ベクトル)のクラス
  private final static int SIZE = 5;  //待ち行列に随時入れることができる項目の最大数
  private Vector<Integer> v = new Vector<Integer>();  //ベクトル生成。ジェネリクスの範囲はIntegerクラス型
  private int count = 0;

  synchronized void add(int i) {
    // 待ち行列がいっぱいである間は待機する
    while(count == SIZE) {
      try {
        wait();
      }
      catch(InterruptedException e) {
        e.printStackTrace();
        System.exit(0);
      }
    }

    // ベクトル(待ち行列)にデータを追加する
    v.add(i);  //iオブジェクト参照先の値をベクトルに追加

    ++count;

    // 待機スレッドに通知する
    notifyAll();
  }

  synchronized int remove() {
    // 待ち行列が空の間は待機する
    while(count == 0) {
      try {
        wait();
      }
      catch(InterruptedException e) {
        e.printStackTrace();
        System.exit(0);
      }
    }

    // 待ち行列からデータを読み取る。77, 78行目は、remove(int index)の代わり
    Integer integerObj = v.firstElement();  //ベクトルの1つ目の要素を返す
    v.removeElement(integerObj);  //ベクトルの1つ目のオブジェクト(値(要素))を削除

    --count;

    // 待機スレッドに通知する
    notifyAll();

    // 待ち行列の要素を返す
    return integerObj.intValue();  //現在のオブジェクトの値を、int型で返す
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