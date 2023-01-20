package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1261 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[m+1][n+1];
		for(int i=1; i<m+1; i++) {
			String line = br.readLine();
			for(int j=1; j<n+1; j++) {
				map[i][j]= Character.getNumericValue(line.charAt(j-1));
			}
		}
		
		int[][] dist = new int[m+1][n+1];
		for(int i=1; i<m+1; i++) {
			for(int j=1; j<n+1; j++) {
				dist[i][j]=Integer.MAX_VALUE;
			}
		}
		
		int[] dy = {0,1,0,-1};
		int[] dx = {1,0,-1,0};
		
		PriorityQueue<Room> pq = new PriorityQueue<>();
		pq.add(new Room(1,1,0));
		dist[1][1]=0;
		
		while(!pq.isEmpty()) {
			Room nowRoom = pq.poll();
			
			int x = nowRoom.x;
			int y = nowRoom.y;
			
			if(nowRoom.cost>dist[y][x]) {
				continue;
			}
			
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(ny>=1 && ny<m+1 && nx>=1 && nx<n+1) {
					if(dist[ny][nx]>nowRoom.cost+map[ny][nx]) {
						dist[ny][nx]=nowRoom.cost+map[ny][nx];
						pq.offer(new Room(ny,nx,dist[ny][nx]));
					}
				}
			}
			
		}
		
		System.out.println(dist[m][n]);
		
		

	}
	
	public static class Room implements Comparable<Room>{
		int x;
		int y;
		int cost;
		
		public Room(int y, int x, int cost) {
			this.y=y;
			this.x=x;
			this.cost=cost;
		}
		
		public int compareTo(Room o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

}
