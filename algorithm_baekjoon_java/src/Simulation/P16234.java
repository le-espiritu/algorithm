package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16234 {
	
	static int n;
	static int l;
	static int r;
	
	static int[][] land;
	static boolean[][] chk;
	
	static boolean isMoved;
	
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		l=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		
		land=new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				land[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int day=0;
		
		while(true) {
			chk = new boolean[n][n];
			isMoved=false; // 인구 이동을 했는지 확인하기 위한 bool체크, while문을 새로 돌때마다 false로 초기화 해줌 
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(chk[i][j]==false) {
						bfs(i,j);
					}
				}
			}
			
			if(isMoved==false) {
				break;
			}else {
				day++;
			}
		}
		
		System.out.println(day);
		
		
	}
	
	static void bfs(int y, int x) {
		
		List<Country> unitedList = new ArrayList<>(); // 연합된 국가들의 리스트를 저장할 자료구조 
		
		Queue<Country> qu = new LinkedList<>();
		qu.offer(new Country(y,x));
		chk[y][x]=true;
		
		unitedList.add(new Country(y,x));
		
		int unitedPeople =0; // 연합된 국가들의 인구수 총합 
		int unitedCnt =0; // 연합된 국가들의 수 
		
		while(!qu.isEmpty()) {
			Country c = qu.poll();
			
			unitedPeople+=land[c.y][c.x];
			unitedCnt++;
			
			for(int i=0; i<4; i++) {
				int ny = c.y+dy[i];
				int nx = c.x+dx[i];
				
				if(ny>=0 && ny<n && nx>=0 && nx<n) {
					if(chk[ny][nx]==false) {
						int diff = Math.abs(land[c.y][c.x]-land[ny][nx]);
						if(diff>=l && diff<=r) {
							chk[ny][nx]=true;
							qu.offer(new Country(ny,nx));
							unitedList.add(new Country(ny,nx));
						}
					}
				}
			}
		}
		
		if(unitedCnt>1) { // 연합된 국가들이 2개 이상이면 인구 분배를 해줌 
			for(Country c: unitedList) {
				land[c.y][c.x]=unitedPeople/unitedCnt;
			}
			isMoved=true;
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