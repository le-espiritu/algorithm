package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P2665 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		
		int[][] map = new int[n][n];
		int[][] dist = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<n; j++) {
				int room = Character.getNumericValue(line.charAt(j));
				if(room==1) {
					map[i][j]=0;
				}else if(room==0) {
					map[i][j]=1;
				}
				
				dist[i][j]=Integer.MAX_VALUE;
			}
		}
		
		int[] dy= {0,1,0,-1};
		int[] dx= {1,0,-1,0};
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[0][0]=0;
		pq.offer(new Edge(0,0,0));
		
		while(!pq.isEmpty()) {
			Edge nowEdge = pq.poll();
			
			int y = nowEdge.y;
			int x = nowEdge.x;
			
			if(nowEdge.cost>dist[y][x]) {
				continue;
			}
			
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(ny>=0 && ny<n && nx>=0 && nx<n) {
					if(dist[ny][nx]>nowEdge.cost+map[ny][nx]) {
						dist[ny][nx]=nowEdge.cost+map[ny][nx];
						pq.offer(new Edge(ny,nx,dist[ny][nx]));
					}
				}
			}
		}
		
		System.out.println(dist[n-1][n-1]);
		
		
	}
	
	public static class Edge implements Comparable<Edge>{
		int y;
		int x;
		int cost;
		
		public Edge(int y, int x, int cost) {
			this.y=y;
			this.x=x;
			this.cost=cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

}
