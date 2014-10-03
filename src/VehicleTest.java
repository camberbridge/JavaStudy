
abstract class Vehicle{
	abstract int numWheels();
}

class Car extends Vehicle{
	int numWheels(){
		return 4;
	}
}

class Truck extends Vehicle{
	int numWheels(){
		return 8;
	}
}

public class VehicleTest {
  public static void main (String args[]){
	  Vehicle car = new Car();
	  System.out.println("A car has " + car.numWheels() + " wheels");
	  Vehicle truck = new Truck();
	  System.out.println("A truck has " + truck.numWheels() + " wheels");
  }
}
