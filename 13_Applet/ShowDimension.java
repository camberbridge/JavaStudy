import java.applet.*;
import java.awt.*;
/*
  <applet code="ShowDimension" width=200 height=200>
  </applet>
*/

public class ShowDimension extends Applet {
  public void paint(Graphics g) {
    // �T�C�Y�̎擾
    Dimension d = getSize();

    // �X�e�[�^�X�s�ɕ\������
    showStatus("width = " + d.width + "; height = " +
      d.height);
  }
}