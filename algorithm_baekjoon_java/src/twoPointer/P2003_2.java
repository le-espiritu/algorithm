package twoPointer;

import java.util.Scanner;

// 백준 알고리즘 2003번 수들의 합2 번 문제 풀이2 - 투 포인터 활용 

public class P2003_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr =new int[n];
		
		for(int i=0; i<arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		
		int count=0;
		int sum=0;
		int start =0;
		int end = 0;
		
		while(true) {
			if(sum<m) {
				sum+=arr[end];
				end++;
			}else {
				sum-=arr[start];
				start++;
			}
			
			if(sum==m) {
				count++;
			}
			
			if(end==n) {
				if(sum==m || sum<m) {
					break;
				}
			}
		}
		
		System.out.println(count);

	}

}
