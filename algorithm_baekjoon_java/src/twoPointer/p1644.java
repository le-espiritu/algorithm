package twoPointer;

import java.util.ArrayList;
import java.util.Scanner;

// 백준 1644번 소수의 연속합 문제 - 투포인터 알고리즘 활용  

public class p1644 {
	
	public static boolean[] prime;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		makePrime(n);
		
		ArrayList<Integer> primeList = new ArrayList<>();
		
		for(int i=0; i<prime.length; i++) {
			if(prime[i]==false) {
				primeList.add(i);
			}
		}
		
		//System.out.println(primeList.size());
		
		int sum=0;
		int count=0;
		int startP =0;
		int endP=0;
		
		while(true) {
			
			if(sum>=n) {
				sum-=primeList.get(startP);
				startP++;
			}else if(endP==primeList.size()) {
				break;
			}else {
				sum+=primeList.get(endP);
				endP++;
			}
			
			if(sum==n) {
				count++;
			}
			
		}
		
		System.out.println(count);

	}
	
	public static void makePrime(int n) {
		prime = new boolean[n+1];
		
		prime[0]= true;
		prime[1]= true;
		
		if(n<2) {
			return;
		}
		
		
		// 아래코드에서 <=인데 <라고 해서 채점할때 틀림 주의하자!!
		// 또는 for(int i=2; i*i<=n; i++) 로도 코드를 작성할 수 있음 
		for(int i=2; i<=Math.sqrt(n); i++) {
			
			if(prime[i] == true) {
				continue;
			}
			
			for(int j=i*i; j<prime.length; j=j+i) {
				prime[j]=true;
			}
		}
	}

}
