package greedy;

import java.util.Arrays;
import java.util.Scanner;

// 백준 알고리즘 11399번 문제 풀이 - 그리디 알고리즘?  
// 총 결제 시간의 최소합을 구하기 위해
// 당장 시간이 적게 걸리는 사람부터 차례로 결제를 하게 하여 시간들을 더한다 -> 그리디 (탐욕적인) 알고리즘 

public class P11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] time = new int[n];
		
		for(int i=0; i<n; i++) {
			time[i]= sc.nextInt();
		}
		
		Arrays.sort(time);
		
		int sum=0;
		int preSum=0;
		
		for(int i=0; i<time.length; i++) {
			sum = sum+preSum+time[i];
			preSum = preSum+ time[i];
		}
		
		System.out.println(sum);
	}

}
