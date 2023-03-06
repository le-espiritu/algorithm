package dp;

import java.util.Scanner;

public class P1912 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] seq = new int[n];
		int[] dp = new int[n];
		
		for(int i=0; i<n; i++) {
			seq[i]= sc.nextInt();
		}
		
		dp[0]=seq[0];
		
		int max = dp[0];
		
		for(int i=1; i<n; i++) {
			int sum = dp[i-1]+seq[i];
			dp[i]= Math.max(sum, seq[i]);
			
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);

	}

}