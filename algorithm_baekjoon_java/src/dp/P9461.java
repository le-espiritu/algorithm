package dp;

import java.util.Scanner;

public class P9461 {
	
	static Long[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();
			
			dp = new Long[n+1];
			
			dp[0]=0L;
			dp[1]=1L;
			
			if(n>1) {
				dp[2]=1L;
			}
			
			Long result = recur(n);
			
			sb.append(result+"\n");
		}
		
		System.out.println(sb);

	}
	
	static Long recur(int n) {
		
		if(dp[n]==null) {
			dp[n]=recur(n-2)+recur(n-3);
		}
		return dp[n];
	}

}
