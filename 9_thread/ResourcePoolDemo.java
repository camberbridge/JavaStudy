class Resource {  //リソース
  boolean allocated;
  int rid;

  Resource(int rid) {
    allocated = false;
    this.rid = rid;
  }

  void use(int uid) {
    try {
      System.out.println("User " + uid + " uses resource " + rid);
      Thread.sleep((int)(5000 + 5000 * Math.random()));  //5秒以上10秒未満待機
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
}

class ResourceCoordinator {  //リソース調整
  private final static int NUMRESOURCES = 3;
  private int totalAllocated;
  private Resource resources[];  //オブジェクト配列の宣言

  ResourceCoordinator() {  //コンストラクタ
    // totalAllocatedを初期化する
    totalAllocated = 0;

    // リソースを作成する
    resources = new Resource[NUMRESOURCES];  //オブジェクト配列の生成
    for(int rid = 0; rid < NUMRESOURCES; rid++) {  //0~2
      resources[rid] = new Resource(rid);  //オブジェクト配列の初期化
    }
  }

  synchronized Resource get() {  //戻り値がクラス名。returnでResourceクラス型のオブジェクトを返す。#1
    // 使用可能なリソースを待機する
    while(totalAllocated == NUMRESOURCES) {  //3である間繰り返し
      try {
        wait();
      }
      catch(InterruptedException ie) {
        ie.printStackTrace();
        System.exit(0);
      }
    }

    // 使用可能なリソースを割り当てる
    Resource r = null;  //オブジェクト宣言&初期化 #1
    //Resource r;
    for(int i = 0; i < NUMRESOURCES; i++) {  //0~2
      if (resources[i].allocated == false) {
        resources[i].allocated = true;
        r = resources[i];
        break;
      }
    }

    // totalAllocatedに1を足す
    ++totalAllocated;

    // 待機中のスレッドに通知を送る
    notifyAll();

    // リソースを返す
    return r;  //Resourceクラス型のオブジェクトを返す #1
  }

  synchronized void put(Resource r) {
    // リソースに使用可能のマークを付ける
    r.allocated = false;

    // totalAllocatedから1を引く
    --totalAllocated;

    // 待機中のスレッドに通知を送る
    notifyAll();
  }
}

class User extends Thread {  //ユーザ
  ResourceCoordinator rc;  //オブジェクト宣言
  int uid;

  User(ResourceCoordinator rc, int uid) {  //コンストラクタ。uid = 0~9
    this.rc = rc;  //オブジェクト初期化
    this.uid = uid;
  }

  public void run() {
    try {
      while(true) {  //無限ループ 
        Resource r = rc.get();  //Resourceクラス型のオブジェクトにrc.get()を参照させる。
        r.use(uid);
        rc.put(r);
        /*Thread.*/sleep(3000);  //3000ミリ秒待機
      }
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
}

class ResourcePoolDemo {  //メイン
  private final static int NUMUSERS = 10;

  public static void main(String args[]) {
    // リソースの調整役を作成する
    ResourceCoordinator rc = new ResourceCoordinator();

    // ユーザースレッドを作成して起動する
    for(int uid = 0; uid < NUMUSERS; uid++) {  //0~9
      new User(rc, uid).start();  
      //User u = new User(rc, uid);
      //u.start();
    }
  }
}