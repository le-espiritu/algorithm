package backTracking;

import java.util.Scanner;

// 백준 알고리즘 15650번 문제 풀이 - 백트래킹 활용

public class NAndM2 {
	
	public static int n;
	public static int m;
	public static int[] answer;
	public static boolean[] chk;
	
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		answer = new int[m];
		chk= new boolean[n+1];
		
		//dfs(0,0); // 내가 한 풀이
		dfs2(1,0);

	}
	
	//내가 짠 코드 
	public static void dfs(int depth, int pre) {
		if(depth==m) {
			
			for(int k=0; k<answer.length; k++) {
				System.out.print(answer[k]+" ");
			}
			System.out.println();
			return;
		}
	
		for(int i=1; i<n+1; i++) {
			if(!chk[i] && i>pre) {
				chk[i]=true;
				answer[depth]=i;
				
				dfs(depth+1,i);
				
				chk[i]=false;
			}
		}
	}
	
	//다른 분의 풀이 방법
	public static void dfs2(int at, int depth) {
		if(depth==m) {
			for(int k=0; k<answer.length; k++) {
				System.out.print(answer[k]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=at; i<=n; i++) {
			answer[depth]=i;
			dfs2(i+1,depth+1);
		}
	}

}
