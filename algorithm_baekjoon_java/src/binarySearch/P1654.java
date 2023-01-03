package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1654 랜선 자르기 문제 - 이진탐색  

public class P1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[k];
		
		long max =0;
		
		for(int i =0; i<k;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		max++;
		
		long lo =0;
		long hi =max;
		long mid =0;
		
		while(lo<hi) {
			mid = (lo+hi)/2;
			
			long count=0;
			
			for(int i=0; i<arr.length; i++) {
				count = count+(arr[i]/mid);
			}
			
			if(count<n) {
				hi=mid;
			}else {
				lo=mid+1;
			}
		}
		
		System.out.println(lo-1);
		

	}

}
