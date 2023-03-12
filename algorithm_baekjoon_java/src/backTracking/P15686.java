package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백트래킹만 활용하여 풀이함 
public class P15686 {
	
	static int n;
	static int m;
	
	static ArrayList<Point> chickenHouses;
	static ArrayList<Point> houses;
	
	static int[] chickenDists;
	static int minSum = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		chickenHouses = new ArrayList<>();
		houses = new ArrayList<>();
		
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<n+1; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num==1) {
					houses.add(new Point(i,j));
				}
				else if(num==2) {
					chickenHouses.add(new Point(i,j));
				}
			}
		}
		
		chickenDists=new int[houses.size()];
		Arrays.fill(chickenDists, Integer.MAX_VALUE);
		
		bt(0,0);
		
		System.out.println(minSum);

	}
	
	static void bt(int idx, int depth) {
		if(depth==m) {
			int sum =0;
			for(int i=0; i<chickenDists.length; i++) {
				sum+=chickenDists[i];
			}
			minSum = Math.min(minSum, sum);
			
			return;
		}
		
		for(int i=idx; i<chickenHouses.size(); i++) {
			
			Point chP = chickenHouses.get(i);
			
			//배열 복사 
			//재귀 호출후 데이터들을 다시 원복할때 사용하기 위함 
			int[] tmp = new int[chickenDists.length];
			for(int t = 0; t<tmp.length; t++) {
				tmp[t]=chickenDists[t];
			}
			
			//각 집과 치킨집 사이의 치킨거리를 구하고 
			//이전 치킨거리와 비교하여 최소값으로 갱신 (각 집마다 해줘야함) 
			for(int j=0; j<houses.size(); j++) {
				Point hP = houses.get(j);
				
				int dist = Math.abs(hP.x-chP.x)+Math.abs(hP.y-chP.y);
				chickenDists[j]=Math.min(chickenDists[j], dist);
			}
			
			bt(i+1,depth+1);
			chickenDists=tmp; // 재귀 호출 후 데이터 원복 
		}
	}
	
	static class Point{
		int x;
		int y;
		
		public Point(int y, int x) {
			this.y=y;
			this.x=x;
		}
	}

}
