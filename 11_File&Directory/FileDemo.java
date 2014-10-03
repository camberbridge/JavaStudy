import java.io.*;

class FileDemo {
  public static void main(String args[]) {
    try {
      // �萔��\������
      System.out.println("pathSeparatorChar = " +
        File.pathSeparatorChar);  //�ÓI�ϐ�
      System.out.println("separatorChar = " +
        File.separatorChar);  //�ÓI�ϐ�

      // �������̃��\�b�h���e�X�g����
      File file = new File(args[0]);
      System.out.println("getName() = " +
        file.getName());
      System.out.println("getParent() = " +
        file.getParent());
      System.out.println("getAbsolutePath() = " +
        file.getAbsolutePath());
      System.out.println("getCanonicalPath() = " +
        file.getCanonicalPath());  //��O�n���h���K�v: IOException
      System.out.println("getPath() = " +
        file.getPath());
      System.out.println("canRead() = " +
        file.canRead());
      System.out.println("canWrite() = " +
        file.canWrite());
    }
    catch(IOException e) {
      e.printStackTrace();
    }
  }
}