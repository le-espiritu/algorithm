package dp;

import java.util.Scanner;

public class P11053 {
	
	public static int[] seq;
	public static Integer[] dp; // null체크를 위해 Integer로 선언. 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		seq=new int[n];
		dp=new Integer[n];
		
		for(int i=0; i<n; i++) {
			seq[i]=sc.nextInt();
		}
		
		int max =0;
		
		for(int i=0; i<n; i++) {
			int rs = LIS(i);
			max = Math.max(max, rs);
		}
		
		System.out.println(max);
	
	}
	public static int LIS(int idx) {
		if(dp[idx]==null) {
			dp[idx]=1;
			
			for(int j=idx-1; j>=0; j--) {
				if(seq[j]<seq[idx]) {
					dp[idx]=Math.max(dp[idx], LIS(j)+1);
				}
			}
		}
		
		return dp[idx];
	}

}
