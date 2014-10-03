import java.util.*;

public class GaussianMean {
	public static void main(String args[]){
		int x;
		
		if(args.length <= 0){  //コマンドライン引数が空なら、100を与える
			x = 100;
		}else{
			x = Integer.valueOf(args[0]).intValue();  //コマンドライン引数(String型)をint型に変換
		}
		System.out.println(x);
		double array[];
		Random generator = new Random();  //javaユーティリティクラスのRandomクラスのオブジェクト生成

		array = new double[x];  //double型でオブジェクト生成
		for(int i = 0; i < x; i++){
			System.out.println(generator.nextGaussian());  //ガウス分布の乱数(double型)生成。
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
