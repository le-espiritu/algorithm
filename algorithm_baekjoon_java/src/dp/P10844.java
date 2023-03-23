package dp;

import java.util.Scanner;

public class P10844 {
	
	static Long[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		dp = new Long[n+1][10];
		
		for(int i=0; i<10; i++) {
			dp[1][i]=1L;
		}
		
		long sum=0;
		
		for(int i=1; i<10; i++) {
			sum+=recur(n,i);
		}
		
		System.out.println(sum%1000000000);

	}
	
	static long recur(int digit, int idx) {
		if(dp[digit][idx]==null) {
			if(idx==0) {
				dp[digit][idx]=recur(digit-1,1);
			}
			else if(idx==9) {
				dp[digit][idx]=recur(digit-1,8);
			}
			else {
				dp[digit][idx]=recur(digit-1,idx-1)+recur(digit-1,idx+1);
			}
		}
		
		
		return dp[digit][idx] %1000000000 ;
	}

}
