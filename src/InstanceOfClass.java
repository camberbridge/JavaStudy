abstract class Fish{
	abstract void display();
}

abstract class FreshWaterFish extends Fish{
	
}

abstract class SaltWaterFish extends Fish{
	
}

class Trout extends FreshWaterFish{
	void display(){
		System.out.println("Trout");
	}
}

class Flounder extends SaltWaterFish{
	void display(){
		System.out.println("Flounder");
	}
}

class Tuna extends SaltWaterFish{
	void display(){
		System.out.println("Tuna");
	}
}

public class InstanceOfClass {
	public final static int n = 4;
	
	public static void main(String args[]){
		Fish fish[] = new Fish[n];  //抽象クラスは、オブジェクト生成できないが、オブジェクト配列の生成はできる
		
		fish[0] = new Trout();
		fish[1] = new Flounder();
		fish[2] = new Tuna();
		fish[3] = new Trout();
		
		for(int i = 0; i < n; i++){
			if(fish[i] instanceof SaltWaterFish){
				fish[i].display();
			}
		}
	}
}
