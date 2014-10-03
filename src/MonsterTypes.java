
abstract class Monster{
	public String toString(){
		return getClass().getName();
	}
}

class Vampire extends Monster{	
}

class Werewolf extends Monster{
}

class Zombie extends Monster{
}

public class MonsterTypes {
	final static int n = 6;
	
	public static void main (String args[]){
	  Monster monster[] = new Monster[n];
	  
	  monster[0] = new Vampire();
	  monster[1] = new Werewolf();
	  monster[2] = new Zombie();
	  monster[3] = new Vampire();
	  monster[4] = new Werewolf();
	  monster[5] = new Zombie();
	  
	  for(int i = 0; i < n; i++){
		  System.out.println(monster[i]); 
	  }
	}
}
