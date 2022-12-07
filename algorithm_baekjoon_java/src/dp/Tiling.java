package dp;

import java.util.Scanner;

// 백준 11726 타일링 문제 - DP 알고리즘을 활용하여 풀이 

/*
 1.아이디어 
 -점화식 : An = An-1 + An-2
 -N값 구하기 위해, for문 3부터 N까지의 값을 구해주기
 -이전값, 이전이전값 더해서, 10007로 나눠 저장
 
 2. 시간복잡도
 -O(N)
 
 3. 자료구조
 -DP값 저장하는 (경우의수) 배열 : int[]
 - 최대값 : 10007보다 작음 > Int
 
 */

public class Tiling {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] rs = new int[n+1];
		
		rs[0]=0;
		rs[1]=1;
		if(n>1) {
			rs[2]=2;
		}
		
		for(int i=3; i<rs.length; i++) {
			rs[i]=(rs[i-1]+rs[i-2])%10007;
		}
		
		System.out.println(rs[n]);

	}

}
