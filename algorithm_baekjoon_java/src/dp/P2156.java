package dp;

import java.util.Scanner;

public class P2156 {
	
	static int n;
	static int[] arr;
	
	static Integer[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n= sc.nextInt();
		arr = new int[n+1];
		dp = new Integer[n+1];
		
		for(int i=1; i<n+1; i++) {
			arr[i]=sc.nextInt();
		}
		
		dp[0]=0;
		dp[1]=arr[1];
		
		if(n>1) {
			dp[2]=arr[1]+arr[2];
		}
		
		int rs = recur(n);
		
		System.out.println(rs);

	}
	
	static int recur(int idx) {
		
		if(dp[idx]==null) {
			dp[idx]= Math.max(Math.max(recur(idx-2), recur(idx-3)+arr[idx-1])+arr[idx],recur(idx-1));
		}
		
		return dp[idx];
	}
	
}
