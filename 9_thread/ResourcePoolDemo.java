class Resource {  //���\�[�X
  boolean allocated;
  int rid;

  Resource(int rid) {
    allocated = false;
    this.rid = rid;
  }

  void use(int uid) {
    try {
      System.out.println("User " + uid + " uses resource " + rid);
      Thread.sleep((int)(5000 + 5000 * Math.random()));  //5�b�ȏ�10�b�����ҋ@
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
}

class ResourceCoordinator {  //���\�[�X����
  private final static int NUMRESOURCES = 3;
  private int totalAllocated;
  private Resource resources[];  //�I�u�W�F�N�g�z��̐錾

  ResourceCoordinator() {  //�R���X�g���N�^
    // totalAllocated������������
    totalAllocated = 0;

    // ���\�[�X���쐬����
    resources = new Resource[NUMRESOURCES];  //�I�u�W�F�N�g�z��̐���
    for(int rid = 0; rid < NUMRESOURCES; rid++) {  //0~2
      resources[rid] = new Resource(rid);  //�I�u�W�F�N�g�z��̏�����
    }
  }

  synchronized Resource get() {  //�߂�l���N���X���Breturn��Resource�N���X�^�̃I�u�W�F�N�g��Ԃ��B#1
    // �g�p�\�ȃ��\�[�X��ҋ@����
    while(totalAllocated == NUMRESOURCES) {  //3�ł���ԌJ��Ԃ�
      try {
        wait();
      }
      catch(InterruptedException ie) {
        ie.printStackTrace();
        System.exit(0);
      }
    }

    // �g�p�\�ȃ��\�[�X�����蓖�Ă�
    Resource r = null;  //�I�u�W�F�N�g�錾&������ #1
    //Resource r;
    for(int i = 0; i < NUMRESOURCES; i++) {  //0~2
      if (resources[i].allocated == false) {
        resources[i].allocated = true;
        r = resources[i];
        break;
      }
    }

    // totalAllocated��1�𑫂�
    ++totalAllocated;

    // �ҋ@���̃X���b�h�ɒʒm�𑗂�
    notifyAll();

    // ���\�[�X��Ԃ�
    return r;  //Resource�N���X�^�̃I�u�W�F�N�g��Ԃ� #1
  }

  synchronized void put(Resource r) {
    // ���\�[�X�Ɏg�p�\�̃}�[�N��t����
    r.allocated = false;

    // totalAllocated����1������
    --totalAllocated;

    // �ҋ@���̃X���b�h�ɒʒm�𑗂�
    notifyAll();
  }
}

class User extends Thread {  //���[�U
  ResourceCoordinator rc;  //�I�u�W�F�N�g�錾
  int uid;

  User(ResourceCoordinator rc, int uid) {  //�R���X�g���N�^�Buid = 0~9
    this.rc = rc;  //�I�u�W�F�N�g������
    this.uid = uid;
  }

  public void run() {
    try {
      while(true) {  //�������[�v 
        Resource r = rc.get();  //Resource�N���X�^�̃I�u�W�F�N�g��rc.get()���Q�Ƃ�����B
        r.use(uid);
        rc.put(r);
        /*Thread.*/sleep(3000);  //3000�~���b�ҋ@
      }
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
}

class ResourcePoolDemo {  //���C��
  private final static int NUMUSERS = 10;

  public static void main(String args[]) {
    // ���\�[�X�̒��������쐬����
    ResourceCoordinator rc = new ResourceCoordinator();

    // ���[�U�[�X���b�h���쐬���ċN������
    for(int uid = 0; uid < NUMUSERS; uid++) {  //0~9
      new User(rc, uid).start();  
      //User u = new User(rc, uid);
      //u.start();
    }
  }
}