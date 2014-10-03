
abstract class Fruit{
	String color;
	
	public String toString(){  //toStringメソッドをオーバーライド
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
	  System.out.println(fruit.toString());  //fruitでもよい。∵オーバーライドする  
	  fruit = new Banana();
	  System.out.println(fruit.toString());  //fruitでもよい
	  fruit = new Orange();
	  System.out.println(fruit.toString());  //fruitでもよい
	  fruit = new Strawberry();
	  System.out.println(fruit.toString());  //fruitでもよい
  }
}
