import java.io.*;

class StreamTokenizerDemo {
  public static void main(String args[]) {
    try {
      // FileReader�I�u�W�F�N�g���쐬����
      FileReader fr = new FileReader(args[0]);

      // BufferedReader�I�u�W�F�N�g���쐬����
      BufferedReader br = new BufferedReader(fr);

      // StreamTokenizer�I�u�W�F�N�g���쐬����
      StreamTokenizer st = new StreamTokenizer(br);

      // �s���I�h��ʏ핶���Ƃ��Ē�`����
      st.ordinaryChar('.');

      // �A�|�X�g���t�B��P�ꕶ���Ƃ��Ē�`����
      st.wordChars('\'', '\'');

      // �g�[�N������������
      while(st.nextToken() != StreamTokenizer.TT_EOF) {
        switch(st.ttype) {
          case StreamTokenizer.TT_WORD:  //-3
            System.out.format("%02d) %s\n", st.lineno(), st.sval);
            break;
          case StreamTokenizer.TT_NUMBER:  //-2      	  
            System.out.format("%02d) %s\n", st.lineno(), st.nval);
            break;
          default:  //���̑�
            System.out.format("%02d) %c\n", st.lineno(), (char)st.ttype);
        }
      }

      // BufferedReader�I�u�W�F�N�g���N���[�Y����
      br.close();
    }
    catch (Exception e) {
    	e.printStackTrace();
    }
  }
}