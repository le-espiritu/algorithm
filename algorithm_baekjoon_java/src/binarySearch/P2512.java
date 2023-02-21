package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class P2512 {
	
	public static int n;
	public static int[] arr;
	public static int m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n];
		for(int i=0; i<arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		m = sc.nextInt();
		
		int lo=1;
		int hi=arr[n-1]+1;
		
		int result= upperBound(lo,hi);
		
		System.out.println(result);
	}
	
	public static int upperBound(int lo, int hi) {
		
		while(lo<hi) {
			int mid = (lo+hi)/2;
			
			int sum=0;
			for(int i=0; i<arr.length; i++) {
				if(arr[i]>mid) {
					sum+=mid;
				}else {
					sum+=arr[i];
				}
			}
			
			if(sum>m) {
				hi=mid;
			}
			else if(sum<=m) {
				lo=mid+1;
			}
			
		}
		
		return lo-1;
	}

}
