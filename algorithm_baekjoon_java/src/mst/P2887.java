package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2887 {
	
	public static class Planet{ // vertex
		int index;
		int x;
		int y;
		int z;
		
		public Planet(int index, int x, int y, int z) {
			this.index = index;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	public static class Edge implements Comparable<Edge>{
		int start; // 시작 버텍스 
		int to; // 시작 버텍스로부터 이어지는 다음 버텍스
		int distant; // 거리 , 비용 
		
		public Edge(int start, int to, int distant) {
			this.start = start;
			this.to = to;
			this.distant = distant;
		}

		@Override
		public int compareTo(Edge o) {
			return this.distant-o.distant;
			//return Integer.compare(this.distant, o.distant); // 이 코드로도 가능할 듯 
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Planet[] planets;
		List<Edge>[] adjList;
		
		//행성을 n개 만큼 담을 배열 생성 
		planets = new Planet[n];
		
		// n개 행성의 좌표를 차례로 입력받음 
		// 각 행성에 인덱스를 부여하여 각 행성을 구별함 
		StringTokenizer st;
		for(int i=0; i<n; i++) { 
			st = new StringTokenizer(br.readLine());
			int x =Integer.parseInt(st.nextToken());
			int y =Integer.parseInt(st.nextToken());
			int z =Integer.parseInt(st.nextToken());
			
			planets[i] = new Planet(i,x,y,z);
		}
		
		//인접리스트 생성 
		adjList = new ArrayList[n];
		for(int i=0; i<n; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		// 
		//
		PriorityQueue<Planet> p = new PriorityQueue<>();
		
		

	}

}
