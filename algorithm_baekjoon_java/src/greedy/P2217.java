package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class P2217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int max =0;
		int division =1;
		
		for(int i =n-1; i>=0; i--) {
			int result=arr[i]*division;
			max=Math.max(max, result);
			division++;
		}
		
		System.out.println(max);

	}

}
