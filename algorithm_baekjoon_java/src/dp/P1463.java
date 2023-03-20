package dp;

import java.util.Scanner;

public class P1463 {
	
	static int N;
	static Integer[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		dp=new Integer[N+1];
		
		dp[0]=0;
		dp[1]=0;
		
		int result = recur(N);
		
		System.out.println(result);

	}
	
	static int recur(int n) {
		
		if(dp[n]==null) {
			if(n%6==0) {
				dp[n]=Math.min(recur(n-1), Math.min(recur(n/2), recur(n/3)))+1;
			}
			else if(n%3==0) {
				dp[n]=Math.min(recur(n/3), recur(n-1))+1;
			}
			else if(n%2==0) {
				dp[n]=Math.min(recur(n/2), recur(n-1))+1;
			}
			else {
				dp[n]=recur(n-1)+1;
			}
		}
		
		return dp[n];
	}

}
