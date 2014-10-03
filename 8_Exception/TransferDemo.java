
class Transfer{
	String number;
	
	Transfer(String number){  //コンストラクタ
		assert number.matches("^[0-9]{9]$");
		this.number = number;
	}
	
	void transfer(String money){
		double d = Double.valueOf(money).doubleValue();
		assert d >= 0;
		
		System.out.println("Transfered $" + money + "to #" + this.number);
	}
}

public class TransferDemo {
	public static void main(String args[]){
		Transfer t = new Transfer(args[0]);
		t.transfer(args[1]);
	}
}
