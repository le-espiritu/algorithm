package dp;

import java.util.Scanner;

// 백준 알고리즘 2748번 문제 피보나치수2 문제 풀이 - DP 알고리즘 
// n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오

public class P2748 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 자료형이 int 일때는, 입력값이 90일 경우 90번째 피보나치수가
		// int가 담을 수 있는 최대값인 21억을 넘어가기 때문에 쓰레기 수가 되었다.
		// 그래서 채점할때 오답으로 나왔으며, int를 long으로 바꿨더니 다시 정답이 되었다. 
		long[] arr = new long[n+1];
		
		arr[0]=0;
		arr[1]=1;
		
		for(int i=2; i<arr.length; i++) {
			arr[i]=arr[i-1]+arr[i-2];
		}
		
		System.out.println(arr[n]);

	}

}
