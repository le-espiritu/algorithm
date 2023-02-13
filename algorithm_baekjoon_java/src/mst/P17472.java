package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17472 {
	
	public static int n;
	public static int m;
	public static int[][] map;
	public static boolean[][] labelChk;
	
	public static List<Edge>[] graph;
	
	public static int[] dy = {0,1,0,-1};
	public static int[] dx = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int islandCount=0;
		
		int label=2; // 섬마다 라벨링하기 위한 변수 , 0,1은 사용중이기 때문에 (바다와 육지) 2로 초기화 
		labelChk = new boolean[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==1 && labelChk[i][j]==false) {
					labelChk[i][j]=true;
					map[i][j]=label;
					labeling(i,j,label);
					islandCount++;
					label++;
				}
			}
		}
		
		// 섬 사이 다리 놓기 
		graph=new ArrayList[islandCount+2];
		for(int i=0; i<graph.length; i++) {
			graph[i]=new ArrayList<>();
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]!=0) {
					makeBridge(i,j);
				}
			}
		}
		
		//mst
		boolean[] visited = new boolean[islandCount+2];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(2,0));
		
		int cost =0;
		
		while(!pq.isEmpty()) {
			Edge nowEdge = pq.poll();
			
			if(visited[nowEdge.v]==false) {
				visited[nowEdge.v]=true;
				cost+=nowEdge.cost;
				
				for(Edge next : graph[nowEdge.v]) {
					if(visited[next.v]==false) {
						pq.offer(next);
					}
				}
			}
			
		}
		
		for(int i=2; i<visited.length; i++) {
			if(visited[i]==false) {
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(cost);
		

	}
	
	public static void labeling(int y, int x, int label) {
		Queue<int[]> qu = new LinkedList<>();
		qu.offer(new int[] {y,x}); // y값과 x값을 담는 객체(클래스)를 생성하는 대신에 간편하게 이런 방식으로 사용함.
		while(!qu.isEmpty()) {
			int[] nowPoint = qu.poll();
			int nowY = nowPoint[0]; // y좌표 
			int nowX = nowPoint[1]; // x좌표
			
			for(int i=0; i<4; i++) {
				int nextY = nowY+dy[i];
				int nextX = nowX+dx[i];
				
				if(nextY>=0 && nextY <n&& nextX>=0 && nextX<m) {
					if(map[nextY][nextX]==1 && labelChk[nextY][nextX]==false) {
						labelChk[nextY][nextX]=true;
						map[nextY][nextX]=label;
						qu.offer(new int[] {nextY,nextX});
					}
				}
			}
		}
		
	}
	
	public static void makeBridge(int y, int x ) {
		Queue<int[]> qu = new LinkedList<>();
		//bridgeChk=new boolean[n][m]; // 중요 
		//다른분 코드에서 makeBridge 메소드를 호출할때마다 메소드 안에서 boolean배열이 생성되게 코드가 짜여 있었지만
		//코드의 흐름을 자세히 보면 boolean체크 자체가 필요하지 않음 
		
		for(int i=0; i<4; i++) {
			qu.offer(new int[]{y,x,0});
			
			while(!qu.isEmpty()) {
				int[] nowPoint = qu.poll();
				int nowY = nowPoint[0];
				int nowX = nowPoint[1];
				int dist = nowPoint[2];
				
				int ny=nowY+dy[i];
				int nx=nowX+dx[i];
				
				if(ny>=0 && ny<n && nx>=0 && nx<m ) {
					if(map[ny][nx]!=map[y][x]) {
						if(map[ny][nx]!=0) {
							int fromLabel = map[y][x];
							int toLabel=map[ny][nx];
							if(dist>=2) {
								graph[fromLabel].add(new Edge(toLabel,dist));
								break;
							}
						}
						else {
							qu.offer(new int[] {ny,nx,dist+1});
						}
					}
				}
			}
			qu.clear();
		}
		
	}
	
	public static class Edge implements Comparable<Edge>{
		int v;
		int cost;
		
		public Edge(int v, int cost) {
			this.v=v;
			this.cost=cost;
		}
		
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	

}
