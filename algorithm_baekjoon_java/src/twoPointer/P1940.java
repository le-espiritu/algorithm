package twoPointer;

import java.util.Arrays;
import java.util.Scanner;

public class P1940 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int startP = 0;
		int endP=arr.length-1;
		
		int count=0;
		
		while(startP<endP) {
			int sum = arr[startP]+arr[endP];
			
			if(sum==m) {
				count++;
				startP++;
			}
			else if(sum<m) {
				startP++;
			}
			else if(sum>m) {
				endP--;
			}
		}
		
		System.out.println(count);

	}

}
