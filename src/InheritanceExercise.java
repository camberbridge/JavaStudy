interface K1{
	int intK = 1;
	void methodK();
}

interface K2 extends K1{
	void methodK();
}

interface K3 extends K2{
	void methodK();
}

class U implements K3{
	public void methodK(){
		System.out.println(intK);
	}
}

public class InheritanceExercise {
	public static void main(String args[]){
		K1 k1 = new U();  //インタフェースを実装したクラスで(スーパーインタフェース型で)オブジェクト生成
		k1.methodK();
	}
}
