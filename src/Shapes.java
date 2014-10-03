
interface Shape2D{
	double getArea();
}

interface Shape3D{
	double getVolume();
}

class Point3D{
	double x, y, z;
	
	Point3D(double x, double y, double z){  //�R���X�g���N�^
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

abstract class Shape{  //���ۃN���X
	abstract void display();  //���ۃ��\�b�h
}

class Circle extends Shape implements Shape2D{  //���ۃN���X�̊g��&�C���^�t�F�[�X�̎���
	Point3D center, p;  //�I�u�W�F�N�g�錾
	
	Circle(Point3D center, Point3D p){  /*�R���X�g���N�^ 
	                                     *Point3D center = new Point3D(0, 0, 0),
	                                     *Point3D p = new Point3D(1, 0, 0)
	                                     */
		this.center = center;  //�I�u�W�F�N�g�̏�����
		this.p = p;  //�I�u�W�F�N�g�̏�����
	}
	
	public void display(){
		System.out.println("Circle");
	}
	
	public double getArea(){
		double dx = center.x - p.x;
		double dy = center.y - p.y;
		double d = dx * dx + dy * dy;
		double radius = Math.sqrt(d);
		return Math.PI * radius * radius;
	}
}

class Sphere extends Shape implements Shape3D{
	Point3D center;
	double radius;
	
	Sphere(Point3D center, double radius){
		this.center = center;
		this.radius = radius;
	}
	
	public void display(){
		System.out.println("Sphere");
	}
	
	public double getVolume(){
		return 4 * Math.PI * radius * radius * radius / 3;
	}
}

public class Shapes {
  public static void main(String args[]){
	  Circle c = new Circle(new Point3D(0, 0, 0), new Point3D(1, 0, 0));
	  c.display();
	  System.out.println(c.getArea());
	  
	  Sphere s = new Sphere(new Point3D(0, 0, 0), 1);
	  s.display();
	  System.out.println(s.getVolume());
  }
}
