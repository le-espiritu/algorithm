package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 7569 토마토 - BFS

public class P7569_2 {
	
	public static int m; // 상자의 가로칸 수  
	public static int n; // 상자의 세로 칸 수 
	public static int h; // 쌓아올려지는 상자의 수  
	
	public static int[][][] board;
	public static Queue<Tomato> qu;
	
	public static int[] dy= {0,1,0,-1,0,0};
	public static int[] dx= {1,0,-1,0,0,0};
	public static int[] dz= {0,0,0,0,1,-1};
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		board = new int[h][n][m];
		qu = new LinkedList<>();
		
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++) {
					board[k][i][j]=Integer.parseInt(st.nextToken());
					if(board[k][i][j]==1) {
						qu.offer(new Tomato(k,i,j));
					}
				}
			}
		}
		
		//bfs
		
		int dateCount=0;
		
		while(!qu.isEmpty()) {
			Tomato nowTomato = qu.poll();
			
			int z = nowTomato.z;
			int y = nowTomato.y;
			int x = nowTomato.x;
			
			dateCount = Math.max(dateCount, board[z][y][x] );
			
			for(int i=0; i<6; i++) {
				int nz = z+dz[i];
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(nz>=0 && nz<h && ny>=0 && ny<n && nx>=0 && nx<m) {
					if(board[nz][ny][nx]==0) {
						board[nz][ny][nx]= board[z][y][x]+1;
						qu.add(new Tomato(nz,ny,nx));
					}
				}
			}
			
		}
		
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(board[k][i][j]==0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		
		if(dateCount==1) {
			System.out.println(0);
		}else {
			System.out.println(dateCount-1);
		}
		
		
	}
	
	public static class Tomato{
		int z;
		int y;
		int x;
		
		public Tomato(int z, int y, int x) {
			this.z =z;
			this.y =y;
			this.x =x;
		}
	}

}
