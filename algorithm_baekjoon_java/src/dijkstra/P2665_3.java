package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P2665_3 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n][n];
		int[][] dist = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j]= Character.getNumericValue(line.charAt(j));
				dist[i][j]= Integer.MAX_VALUE;
			}
		}
		
		int[] dy = {0,1,0,-1};
		int[] dx = {1,0,-1,0};
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0,0,0));
		dist[0][0]=0;
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			
			if(e.cost>dist[e.y][e.x]) {
				continue;
			}
			
			for(int i=0; i<4; i++) {
				int ny=e.y+dy[i];
				int nx=e.x+dx[i];
				
				if(ny>=0 && ny<n && nx>=0 && nx<n) {
					int nextCost=0;
					if(map[ny][nx]==1) {
						nextCost=e.cost+0;
					}else if(map[ny][nx]==0) {
						nextCost=e.cost+1;
					}
					
					if(dist[ny][nx]>nextCost) {
						dist[ny][nx]=nextCost;
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
		
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

}
