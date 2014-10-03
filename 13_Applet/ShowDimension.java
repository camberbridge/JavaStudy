import java.applet.*;
import java.awt.*;
/*
  <applet code="ShowDimension" width=200 height=200>
  </applet>
*/

public class ShowDimension extends Applet {
  public void paint(Graphics g) {
    // サイズの取得
    Dimension d = getSize();

    // ステータス行に表示する
    showStatus("width = " + d.width + "; height = " +
      d.height);
  }
}