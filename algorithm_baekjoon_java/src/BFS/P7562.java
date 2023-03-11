package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7562 {
	
	static int l;
	
	static int[][] map;
	static boolean[][] chk;
	
	static int startX;
	static int startY;
	
	static int toX;
	static int toY;
	
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};
	
	// 나이트가 앞으로 두칸 이동하고 좌우로 한칸씩 이동할때 사용할 방향 인덱스를 담을 배열 
	static int[] leftRightD;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int q=0; q<t; q++) {
			l = Integer.parseInt(br.readLine());
			map=new int[l][l];
			chk = new boolean[l][l];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			toX = Integer.parseInt(st.nextToken());
			toY = Integer.parseInt(st.nextToken());
			
			bfs(startY, startX);
			
			sb.append(map[toY][toX]+"\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int y, int x) {
		Queue<Point> qu = new LinkedList<>();
		qu.offer(new Point(y,x));
		chk[y][x]=true;
		
		while(!qu.isEmpty()) {
			Point p = qu.poll();
			
			for(int i=0; i<4; i++) {
				if(i==0 || i==2) {
					leftRightD= new int[]{1,3};
				}else {
					leftRightD= new int[] {0,2};
				}
				
				for(int j=0; j<leftRightD.length; j++) {
					int ny = p.y+dy[i]+dy[i]+dy[leftRightD[j]];
					int nx = p.x+dx[i]+dx[i]+dx[leftRightD[j]];
					
					if(ny>=0 && ny<l && nx>=0 && nx<l) {
						if(chk[ny][nx]==false) {
							chk[ny][nx]=true;
							map[ny][nx]=map[p.y][p.x]+1;
							qu.offer(new Point(ny,nx));
						}
					}
				}
			}
			
		}
	}
	
	static class Point{
		int x;
		int y;
		
		public Point(int y, int x) {
			 this.y =y;
			 this.x =x;
		}
	}

}
