package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3190_2 {
	
	public static int n;
	public static int[][] board;
	public static Queue<Body> snake;
	
	public static int[] dy = {0,1,0,-1};
	public static int[] dx = {1,0,-1,0};
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board=new int[n+1][n+1];
		
		int k = Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			board[y][x]=1; // 사과가 있음을 표시
		}
		
		int l = Integer.parseInt(br.readLine());
		HashMap<Integer, String> dirMap = new HashMap<>();
		for(int i=0; i<l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			
			dirMap.put(time, dir);
		}
		
		int d =0; // 처음에는 오른쪽으로 이동하는 뱀의 현재 방향 
		
		snake = new LinkedList<>();
		snake.add(new Body(1,1));
		board[1][1]=2;
		
		int cury =1;
		int curx =1;
		
		int second =0;
		
		while(true) {
			second++;
			
			//System.out.println("d="+d);
			
			int ny = cury+dy[d];
			int nx = curx+dx[d];
			
			//System.out.print(ny+" ");
			//System.out.println(nx);
			
			if(isFinished(ny,nx)) {
				break;
			}
			
			if(board[ny][nx]==1) {
				board[ny][nx]=2;
				snake.add(new Body(ny,nx));
			}else {
				snake.add(new Body(ny,nx));
				board[ny][nx]=2;
				Body tail = snake.poll();
				board[tail.y][tail.x]=0;
			}
			
			cury=ny;
			curx=nx;
			
			if(dirMap.containsKey(second)) {
				String direction = dirMap.get(second);
				
				if(direction.equals("L")) {
					d=(d+3)%4;
				}
				else if(direction.equals("D")) {
					d=(d+5)%4;
				}
			}
		}
		
		System.out.println(second);
		
	}
	
	public static boolean isFinished(int ny, int nx) {
		if(ny<1 || ny>n || nx<1 || nx>n) {
			return true;
		}
		
		if(board[ny][nx]==2) {
			return true;
		}
		
		return false;
	}
	
	public static class Body{
		int y;
		int x;
		
		public Body(int y, int x) {
			this.y=y;
			this.x=x;
		}
	}
	

}
