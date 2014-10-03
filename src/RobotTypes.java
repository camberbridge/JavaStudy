interface Locomotion{
	void forward();
	void reverse();
	void stop();
}

interface Sound{
	void beep();
}

abstract class Robot{
}

class RobotA extends Robot{
}

class RobotB extends Robot implements Locomotion{
	public void forward(){
		System.out.println("RobotB: forward");
	}
	public void reverse(){
		System.out.println("RobotB: reverse");
	}
	public void stop(){
		System.out.println("RobotB: stop");
	}
}

class RobotC extends Robot implements Locomotion, Sound{
	public void forward(){
		System.out.println("RobotC: forward");
	}
	public void reverse(){
		System.out.println("RobotC: reverse");
	}
	public void stop(){
		System.out.println("RobotC: stop");
	}
	public void beep(){
		System.out.println("RobotC: beep");
	}
}

class RobotA1 extends RobotA implements Sound{
	public void beep(){
		System.out.println("RobotA1: beep");
	}
}

class RobotB1 extends RobotB implements Sound{
	public void beep(){
		System.out.println("RobotB1: beep");
	}
}

class RobotB2 extends RobotB{
}

class RobotC1 extends RobotC{
}

public class RobotTypes{
	private static final int n = 7;
	
	public static void main (String args[]){
		Robot robot[] = new Robot[n];
		
		robot[0] = new RobotA();
		robot[1] = new RobotA1();
		robot[2] = new RobotB();
		robot[3] = new RobotB1();
		robot[4] = new RobotB2();
		robot[5] = new RobotC();
		robot[6] = new RobotC1();
		
		for(int i = 0; i < n; i++){
			if(robot[i] instanceof Sound){
				Sound sound = (Sound)robot[i]; //キャストして代入
				sound.beep();
			}
			if(robot[i] instanceof Locomotion){
				Locomotion locomotion = (Locomotion)robot[i];  //キャストして代入
				locomotion.stop();
			}
		}
	}
}
