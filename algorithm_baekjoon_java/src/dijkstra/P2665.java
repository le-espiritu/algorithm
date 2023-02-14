package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P2665 {
	
	public static int n;
	public static int[][]map;
	public static int[][]dist;
	
	public static int[] dy= {0,1,0,-1};
	public static int[] dx= {1,0,-1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		
		map=new int[n][n];
		dist=new int[n][n];
		
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j]= Character.getNumericValue(line.charAt(j));
				dist[i][j]=Integer.MAX_VALUE;
			}
		}
		
		bfs(0,0);
		
		System.out.println(dist[n-1][n-1]);

	}
	
	public static void bfs(int y, int x) {
		Queue<Room> qu = new LinkedList<>();
		qu.offer(new Room(y,x));
		dist[y][x]=0;
		
		while(!qu.isEmpty()) {
			Room r = qu.poll();
			
			for(int i=0; i<4; i++) {
				int ny = r.y+dy[i];
				int nx = r.x+dx[i];
				
				if(ny>=0 && ny<n && nx>=0 && nx<n) {
					if(dist[ny][nx]>dist[r.y][r.x]) {
						if(map[ny][nx]==1) {
							dist[ny][nx]=dist[r.y][r.x];
						}
						else if(map[ny][nx]==0) {
							dist[ny][nx]=dist[r.y][r.x]+1;
						}
						
						qu.offer(new Room(ny,nx));
					}
				}
			}
		}
	}

	public static class Room{
		int x;
		int y;
		
		public Room(int y, int x) {
			this.y=y;
			this.x=x;
		}
	}
	
}
