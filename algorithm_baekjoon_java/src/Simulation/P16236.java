package Simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P16236 {
	
	public static int n;
	public static int[][] map;
	
	public static int sharkY;
	public static int sharkX;
	
	public static int[][] dist;
	public static LinkedList<Point> eatableFishes;
	
	public static int size;
	public static int time;
	public static int eatingCount;
	
	public static int[] dy = {0,1,0,-1};
	public static int[] dx = {1,0,-1,0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		map= new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j]=sc.nextInt();
				
				if(map[i][j]==9) {
					sharkY=i;
					sharkX=j;
					
					map[i][j]=0;
				}
			}
		}
		
		size=2;
		time=0;
		eatingCount=0;
		
		while(true) {
			eatableFishes=new LinkedList<>();
			
			bfs(sharkY,sharkX);
			
			if(eatableFishes.size()==0) {
				break;
			}
			
			// bfs특성상 LinkeList에 가장 먼저 보관한 물고기는 가장 가까운 거리에 있는 물고기이다.
			Point closestFish = eatableFishes.get(0);
			
			for(int i=1; i<eatableFishes.size(); i++) {
				Point nextFish = eatableFishes.get(i);
				if(closestFish.distance == nextFish.distance) { //만약 가까이 있는 물고기 들의 거리가 모두 같다면 
					if(nextFish.y<closestFish.y) { // 가장 위에 있는 물고기부터 먹는다. 
						closestFish=nextFish;
					}
					else if(nextFish.y==closestFish.y) { // 가장 위에 있는 물고기들이 여러마리라면 (y축의 거리가 같다면) 
						if(nextFish.x<closestFish.x) { // 가장 왼쪽에 있는 물고기부터 먹는다. (y축이 같은 물고기 안에서 x축이 가장 작은 물고기부터 먹음) 
							closestFish=nextFish;
						}
					}
				}
			}
			
			time+=closestFish.distance;
			eatingCount++;
			if(eatingCount==size) {
				size++;
				eatingCount=0;
			}
			
			map[closestFish.y][closestFish.x]=0; // 물고기 먹은 자리는 0으로 변환 
			
			sharkY=closestFish.y;
			sharkX=closestFish.x;
			
		}
		
		System.out.println(time);

	}
	
	public static void bfs(int y, int x) {
		dist = new int[n][n];
		Queue<Point> qu = new LinkedList<>();
		qu.offer(new Point(y,x,0));
		
		while(!qu.isEmpty()) {
			Point p = qu.poll();
			
			for(int i=0; i<4; i++) {
				int ny = p.y+dy[i];
				int nx = p.x+dx[i];
				
				if(ny>=0 && ny<n && nx>=0 && nx<n) {
					if(dist[ny][nx]==0 && map[ny][nx]<=size) {
						dist[ny][nx]=p.distance+1;
						
						//먹을 수 있는 물고기들을 리스트에 보관 =>bfs특성상 가장 가까운 거리에 있는 물고기부터 리스트에 보관한다.
						if(map[ny][nx]>0 && map[ny][nx]<size) {
							eatableFishes.add(new Point(ny,nx,dist[ny][nx]));
						}
						
						qu.offer(new Point(ny,nx,dist[ny][nx]));
					}
				}
			}
		}
	}
	
	public static class Point{
		int y;
		int x;
		int distance;
		
		public Point(int y, int x, int distance) {
			this.y=y;
			this.x=x;
			this.distance = distance;
		}
		
	}

}
