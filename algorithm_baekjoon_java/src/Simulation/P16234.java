package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16234 {
	
	static int n;
	static int l;
	static int r;
	
	static int[][] land;
	
	static boolean flag;
	
	static boolean[][] chk;
	
	static int[] dy= {0,1,0,-1};
	static int[] dx= {1,0,-1,0};
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		land = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				land[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		int day =0;
		
		while(true) {
			flag = false; // 인구이동을 했는지 확인하기 위함
			
			chk=new boolean[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(chk[i][j]==false) {
						bfs(i,j);
					}
				}
			}
			
			if(flag==false) {
				break;
			}else {
				day++;
			}
		}
		
		System.out.println(day);

	}
	
	static void bfs(int y, int x) {
		
		Queue<Country> qu = new LinkedList<>();
		qu.offer(new Country(y,x));
		chk[y][x]=true;
		
		int countryCnt = 0; // 국경이 오픈된 나라 수 
		int peopleSum = 0; // 국경이 오픈된 나라들의 인구수 총합
		
		while(!qu.isEmpty()) {
			Country c = qu.poll();
			countryCnt++;
			peopleSum+=land[c.y][c.x];
			
			for(int i=0; i<4; i++) {
				int ny = c.y+dy[i];
				int nx = c.x+dx[i];
				
				if(ny>=0 && ny<n && nx>=0 && nx<n) {
					
					int difference = Math.abs(land[c.y][c.x]-land[ny][nx]);
					
					if(chk[ny][nx]==false &&  difference>=l && difference<=r) {
						chk[ny][nx]=true;
						qu.offer(new Country(ny,nx));
						flag=true;
					}
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(chk[i][j]==true) {
					land[i][j]=peopleSum/countryCnt;
				}
			}
		}
				
		
	}
	
	static class Country{
		int y;
		int x;
		
		public Country(int y, int x) {
			this.y=y;
			this.x=x;
		}
	}

}
