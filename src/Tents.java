interface Waterproof{
}

abstract class Tent{
}

class TentA extends Tent{
}

class TentB extends Tent implements Waterproof{
}

class TentC extends Tent{
}

class TentD extends Tent implements Waterproof{
}

public class Tents {
	private static final int n = 4;
	
	public static void main(String args[]){
		Tent tent[] = new Tent[n];
		
		tent[0] = new TentA();
		tent[1] = new TentB();
		tent[2] = new TentC();
		tent[3] = new TentD();
		
		for(int i = 0; i < n; i++){
			if(tent[i] instanceof Waterproof){
				Waterproof waterproof = (Waterproof)tent[i];  //ƒLƒƒƒXƒg‚µ‚Ä‘ã“ü
				System.out.println(waterproof.getClass().getName());
			}
		}
	}
}
