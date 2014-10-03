import java.applet.*;
import java.awt.*;
/*
  <applet code="Harmonics" width=400 height=200>
  </applet>
*/

public class Harmonics extends Applet  {
  public void paint(Graphics g) {
    // 表示域の周囲に四角形を描画する
    Dimension d = getSize();
    int width = d.width;
    int height = d.height;
    g.setColor(Color.blue);
    g.drawRect(0, 0, width - 1, height - 1);

    // x軸とy軸の線を描画する
    int y = height / 2;
    g.drawLine(0, y, width, y);
    g.drawLine(width / 2, 0, width / 2, height);

    // データ値を計算し、最大値と最小値を
    // 記録しておく
    double max = 0;
    double min = 0;
    double deltax = 2 * Math.PI / (width - 1);
    double x = -Math.PI;
    double data[] = new double[width];
    for(int i = 0; i < width; i++) {
      double value = f(x);
      data[i] = value;
      min = (value < min) ? value : min;
      max = (value > max) ? value : max;
      x += deltax;
    }

    // 目盛りの間隔を決め、データ値を変換する
    double scale = height / (max - min);
    for(int i = 0; i < width; i++) {
      double value = data[i];
      double k = (value - min) / (max - min);
      data[i] = height * (1 - k);
    }

    // データ値の曲線を描画する
    g.setColor(Color.black);
    for(int i = 1; i < width; i++) {
      g.drawLine(i - 1, (int)data[i - 1], i, (int)data[i]);
    }
  }

  private double f(double x) {
    double value = 0;
    for(int i = 0; i < 4; i++) {
        value += ((double)1 / (i + 1)) * Math.sin((i + 1) * x);
    }
    return value;
  }
}