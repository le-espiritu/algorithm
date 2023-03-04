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
		if(dp[idx]==null) { // 수열 길이가 몇인지 아직 찾아보지 않았다는 의미 
			dp[idx]=1; //  1로 초기화 => 일단 자기 자신이 있으니 수열 길이가 최소 1은 된다는 의미 
			
			for(int j=idx-1; j>=0; j--) { // 수열 길이를 찾고자 하는 인덱스의 이전 인덱스들을 모두 탐색 
				if(seq[j]<seq[idx]) { // 이전 인덱스의 원소가 현재 인덱스의 원소보다 작다면 
					dp[idx]=Math.max(dp[idx], LIS(j)+1); // 이전 인덱스의 LIS에 +1(자기 자신을 더해줌)한 값과 현재 자기자신의 수열 길이를 비교해서 갱신 해줌. 
					// 갱신하는 이유는 이전 인덱스(idx-1)의 원소 값이 전전 인덱스(idx-2)의 원소 값보다 작을수도 있기 때문이다.
				}
			}
		}
		
		return dp[idx];
	}

}
