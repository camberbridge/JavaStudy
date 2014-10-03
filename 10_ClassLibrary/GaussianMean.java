import java.util.*;

public class GaussianMean {
	public static void main(String args[]){
		int x;
		
		if(args.length <= 0){  //�R�}���h���C����������Ȃ�A100��^����
			x = 100;
		}else{
			x = Integer.valueOf(args[0]).intValue();  //�R�}���h���C������(String�^)��int�^�ɕϊ�
		}
		System.out.println(x);
		double array[];
		Random generator = new Random();  //java���[�e�B���e�B�N���X��Random�N���X�̃I�u�W�F�N�g����

		array = new double[x];  //double�^�ŃI�u�W�F�N�g����
		for(int i = 0; i < x; i++){
			System.out.println(generator.nextGaussian());  //�K�E�X���z�̗���(double�^)�����B
			array[i] = generator.nextGaussian();
			}
		System.out.println("Mean is " + GaussianMean.Mean(array, x));
	}
	
	private static double Mean(double array[], int x){
		double sum = 0;
		
		for(int i = 0; i < x; i++){
			sum += array[i];
		}
		
		return (sum / (double)x);
	}
}
