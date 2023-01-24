package twoPointer;

import java.util.Arrays;
import java.util.Scanner;

public class P3273 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		int x = sc.nextInt();
		
		Arrays.sort(arr);
		
		int count =0;
		
		int start=0;
		int end=n-1;
		
		while(start<end) {
			int sum=arr[start]+arr[end];
			
			if(sum>x) {
				end--;
			}else if(sum<x) {
				start++;
			}
			
			if(sum==x) {
				count++;
				start++;
			}
		}
		
		System.out.println(count);

	}

}
