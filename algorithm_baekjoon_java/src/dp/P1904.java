package dp;

import java.util.Scanner;

public class P1904 {
	
	static Long[]dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		dp = new Long[n+1];
		
		dp[1]=1L;
		if(n>1) {
			dp[2]=2L;
		}
		
		Long result = recur(n);
		
		System.out.println(result);

	}
	
	static Long recur(int num) {
		
		if(dp[num]==null) {
			dp[num]=recur(num-2)+recur(num-1);
		}
		
		return dp[num]%15746;
	}

}
