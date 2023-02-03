package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2583 {
	
	public static int m;
	public static int n;
	
	public static boolean[][] map;
	
	public static int[] dy = {0,1,0,-1};
	public static int[] dx = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new boolean[m][n];
		
		for(int i=0; i<k; i++) {
			st= new StringTokenizer(br.readLine());
			
			int fromX = Integer.parseInt(st.nextToken());
			int fromY = Integer.parseInt(st.nextToken());
			int toX = Integer.parseInt(st.nextToken());
			int toY = Integer.parseInt(st.nextToken());
			
			for(int j=fromY; j<toY; j++) {
				for(int h=fromX; h<toX; h++) {
					map[j][h]=true;
				}
			}
		}
		
		int count=0;
		ArrayList<Integer> answers = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==false) {
					map[i][j]=true;
					int rs = bfs(i,j);
					count++;
					answers.add(rs);
				}
			}
		}
		
		Collections.sort(answers);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<answers.size(); i++) {
			sb.append(answers.get(i)+" ");
		}
		
		System.out.println(count);
		System.out.println(sb);

	}
	
	public static int bfs(int y, int x) {
		int rs=0;
		
		Queue<Point> qu = new LinkedList<>();
		qu.offer(new Point(y,x));
		
		while(!qu.isEmpty()) {
			Point nowPoint = qu.poll();
			rs++;
			
			for(int i=0; i<4; i++) {
				int nx = nowPoint.x+dx[i];
				int ny = nowPoint.y+dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(map[ny][nx]==false) {
						map[ny][nx]=true;
						qu.offer(new Point(ny,nx));
					}
				}
			}
			
		}
		
		return rs;
	}
	
	public static class Point{
		int x;
		int y;
		
		public Point(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}

}
