package level2;

// 프로그래머스 알고리즘 레벨2 멀리뛰기 문제 풀 

public class TheLongJump {
	public static void main(String[] args) {
		int n = 4;
		long answer = solution(n);
		System.out.println(answer);

	}
	
	
	//dp 점화식, 피보나치수를 활용하여 풀이 한다.
	public static long solution(int n) {
		int[] dp = new int[2001];
		
		dp[1]=1;
		dp[2]=2;
		
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-1]+dp[i-2];
			dp[i]=dp[i]%1234567;
		}
		
		return dp[n];
	}

}
