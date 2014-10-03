
public class Divider {
	public static void main(String args[]){
		try{
			System.out.println("Before Division");
			int i = Integer.parseInt(args[0]);  //�R�}���h���C������(1��)�����10�̐����Ŏ󂯎��
			int j = Integer.parseInt(args[1]);  //�R�}���h���C������(2��)�����10�̐����Ŏ󂯎��
			System.out.println(i / j);
			System.out.println("After Division");
		}
		//0�ŏ��Z���̗�O
		catch (ArithmeticException e){
			System.out.println("ArithmeticException");
		}
		//�����s�����̗�O
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("ArrayIndex" + "OutOfBoundsException");
		}
		//�񐮐����̗�O
		catch (NumberFormatException e){
			System.out.println("NumberFormatException");
		}
		//�K���Ăяo�����
		finally{
			System.out.println("Finally block");
		}
	}
}
