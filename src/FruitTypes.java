
abstract class Fruit{
	String color;
	
	public String toString(){  //toString���\�b�h���I�[�o�[���C�h
		return getClass().getName() + ": " + color;
	}
}

class Apple extends Fruit{
	Apple(){
		color = "red";
	}
}

class Banana extends Fruit{
	Banana(){
		color = "yellow";
	}
	
}

class Orange extends Fruit{
	Orange(){
		color = "orange";
	}
}

class Strawberry extends Fruit{
	Strawberry(){
		color = "red";
	}
}

public class FruitTypes {
  public static void main(String args[]){
	  Fruit fruit = new Apple();
	  System.out.println(fruit.toString());  //fruit�ł��悢�B��I�[�o�[���C�h����  
	  fruit = new Banana();
	  System.out.println(fruit.toString());  //fruit�ł��悢
	  fruit = new Orange();
	  System.out.println(fruit.toString());  //fruit�ł��悢
	  fruit = new Strawberry();
	  System.out.println(fruit.toString());  //fruit�ł��悢
  }
}
