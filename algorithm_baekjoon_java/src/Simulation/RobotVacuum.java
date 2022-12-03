package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 알고리즘14503번 로봇 청소기 문제 풀이 - 시뮬레이션 알고리즘 

/*
1. 아이디어
- while문으로, 특정조건 종료될때까지 반복
- 4방향을 for문으로 탐색
- 더이상 탐색 불가능할 경우, 뒤로 한칸 후진
- 후진이 불가능하면 종료

2. 시간복잡도
-O(NM) : 50^2 = 2500 < 2억
-가능

3. 자료구조
- 지도을 위해 2차원배열 사용 :int[][]
*/

public class RobotVacuum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		
		int y = Integer.parseInt(st.nextToken()); //r
		int x = Integer.parseInt(st.nextToken()); //c
		int d = Integer.parseInt(st.nextToken());
		//d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽을 바라보고 있다 
		// 즉, 0,1,2,3 은 아래 방향 좌표 배열(좌표 벡터)에서 인덱스를 의미한다. 
		// 아래에서 북쪽이 -1,0인 이유는 '현재 위치보다 한칸 위' 의 배열 값을 탐색해야 하기 때문에 행의 값이 -1이된다.
		// 마찬가지로 남쪽이 1,0인 이유는 '현지 위치보다 한칸 아래'의 배열 값을 탐색해야 하기 때문에 행의 값이 +1이 된 것이다.
		int[] yd = {-1,0,1,0};
		int[] xd = {0,1,0,-1};
		
		int count=0;
	
		
		for(int i =0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		while(true) {
			if(map[y][x]==0) {
				map[y][x]=2; // 현재위치 청소
				count++;
			}
			
			boolean flag = false;
			for(int i=0; i<4; i++) { // 청소하지 않은 공간을 찾을때까지 왼쪽으로 회전 
				d=(d+3)%4; // 왼쪽 방향으로 한칸 회전한 값은 d-1 이다. 그러나 d-1을 하면 인덱스값이 음수가 나올 수도 있다.
				// 자바에서는 인덱스 값이 음수가 나올 수 없다.
				// 따라서 배열의 전체 길이(4) 보다 하나 적은 3을 더해주고 배열의 전체길이로 나눈 나머지를 구하여 
				// 현재 d값 보다 한칸 적은 값을 음수 없이 구한다.
				int ny = y+yd[d];
				int nx = x+xd[d];
				if(ny>=0 && ny<n && nx>=0 && nx<m) {
					if(map[ny][nx]==0) {
						y=ny;
						x=nx;
						flag=true;
						break;
					}
				}
				
			}
			
			
			// 4방향 모두 있지 않은 경우 
			if(!flag) {
				// 뒤쪽 방향이 막혀있는지 확인
				int by = y - yd[d];
				int bx = x - xd[d];
				if(by>=0 && by<n && bx>=0 && bx<m) {
					if(map[by][bx]==1) {
						break; // while문 종료  
					}else { // 뒤쪽 벽이 막혀있지 않은 경우  
						y=by;
						x=bx;
					}
				}else {
					break; // 로봇이 더이상 갈곳이 없어서 break;
				}
				
			}
			
		}
		
		System.out.println(count);

	}

}
