package BFS;

// 백준 2178번 미로탐색 문제 -bfs 활용  

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeExploration {
	
	public static int n;
	public static int m;
	public static int[][] map;
	public static boolean[][] chk;
	public static int[] dy = {0,1,0,-1}; // 동남서북순  
	public static int[] dx = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		map=new int[n+1][m+1];
		chk=new boolean[n+1][m+1];
		
		//미로 그리기  
		for(int i=1; i<n+1; i++) {
			String line = br.readLine();
			for(int j=1; j<m+1; j++) {
				map[i][j]= Character.getNumericValue(line.charAt(j-1));
			}
		}
		
		
		
		Room room = new Room(1,1);
		chk[1][1]=true;
		
		Queue<Room> q = new LinkedList<>();
		q.offer(room);
		while(!q.isEmpty()) {
			Room curRoom = q.poll();
			int x = curRoom.x;
			int y = curRoom.y;
			
			int levelCount =0;
			for(int k =0; k<4; k++) {
				int nx=x+dx[k];
				int ny=y+dy[k];
				if(1<=nx && nx<n+1 && 1<=ny && ny<m+1) {
					if(map[nx][ny]==1 && chk[nx][ny] ==false) {
						chk[nx][ny]=true;
						map[nx][ny] = map[x][y]+1; // 이렇게 하면 같은 레벨의 노드(room)들은 모두 같은 가중치를 갖는다.
						Room nRoom = new Room(nx,ny);
						q.offer(nRoom);
					}
				}
				
			}
		}
		
		System.out.println(map[n][m]);
			

	}
	
	public static class Room{
		int x;
		int y;
		
		public Room(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}

}
