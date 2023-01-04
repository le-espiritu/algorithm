package dp;

import java.util.Scanner;

// 백준 9095번 1,2,3,더하기 문제 - DP 알고리즘 활용 

public class P9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		int[] dp = new int[11];
		
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		
		for(int i=4; i<dp.length; i++) {
			dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<t; i++) {
			int idx = sc.nextInt();
			sb.append(dp[idx]+"\n");
		}
		
		System.out.println(sb);

	}

}
