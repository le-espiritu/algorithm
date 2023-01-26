package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class P2110 {
	
	public static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int c = sc.nextInt();
		
		arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int lo = 1;
		int hi = arr[n-1]-arr[0]; 
		
		int result = bs(lo,hi+1,c); // +1은 upper_bound 이기때문에 해줌 
		
		System.out.println(result);

	}
	
	public static int bs(int lo, int hi, int c) {
		while(lo < hi) {
			int mid = (hi+lo)/2;
			
			if(canInstall(mid)<c) {
				hi = mid;
			}else {
				lo = mid+1;
			}
		}
		
		return lo-1;
	}
	
	
	public static int canInstall(int mid) {
		int count =1;
		int preHouse = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			int nowHouse = arr[i];
			if(nowHouse-preHouse>=mid) {
				count++;
				preHouse=nowHouse;
			}
		}
		
		return count;
	}

}
