package backTracking;

// 백준 알고리즘 15649번 문제 - 백트래킹 활용하여 풀이

/*
  
1. 아이디어
	- 백트래킹 재귀함수 안에서 for문 돌면서 숫자 선택 (이때 방문여부 확인 )
	- 재귀함수에서 M개를 선택할 경우 print

2. 시간복잡도
	- N! (N팩토리얼  - N * N-1 * N-2...)

3. 자료구조 
	- 결과값을 저장할 배열 - 나는 배열대신 stack을 활용함 
	- 방문여부 체크하는 boolean []

*/


//import java.util.ArrayList;
//import java.util.List;

import java.util.Scanner;
import java.util.Stack;

public class NAndM1 {
	
	public static int n;
	public static int m;
	//public static List<Integer> list=new ArrayList<>();
	public static Stack<Integer> stack = new Stack<>();
	public static boolean[] chk;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		chk = new boolean[n+1];
		
		bt(0);
		
	}
	
	
	// 트리구조를 생각하며 백트래킹을 구현한다. 
	public static void bt(int depth) {
		if(depth==m) {
			
			for(int j =0; j<stack.size(); j++) {
				System.out.print(stack.get(j)+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(!chk[i]) {
				chk[i]=true;
				stack.push(i);
				bt(depth+1);
				
				// 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경 
				chk[i]=false;
				stack.pop();
			}
		}
	}

}
