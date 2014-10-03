import java.io.*;

class StreamTokenizerDemo {
  public static void main(String args[]) {
    try {
      // FileReaderオブジェクトを作成する
      FileReader fr = new FileReader(args[0]);

      // BufferedReaderオブジェクトを作成する
      BufferedReader br = new BufferedReader(fr);

      // StreamTokenizerオブジェクトを作成する
      StreamTokenizer st = new StreamTokenizer(br);

      // ピリオドを通常文字として定義する
      st.ordinaryChar('.');

      // アポストロフィを単語文字として定義する
      st.wordChars('\'', '\'');

      // トークンを処理する
      while(st.nextToken() != StreamTokenizer.TT_EOF) {
        switch(st.ttype) {
          case StreamTokenizer.TT_WORD:  //-3
            System.out.format("%02d) %s\n", st.lineno(), st.sval);
            break;
          case StreamTokenizer.TT_NUMBER:  //-2      	  
            System.out.format("%02d) %s\n", st.lineno(), st.nval);
            break;
          default:  //その他
            System.out.format("%02d) %c\n", st.lineno(), (char)st.ttype);
        }
      }

      // BufferedReaderオブジェクトをクローズする
      br.close();
    }
    catch (Exception e) {
    	e.printStackTrace();
    }
  }
}