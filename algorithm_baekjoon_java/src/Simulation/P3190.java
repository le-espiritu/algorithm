package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3190 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] board = new int[n+1][n+1];
		
		int k = Integer.parseInt(br.readLine());
		
		for(int i=0; i<k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			board[y][x]=1; // 1은 사과가 있음을 표시 
		}
		
		HashMap<Integer, String> hash = new HashMap<>();
		
		int l = Integer.parseInt(br.readLine());
		for(int i=0; i<l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			
			hash.put(x, c);
		}
		
		int[] dy = {0,1,0,-1};
		int[] dx = {1,0,-1,0};
		
		int d = 0;
		
		Queue<Body> qu = new LinkedList<>();
		
		int headX = 1;
		int headY = 1;
		
		qu.offer(new Body(headX, headY));
		board[headY][headX]=2;
		
		int second=1;
		while(true) {
			second++;
			
			int nY=headY+dy[d];
			int nX=headX+dx[d];
			
			if(nY>=1 && nY<n+1 && nX>=1 && nX<n+1) {
				
				if(board[nY][nX]==2) {
					break;
				}
				
				qu.offer(new Body(nX,nY));
				if(board[nY][nX]!=1) {
					Body tail = qu.poll();
					board[tail.y][tail.x]=0;
				}
				board[nY][nX]=2;
				headY=nY;
				headX=nX;
				
				String direction = hash.get(second);
				if(direction!=null) {
					if(direction.equals("L")) {
						d=(d+3)/4;
					}else if(direction.equals("D")) {
						d=(d+5)/4;
					}
				}
				
			}else {
				break;
			}
			
		}
		
		System.out.println(second);

	}
	
	public static class Body{
		int x;
		int y;
		
		public Body(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}

}
