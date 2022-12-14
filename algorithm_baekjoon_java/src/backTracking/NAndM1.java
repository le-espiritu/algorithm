package backTracking;

// 백준 알고리즘 15649번 문제 - 백트래킹 활용하여 풀이

/*
  
1. 아이디어
	- 백트래킹 재귀함수 안에서 for문 돌면서 숫자 선택 (이때 방문여부 확인 )
	- 재귀함수에서 M개를 선택할 경우 print

2. 시간복잡도
	- N! (N팩토리얼  - N * N-1 * N-2...)

3. 자료구조 
	- 결과값을 저장할 배열 - int[] / ArrayList 
	- 방문여부 체크하는 boolean []

*/


import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class NAndM1 {
	
	public static int n;
	public static int m;
	public static List<Integer> rsList;
	//public static int[] rs;
	public static boolean[] chk;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		//rs = new int[m];
		rsList = new ArrayList<>();
		chk = new boolean[n+1];
		
		bt(0);
		
	}
	
	
	// 트리구조를 생각하며 백트래킹을 구현한다. 
	public static void bt(int depth) {
		if(depth==m) { // 재귀함수는 깊이가 끝나는 시점을 명시해줘야 한다. 
			 // 이 코드에서 depth==m이라는 의미는 재귀함수를 m+1번째 실행하고 있다는 의미이다.
		     // (처음 depth가 0이었기 때문에)
		     // 재귀함수를 m+1번째 실행시킬때는 제시된 M이라는 길이를 넘어가기 때문에
		     // 이전에 이미 M길이 만큼 하나의 수열이 완성되었다는 뜻이며 그렇기 때문에
		     // 더 이상 아래 for문으로 내려가서는 안되고, 수열이 완성되었을때 실행되어야할 동작을 구현해줘야한다.
		     
			
//			for(int j =0; j<rs.length; j++) {
//				// 하나의 수열이 완성될때까지 rs배열에 담았던 숫자들을 차례로 출력해준다.
//				System.out.print(rs[j]+" ");
//			}
			
			for(int j=0; j<rsList.size(); j++) {
				// 하나의 수열이 완성될때까지 rsList에 담았던 숫자들을 차례로 출력해준다.
				System.out.print(rsList.get(j)+" ");
			}
			
			System.out.println();
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(!chk[i]) {
				// 현재 상태의 노드를 자식 노드에서 중복 선택하지 않기 위해서 boolean 체크함
				chk[i]=true;
				//rs[depth]=i;
				rsList.add(i);
				bt(depth+1);
				
				// 자식노드 방문이 끝나고 돌아오면 현재 상태의 방문노드를 방문하지 않은 상태로 변경 
		        // 그래야지 다음 i번째의 노드의 자식 노드로써 활용이 될 수 있을테니까.
				chk[i]=false;
				//rsList.remove(depth); 이렇게 코드를 짜면 시간 초과가 됨 왜??
				rsList.remove(rsList.size()-1);
				
				
			}
		}
	}

}
