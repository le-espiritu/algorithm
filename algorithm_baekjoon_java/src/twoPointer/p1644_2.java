package twoPointer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 백준 1644번 소수의 연속합 문제 - 투포인터 알고리즘 활용  

public class p1644_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		boolean[] prime = new boolean[n+1];
		// n이하 모든 소수 구하기 
		prime[0]=true;
		prime[1]=true;
		
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(prime[i]==true) {
				continue;
			}
			for(int j=i*i; j<prime.length; j=j+i) {
				prime[j]=true;
			}
		}
		
		List<Integer> primeList = new ArrayList<>();
		for(int i=0; i<prime.length; i++) {
			if(prime[i]==false) {
				primeList.add(i);
			}
		}
		
		
		int sum=0;
		int count=0;
		int start=0;
		int end=0;
		
		while(true) {
			
			if(end==primeList.size()) {
				if(sum==n || sum<n) {
					break;
				}
			}
			
			if(sum<n) {
				sum+=primeList.get(end);
				end++;
			}else {
				sum-=primeList.get(start);
				start++;
			}
			
			if(sum==n) {
				count++;
			}
			
		}
		
		System.out.println(count);
		
		
	}

}
