package dfs;

//백준 알고리즘 2667번 단지번호붙이기 문제 - dfs를 활용하여 풀이 

/*
 1. 아이디어 
 - 2중 for, 값 1 && 방문 x => DFS
 - DFS를 통해 찾은 값을 저장 후 정렬 해서 출력
 
 2. 시간복잡도
 - DFS : O(V+E)
 - V, E : N^2, 4N^2
 - V+E : 5N^2 => N^2 => 625 => 가능 
 
 3. 자료구조 
 - 그래프 저장 : int[][]
 - 방문여부 : boolean[][]
 - 결과값 : int[]
 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComplexLabelling2 {
	
	public static int n;
	public static int[][] map;
	public static boolean[][] chk;
	
	public static int each;
	
	public static int[] dy= {0,1,0,-1}; // 동남서북 순서 
	public static int[] dx= {1,0,-1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		chk = new boolean[n][n];
		List<Integer> result = new ArrayList<>();
		
		//지도 그리기  
		for(int i =0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j]=Character.getNumericValue(str.charAt(j));
			}
		}
		
		//지도 순회하기 
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] ==1 && chk[i][j]==false) {
					chk[i][j] = true; // 새로운 단지의 첫 루트 노드 발견 
					each =0; // 집 갯수를 카운트하는 each 초기화 
					dfs2(i,j); // 루트 노드의 자식 노드들을 DFS 순
					result.add(each);// 순회 모두 마치고, 순회 돌면서 카운트 한 값을 List에 저장 
					
				}
			}
		}
		
		Collections.sort(result); // 컬렉션 프레임워크의 인터페이스 구현체들을 정렬할때 사용 
		// 일반적인 배열을 정렬할때는 Arrays.sort(); 를 사용한다.
		System.out.println(result.size());
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}

	}
	
	public static void dfs2(int x, int y) {
		each +=1;
		for(int k=0; k<4; k++) {
			int nx = x+dx[k];
			int ny = y+dy[k];
			if(nx>=0 && nx<n && ny>=0 && ny<n) { // 다음 노드의 인덱스가 지도의 범위를 넘어가지 않는지 체크 
				if(map[nx][ny]==1 && chk[nx][ny]==false) {
					// 아래 재귀 호출은 위 if문 조건을 만족해야지만 실행된다.
					// 만약 if문 조건이 만족이 안된다면 재귀 호출 못하고, 함수 끝까지 실행되고, 함수 종료됨.
					chk[nx][ny] = true;
					dfs2(nx, ny);
				}
			}
		}
		
	}
	

}
