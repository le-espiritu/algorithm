package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 알고리즘 1926번 그림 문제를 BFS 알고리즘을 활용하여 풀이한 방법 

/*
 1.아이디어  
 - 2중 for => 값 1 && 방문 X => BFS
 - BFS 돌면서 그림 개수 +1, 최대값을 갱신 
 
 2.시간복잡도
 - BFS : O(V+E)
 - v : m X n  => 500 * 500
 - E : V X 4 (넉넉잡아) => 500 * 500 * 4 
 - V+E : 5 * 250000 = 100만 => 2억보다 작음 => 가능!  
 
 3.자료구조 
 - 그래프 전체 지도 : int[][]
 - 방문 boolean[][]
 - Queue(BFS) 
 */

public class Drawing2 {
	
	public static int n;
	public static int m;
	public static int[][] map;
	public static boolean[][] chk;
	
	public static int[] dy = {0,1,0,-1}; // 동남서북 
	public static int[] dx = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		chk = new boolean[n][m];
		
		
		//지도 그리기 
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int count=0; // 그림 갯수 
		int maxv=0; // 그림 최대 크기 
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] ==1 && chk[i][j]==false) {
					chk[i][j] = true;
					count ++; // bfs가 시작될때마다 count++ 해줌
					// 새로운 bfs가 시작될때마다 새로운 그림을 발견했다는 의미이기 때문
					maxv = Math.max(maxv, bfs(i,j));
					
				}
			}
		}
		
		System.out.println(count);
		System.out.println(maxv);

	}
	
	public static int bfs(int x, int y) {
		int rs = 1;
		Node node = new Node(x,y);
		Queue<Node> q = new LinkedList<>();
		q.offer(node);
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			for(int k=0; k<4; k++) {
				int nx = curNode.x + dx[k];
				int ny = curNode.y + dy[k];
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(map[nx][ny]==1 && chk[nx][ny]==false) {
						rs++;
						chk[nx][ny] = true;
						Node nextNode = new Node(nx,ny);
						q.offer(nextNode);
					}
				}
			}
		}
		
		return rs;
	}
	
	public static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	


}
