package array;

import java.util.Scanner;

public class Avg {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[] arr = new int[num];
		double[] newArr = new double[num];
		double M=0;
		double sum =0;
		double result;
		
		for(int i =0; i<num; i++) {
			arr[i]=sc.nextInt();
			if(arr[i]>M) {
				M=arr[i];
			}
		}
		
		for(int i =0; i<num; i++) {
			newArr[i]=(arr[i]/M)*100;
			sum += newArr[i];
		}
		
		result = sum/num;
		
		System.out.println(result);
		
		
	}

}
