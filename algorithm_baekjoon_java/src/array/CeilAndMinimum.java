package array;

import java.util.Scanner;

public class CeilAndMinimum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int ceil = -1000000;
		int minimum =1000000;
		
		for(int i = 0; i<n; i++) {
			arr[i]=sc.nextInt();
			if(arr[i]>ceil) {
				ceil = arr[i];
			}
			if(arr[i]<minimum) {
				minimum =arr[i];
			}
		}
		
		System.out.print(minimum);
		System.out.print(" ");
		System.out.print(ceil);
	}

}
