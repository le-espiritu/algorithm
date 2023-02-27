package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P4963 {
	
	public static int w;
	public static int h;
	public static int[][] map;
	public static boolean[][] chk;
	
	public static int[] dy= {-1,-1,-1,0,1,1,1,0};
	public static int[] dx= {-1,0,1,1,1,0,-1,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) {
				break;
			}
			
			map = new int[h][w];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			chk= new boolean[h][w];
			
			int islandCount=0;
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(chk[i][j]==false && map[i][j]==1) {
						chk[i][j]=true;
						bfs(i,j);
						islandCount++;
					}
				}
			}
			
			sb.append(islandCount+"\n");
			
		}
		
		System.out.println(sb);

	}
	
	public static void bfs(int y, int x) {
		Queue<Point> qu = new LinkedList<>();
		qu.offer(new Point(y,x));
		while(!qu.isEmpty()) {
			Point p = qu.poll();
			
			for(int i=0; i<8; i++) {
				int ny=p.y+dy[i];
				int nx=p.x+dx[i];
				
				if(ny>=0 && ny<h && nx>=0 && nx<w) {
					if(chk[ny][nx]==false && map[ny][nx]==1) {
						chk[ny][nx]=true;
						qu.offer(new Point(ny,nx));
					}
				}
			}
		}
	}
	
	public static class Point{
		int y;
		int x;
		
		public Point(int y, int x) {
			this.y=y;
			this.x=x;
		}
	}

}
