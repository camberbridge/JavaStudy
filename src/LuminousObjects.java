
interface LuminousObject{
	void lightOff();
	void lightOn();
}

abstract class SolidObject{
}

class Cone extends SolidObject{
	
}

class Cube extends SolidObject{
	
}

class LuminousCone extends Cone implements LuminousObject{
	public void lightOff(){
		System.out.println("LuminousCone: lightOff");
	}
	
	public void lightOn(){
		System.out.println("LuminousCone: lightOn");
	}
	
}

class LuminousCube extends Cube implements LuminousObject{
	public void lightOff(){
		System.out.println("LuminousCube: lightOff");
	}
	
	public void lightOn(){
		System.out.println("LuminousCube: lightOn");
	}
}


public class LuminousObjects {
	private final static int n = 2;
	
	public static void main (String args[]){
		LuminousObject luminousobject[] = new LuminousObject[n];
		
		luminousobject[0] = new LuminousCone();  //継承と同様の使い方。つまりインタフェースを実装したクラスでオブジェクト生成
		luminousobject[1] = new LuminousCube();  //同じく
		
		for(int i = 0; i < n; i++){
			luminousobject[i].lightOn();  //インタフェースメソッドの参照
		}
		for(int i = 0; i < n; i++){
			luminousobject[i].lightOff();  //インタフェースメソッドの参照
		}
	}
}
