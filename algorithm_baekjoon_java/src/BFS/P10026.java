package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P10026 {
	
	public static int n;
	public static char[][] board;
	public static char[][] rgBoard;
	
	public static boolean[][] nomalChk;
	public static boolean[][] rgChk;
	
	public static int[] dy= {0,1,0,-1};
	public static int[] dx= {1,0,-1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		board = new char[n][n];
		rgBoard= new char[n][n];
		
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<n; j++) {
				board[i][j]=line.charAt(j);
				
				if(line.charAt(j)=='G') {
					rgBoard[i][j]='R';
				}else {
					rgBoard[i][j]=line.charAt(j);
				}
			}
		}
		
		nomalChk=new boolean[n][n];
		rgChk = new boolean[n][n];
		
		int nomalCount=0;
		int rgCount=0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(nomalChk[i][j]==false) {
					nomalChk[i][j]=true;
					bfs(i,j,board,nomalChk);
					nomalCount++;
				}
				
				if(rgChk[i][j]==false) {
					rgChk[i][j]=true;
					bfs(i,j,rgBoard,rgChk);
					rgCount++;
				}
			}
		}
		
		System.out.println(nomalCount+" "+rgCount);

	}
	
	public static void bfs(int y, int x, char[][] paintings, boolean[][] ck) {
		Queue<Point> qu = new LinkedList<>();
		qu.offer(new Point(y,x));
		
		while(!qu.isEmpty()) {
			Point p = qu.poll();
			
			for(int i=0; i<4; i++) {
				int ny = p.y+dy[i];
				int nx = p.x+dx[i];
				
				if(ny>=0 && ny<n && nx>=0 && nx<n) {
					if(ck[ny][nx]==false && paintings[p.y][p.x]==paintings[ny][nx]) {
						ck[ny][nx]=true;
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
