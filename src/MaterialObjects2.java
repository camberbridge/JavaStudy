/*
interface Material{
	String bronze = "bronze";
	String gold = "gold";
	String marble = "marble";
	String silver = "silver";
	String wood = "wood";
}
*/

enum Material{  //�񋓌^enum���Ő錾�����l�����AMaterial�I�u�W�F�N�g�͎g���Ȃ�
	bronze, 
	gold, 
	marble, 
	silver, 
	wood;
}

abstract class MaterialObject{
	Material material;  //�I�u�W�F�N�g�錾
}

class Ball extends MaterialObject{
	Ball(Material material){
		super.material = material;  //�I�u�W�F�N�g�̏�����
	}
}

class Coin extends MaterialObject{
	Coin(Material material){
		this.material = material;
	}
}

class Ring extends MaterialObject{
	Ring(Material material){
		super.material = material;
	}
}

public class MaterialObjects2 {
	public static void main(String args[]){
		Ball ball = new Ball(Material.wood);
		Coin coin = new Coin(Material.silver);
		Ring ring = new Ring(Material.gold);
		System.out.println(ball.material);
		System.out.println(coin.material);
		System.out.println(ring.material);
	}
}