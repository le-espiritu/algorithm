package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3190 {
	
	public static int n;
	public static int[][] board;
	public static List<Body> snake;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		board = new int[n+1][n+1];
		
		int k = Integer.parseInt(br.readLine());
		
		for(int i=0; i<k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			board[x][y]=1; // 1은 사과가 있음을 표시 
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
		
		snake = new LinkedList<>();
		
		int headX = 1;
		int headY = 1;
		
		snake.add(new Body(headX, headY));
		
		int second=0;
		while(true) {
			second++;
			
			int nX=headX+dx[d];
			int nY=headY+dy[d];
			
			
			if(isFinished(nX,nY)==true) {
				break;
			}

			if(board[nX][nY]==1) {
				board[nX][nY]=0;
				snake.add(new Body(nX,nY));
				
			}else {
				snake.add(new Body(nX,nY));
				snake.remove(0);
			}
			
			headX=nX;
			headY=nY;
			
			
			String direction = hash.get(second);
			if(direction!=null) {
				if(direction.equals("L")) {
					d=(d+3)%4;
				}else if(direction.equals("D")) {
					d=(d+5)%4;
				}
			}
			
			
		}
		
		System.out.println(second);

	}
	
	public static boolean isFinished(int nx, int ny) {
		if(ny<1 || ny>n || nx<1 || nx>n) {
			return true;
		}
		
		for(int i=0; i<snake.size(); i++) {
			Body body = snake.get(i);
			if(nx==body.x && ny==body.y) {
				return true;
			}
		}
		
		return false;
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
