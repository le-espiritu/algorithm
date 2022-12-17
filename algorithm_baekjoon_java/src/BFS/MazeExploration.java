package BFS;

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
		}
			

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
