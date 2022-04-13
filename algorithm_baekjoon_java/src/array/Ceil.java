package array;

import java.util.Scanner;

public class Ceil {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int ceil = 0;
		int ceilIndex = 0;
		
		for(int i = 0; i<9; i++ ) {
			arr[i]=sc.nextInt();
			if(arr[i]>ceil) {
				ceil = arr[i];
				ceilIndex=i+1;
			}
		}
		
		System.out.println(ceil);
		System.out.println(ceilIndex);
		
	}

}
