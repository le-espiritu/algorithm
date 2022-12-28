package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 백준 알고리즘 1916번 문제 최소비용 구하기 - 다익스트라 알고리즘 

public class P1916 {
	
	public static class City implements Comparable<City> {
		int v;
		int c;
		
		public City(int v, int c) {
			this.v = v;
			this.c = c;
		}

		@Override
		public int compareTo(City o) {
			return Integer.compare(this.c, o.c);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[] dist;
		List<City>[] graph;
		
		dist = new int[n+1];
		for(int i=0; i<dist.length; i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		
		graph=new ArrayList[n+1];
		for(int i=0; i<graph.length; i++) {
			graph[i]=new ArrayList<>();
		}
		
		//m개 버스의 출발도시, 도착도시, 비용 정보 입력 받기
		StringTokenizer st;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[start].add(new City(to,cost));
		}
		
		// 우리가 알고 싶은 출발도시와 도착도시의 비용 정보을 알기 위해 도시 입력받기 
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		// 다익스트라 알고리즘 시작 
		PriorityQueue<City> pq = new PriorityQueue<>();
		
		City startCity = new City(a,0);
		dist[a]=0;
		
		pq.add(startCity);
		
		while(!pq.isEmpty()) {
			City nowCity = pq.poll();
			
			if(nowCity.c>dist[nowCity.v]) {
				continue;
			}
			
			for(City nextCity : graph[nowCity.v]) {
				if(dist[nextCity.v]>nowCity.c+nextCity.c) {
					dist[nextCity.v]=nowCity.c+nextCity.c;
					pq.add(new City(nextCity.v,dist[nextCity.v]));
				}
			}
		}
		
		//도착도시까지의 비용을 출력 ( 다익스트라 알고리즘을 사용했으니 비용은 최소 비용이 됨) 
		System.out.println(dist[b]);
		
		

	}

}
