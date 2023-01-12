package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 7569 토마토 - BFS

public class P7569 {
	
	public static int m; // 상자의 가로 칸수 
	public static int n; // 상자의 세로 칸수
	public static int h; // 쌓아 올려지는 상자의 수 
	
	public static int[][][] board; // 3차원 배열
	public static boolean[][][] chk;
	
	public static Queue<Tomato> q;
	
	public static int[] dy = {0,1,0,-1,0,0};
	public static int[] dx = {1,0,-1,0,0,0};
	public static int[] dz = {0,0,0,0,1,-1};
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		h=Integer.parseInt(st.nextToken());
		
		board=new int[h][n][m];
		
		q=new LinkedList<>();
		
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++) {
					board[k][i][j]=Integer.parseInt(st.nextToken());
					
					//익은 토마토가 여러곳에 산발적으로 있을 수 있고 각 토마토마다 BFS를 시작해야하니 
					// 토마토가 익었다면(1이라면) 익은 토마토 마다 전부 BFS를 하기 위한 준비를 위해 Queue에 넣어준다. 
					if(board[k][i][j]==1) {
						q.add(new Tomato(k,i,j));
					}
				}
			}
		}
		
		System.out.println(bfs());

	}
	
	public static int bfs() {
		while(!q.isEmpty()) {
			Tomato nowTomato = q.poll();
			
			int z = nowTomato.z;
			int y = nowTomato.y;
			int x = nowTomato.x;
			
			for(int k=0; k<6; k++) {
				int nz=z+dz[k];
				int ny=y+dy[k];
				int nx=x+dx[k];
				
				if(nz>=0 && nz<h && ny>=0 && ny<n && nx>=0 && nx<m) {
					if(board[nz][ny][nx]==0) {
						board[nz][ny][nx]=board[z][y][x]+1;
						q.add(new Tomato(nz,ny,nx));
					}
				}
			}
		}
		
		int result=0;
		
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(board[k][i][j]==0) {
						return-1;
					}else {
						result=Math.max(result, board[k][i][j]);
					}
				}
			}
		}
		
		if(result==1) {
			return 0;
		}else {
			return result-1;
		}
		
	}
	
	public static class Tomato{
		int z;
		int y;
		int x;
		
		public Tomato(int z, int y, int x) {
			this.z=z;
			this.y=y;
			this.x=x;
		}
	}

}
