package twoPointer;

import java.util.Scanner;

// 백준 알고리즘 2003번 수들의 합2 번 문제 풀이 - 투 포인터 활용 

public class Sum2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i =0; i<n; i++) {
			arr[i]= sc.nextInt();
		}
		
		int count=0;
		int sum=0;
		int i=0; // start point
		int j=0; // end point
		
		while(true) {
			if(sum>=m) {
				sum-=arr[i];
				i++;
			}else if(j==n) { // sum이 m값 보다 작고, j가 n값에 도달할때까지 모두 값을 더해 더이상 더할 수 없는 경우 
				break;
			}else {	// sum이 m값 보다 작지만 아직 더할 값이 남아 있는 경우 
				sum+=arr[j];
				j++;
			}
			
			if(sum==m) {
				count++;
			}

		}
		
		System.out.println(count);

	}

}
