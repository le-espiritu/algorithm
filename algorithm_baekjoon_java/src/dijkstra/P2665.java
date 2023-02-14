package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2665 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][]map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<n; j++) {
				int room = Character.getNumericValue(line.charAt(j));
				if(room==1) {
					map[i][j]=0;
				}else if(room==0) {
					map[i][j]=1;
				}
			}
		}
		
		//다익스트라
		int[][] dist = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				dist[i][j]=Integer.MAX_VALUE;
			}
		}
		
		int[] dy= {0,1,0,-1};
		int[] dx= {1,0,-1,0};
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0,0,0));
		dist[0][0]=0;
		
		while(!pq.isEmpty()) {
			Edge nowEdge =pq.poll();
			
			if(nowEdge.cost>dist[nowEdge.y][nowEdge.x]) {
				continue;
			}
			
			for(int i=0; i<4; i++) {
				int ny = nowEdge.y+dy[i];
				int nx = nowEdge.x+dx[i];
				
				if(ny>=0 && ny<n && nx>=0 && nx<n) {
					if(dist[ny][nx]>map[nowEdge.y][nowEdge.x]+map[ny][nx]) {
						dist[ny][nx]=map[nowEdge.y][nowEdge.x]+map[ny][nx];
						pq.offer(new Edge(ny,nx,dist[ny][nx]));
					}
				}
			}
		}
		
		System.out.println(dist[n-1][n-1]);
		
		

	}
	
	public static class Edge implements Comparable<Edge>{
		int x;
		int y;
		int cost;
		
		public Edge(int y, int x, int cost) {
			this.x=x;
			this.y=y;
			this.cost=cost;
		}
		
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

}
