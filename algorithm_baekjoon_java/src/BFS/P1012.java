package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1012 {
	
	public static int m;
	public static int n;
	
	public static int[][] map;
	public static boolean[][] chk;
	public static StringBuilder sb=new StringBuilder();
	
	public static int[] dy = {0,1,0,-1};
	public static int[] dx = {1,0,-1,0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			map=new int[n][m];
			
			for(int j=0; j<k; j++) {
				st=new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[y][x]=1;
			}
			
			//bfs
			chk=new boolean[n][m];
			
			int count=0;
			
			for(int j=0; j<n; j++) {
				for(int h=0; h<m; h++) {
					if(chk[j][h]==false && map[j][h]==1) {
						chk[j][h]=true;
						bfs(j,h);
						count++;
					}
				}
			}
			
			sb.append(count+"\n");
			
		}
		
		System.out.println(sb);

	}
	
	public static void bfs(int y, int x) {
		Queue<Space> qu = new LinkedList<>();
		qu.offer(new Space(y,x));
		
		while(!qu.isEmpty()) {
			Space nowSpace = qu.poll();
			
			for(int i=0; i<4; i++) {
				int ny = nowSpace.y + dy[i];
				int nx = nowSpace.x + dx[i];
				
				if(ny>=0 && ny<n && nx>=0 && nx<m) {
					if(chk[ny][nx]==false && map[ny][nx]==1) {
						chk[ny][nx]=true;
						qu.offer(new Space(ny,nx));
					}
				}
			}
		}
	}
	
	public static class Space{
		int x;
		int y;
		
		public Space(int y, int x) {
			this.y=y;
			this.x=x;
		}
	}

}
