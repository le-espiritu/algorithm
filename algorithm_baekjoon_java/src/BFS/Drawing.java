package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 알고리즘 1926번 그림 문제를 BFS 알고리즘을 활용하여 풀이한 방법 

public class Drawing {
	
	static int n, m; // 도화지의 세로 크기와 가로크기 
	static int[][] arr; // 도화지에 그려질 그림을 담을 2차원 배열 
	static boolean[][] visit; // BFS를 활용하여 순회할때 방문했었는지 확인하는 2차원 배열 
	static int[] dx; // x축의 사방 좌표를 담을 배열 
	static int[] dy; // y축의 사방 좌표를 담을 배열 
	static Queue<Pair> qu;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit = new boolean[n][m];
		qu = new LinkedList<Drawing.Pair>();
		
		dx = new int[] {1,0,-1,0};
		dy = new int[] {0,1,0,-1};
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int count =0; // 그림의 갯수를 새는 변수. 
		int area =0; // 넓이를 구하는 변수 
		int max =0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				// 0이거나 방문한적이 있으면 생략  
				if(arr[i][j] ==0 || visit[i][j]) {
					continue;
				}
				count++; //0이 아니기때문에 1이고, 방문한적이 없기때문에 시작점이 된다.
				qu.offer(new Pair(i,j)); // 큐에 좌표를 넣어준다 , offer() 는 add()와 비슷 
				visit[i][j] = true; // 큐에 넣어줬으니 해당 좌표를 방문처리 한다. 
				area =0; // 새로운 그림의 넓이를 구하기위해 0으로 초기화 
				while(!qu.isEmpty()) { // 큐가 비워질때까지 반복 
					Pair p = qu.poll();
					area++; 
					for(int k =0; k<4; k++) {
						// i,j좌표의 인접한 좌표 구하는 코드 
						int n_x =p.x+dx[k];
						int n_y =p.y+dy[k];
						
						// 인접한 좌표가 도화지의 범위를 넘어간다면 continue;코드 아래로 코드실행하지않고 다음 for문 실행 
						// n_x, n_y는 인덱스이기때문에 n,m과 같다면 인덱스를 초과했다는 의미임 그래서 크거나 같으면 이라는 조건을 달아줌 
						if(n_x <0 || n_x>=n || n_y<0 || n_y >=m) {
							continue;
						}
						
						// 인접한 좌표가 1이고, 큐에 방문한적이 없으면 큐에 넣어주고 방문표시를 해줌. 
						if(arr[n_x][n_y] ==1 && !visit[n_x][n_y]) {
							qu.offer(new Pair(n_x, n_y));
							visit[n_x][n_y] = true;
						}
					}
					
				}
				if(area > max) { // 위에서 확인한 그림의 넓이가 max보다 넓으면 max를 재설정해줌. 
					max = area;
				}
				
			}
		}
		
		System.out.println(count);
		System.out.println(max);
		

	}
	
	public static class Pair{
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}

}
