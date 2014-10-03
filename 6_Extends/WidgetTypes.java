
abstract class Widget{
  private String color;
  
  public Widget(String color){ //���̃R���X�g���N�^�𖳂����� #1 �ɂȂ�
	  this.color = color;
  }
  
  abstract int getMass();
  
  public String toString(){
	  Class cls = getClass();
	  return cls.getName() + ": " + this.color + ", " + getMass();  /*12�s�ڂ𖳂����āA13�s�ڂ�cls.getName()
	                                                                 *�̕������AgetClass().getName()
	                                                                 *�ƒ��ڎw�肵�Ă��悢
	                                                                 */
  }
}

class WidgetA extends Widget{
	final static int m = 4;
	
	public WidgetA(String color){
		//#1 this.color = color; 
		super(color);
	}
	
	public int getMass(){
		return m;
	}
}

class WidgetB extends Widget{
	final static int m = 1;
	
	public WidgetB(String color){
		super(color);
	}
	
	public int getMass(){
		return m;
	}
}

class WidgetC extends Widget{
	final static int m = 5;
	
	public WidgetC(String color){
		super(color);
	}
	
	public int getMass(){
		return m;
	}
}

class WidgetD extends Widget{
	final static int m = 17;
	
	public WidgetD(String color) {
		super(color);
	}
	
	public int getMass(){
		return m;
	}
}

public class WidgetTypes {
	final static int n = 6;
	static int m = 0;
	
	public static void main(String srga[]){
		Widget widget[] = new Widget[n];
		
		widget[0] = new WidgetC("Red");
		widget[1] = new WidgetA("Green");
		widget[2] = new WidgetD("Yellow");
		widget[3] = new WidgetB("Magenta");
		widget[4] = new WidgetA("Black");
		widget[5] = new WidgetC("White");
		
		for(int i = 0; i < n; i++){
			System.out.println(widget[i]/*.toString()*/);  /*toString()���\�b�h�́Aprintln()���\�b�h
			                                 *�ɃI�[�o�[���C�h����邽�߁A���ڎw�肵�Ȃ��Ă�
			                                 *���s�����
			                                 */
			m += widget[i].getMass();
		}
		
		System.out.println("Total = " + m);
	}
}
