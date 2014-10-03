import java.io.*;

class FileDemo {
  public static void main(String args[]) {
    try {
      // 定数を表示する
      System.out.println("pathSeparatorChar = " +
        File.pathSeparatorChar);  //静的変数
      System.out.println("separatorChar = " +
        File.separatorChar);  //静的変数

      // いくつかのメソッドをテストする
      File file = new File(args[0]);
      System.out.println("getName() = " +
        file.getName());
      System.out.println("getParent() = " +
        file.getParent());
      System.out.println("getAbsolutePath() = " +
        file.getAbsolutePath());
      System.out.println("getCanonicalPath() = " +
        file.getCanonicalPath());  //例外ハンドラ必要: IOException
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