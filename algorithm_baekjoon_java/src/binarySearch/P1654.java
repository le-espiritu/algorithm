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
		
		//만약에 주어진 랜선이 모두 1일 경우 
		//아래 while문안 for문을 돌때 
		//arr[i]를 0으로 나누게 된다. (mid=(0+1)/2 가 되기 때문 )
		//이때 Runtime Exception이 발생하기 때문에 이 상황을 대비하기 위해 max를 +1 해준다.
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
		
		//상한은 찾고자 하는 값을 초과하는 최초의 값이다.
		// 그렇기 때문에 -1을 해준다.
		System.out.println(lo-1);
		

	}

}
