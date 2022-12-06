package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 11047번 동전0 문제 풀이 - 그리디 알고리즘 적용 
/* 
 1. 아이디어
 - for문을 돌면서 동전 사용개수 추가
 - 동전 사용한 만큼 k값 갱신 
 
 2. 시간복잡도
 -O(N)
 
 3. 자료구조 
 - 동전 금액 : int[]
 - 동전 사용 count : int
 - 남은금액(갱신한 k값)int
 */

public class Coin0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[n];
		
		for(int i=0; i<n; i++) {
			coins[i]=Integer.parseInt(br.readLine());
		}
		
		int count=0;
		
		for(int i=n-1; i>=0; i--) {
			count += k/coins[i];
			k=k%coins[i];
		}
		
		System.out.println(count);

	}

}
