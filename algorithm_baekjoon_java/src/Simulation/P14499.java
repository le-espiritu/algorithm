package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//  2
//4 1 3
//  5
//  6

// 위는 주사위 모양이고, 1이 주사위의 윗면, 3이 동쪽을 바라보는 면이다.
// 따라서 6이 주사위의 아랫면이 된다.
// 주사위의 데이터들은 배열에 저장하고, 위 숫자들을 배열의 인덱스로 활용한다.
// 배열로 우선순위큐(힙)을 구현한것을 떠올리며, 주사위를 배열로 구현하자.

public class P14499 {
	
	static int n;
	static int m;
	
	static int y;
	static int x;
	
	static int k; // 명령의 갯수
	
	static int[][] map;
	
	static int[] dice = new int[7];
	
	static int[] dy = {0,0,0,-1,1}; // 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
	static int[] dx = {0,1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		x=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		map=new int[n][m];
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			int d = Integer.parseInt(st.nextToken());
			
			int ny = y+dy[d];
			int nx = x+dx[d];
			
			if(ny>=0 && ny<n && nx>=0 && nx<m) {
				
				if(d==1) {
					int tmp = dice[1];
					dice[1]=dice[4];
					dice[4]=dice[6];
					dice[6]=dice[3];
					dice[3]=tmp;
				}
				else if(d==2) {
					int tmp = dice[1];
					dice[1]=dice[3];
					dice[3]=dice[6];
					dice[6]=dice[4];
					dice[4]=tmp;
				}
				else if(d==3) {
					int tmp = dice[1];
					dice[1]=dice[5];
					dice[5]=dice[6];
					dice[6]=dice[2];
					dice[2]=tmp;
				}
				else if(d==4) {
					int tmp = dice[1];
					dice[1]=dice[2];
					dice[2]=dice[6];
					dice[6]=dice[5];
					dice[5]=tmp;
				}
				
				if(map[ny][nx]==0) {
					map[ny][nx]=dice[6];
				}else {
					dice[6]=map[ny][nx];
					map[ny][nx]=0;
				}
				
				System.out.println(dice[1]);
				
				y=ny;
				x=nx;
			}
			
		}
	}

}
