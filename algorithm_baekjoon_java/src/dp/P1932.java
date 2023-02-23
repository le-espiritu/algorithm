package dp;

import java.util.Scanner;

public class P1932 {
	
	public static int[][] tri;
	public static Integer[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		tri = new int[n][n];
		dp = new Integer[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<i+1; j++) {
				tri[i][j]=sc.nextInt();
			}
		}
		
		for(int i=0; i<n; i++) {
			dp[n-1][i]=tri[n-1][i];
		}
		
		int answer = DP2(0,0);
		
		System.out.println(answer);
	}
	
	public static int DP(int depth, int idx) {
		
		if(dp[depth][idx]==null) {
			int max =0;
			for(int i=idx; i<=idx+1; i++) {
				int rs = DP(depth+1,i);
				max = Math.max(max,rs);
			}
			dp[depth][idx]=tri[depth][idx]+max;
			return dp[depth][idx];
		}
		else {
			return dp[depth][idx];
		}
	}
	
	public static int DP2(int depth, int idx) {
		if(dp[depth][idx]==null) {
			dp[depth][idx]=Math.max(DP2(depth+1,idx), DP2(depth+1,idx+1))+tri[depth][idx];
			
			return dp[depth][idx];
		}
		else {
			return dp[depth][idx];
		}
	}

}
