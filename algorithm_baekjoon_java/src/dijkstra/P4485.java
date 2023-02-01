package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P4485 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int problemNum =1;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) {
				break;
			}
			
			int[][] map = new int[n][n];
			int[][] dist = new int[n][n];
			
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					
					dist[i][j]=Integer.MAX_VALUE;
				}
			}
			
			int[] dy = {0,1,0,-1};
			int[] dx = {1,0,-1,0};
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.offer(new Edge(0,0,map[0][0]));
			
			while(!pq.isEmpty()) {
				Edge nowEdge = pq.poll();
				
				int x = nowEdge.x;
				int y = nowEdge.y;
				
				if(nowEdge.cost>dist[y][x]) {
					continue;
				}
				
				for(int i=0; i<4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					
					if(nx>=0 && nx<n && ny>=0 && ny<n) {
						if(dist[ny][nx]>nowEdge.cost+map[ny][nx]) {
							dist[ny][nx]=nowEdge.cost+map[ny][nx];
							pq.offer(new Edge(nx,ny,dist[ny][nx]));
						}
					}
				}
			}
			
			sb.append("Problem "+problemNum+": "+dist[n-1][n-1]+"\n");
			problemNum++;
			
		}
		
		System.out.println(sb);

	}
	
	public static class Edge implements Comparable<Edge>{
		int x;
		int y;
		int cost;
		
		public Edge(int x, int y, int cost) {
			this.x =x;
			this.y =y;
			this.cost =cost;
		}
		
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

}
