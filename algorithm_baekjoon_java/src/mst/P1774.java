package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1774 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Point[] gods = new Point[n+1];
		
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken()); // 직선거리를 구할때 제곱을 하기 때문에 long으로 받아줌 
			long y = Long.parseLong(st.nextToken());
			
			gods[i]=new Point(x,y);
		}
		
		List<Edge>[] graph = new ArrayList[n+1];
		for(int i=1; i<graph.length; i++) {
			graph[i]= new ArrayList<>();
		}
		
		for(int i=1; i<n+1; i++) {
			
			Point god1 = gods[i];
			
			for(int j=1; j<n+1; j++) {
				if(i==j) {
					continue;
				}
				Point god2 = gods[j];
				
				//두 점 사이의 직선거리 구하기 
				// 제곱을 하면서 int의 범위를 넘어 설 수 있기 때문에 long으로 선언해준다.
				long xDist = (long) Math.pow((god1.x-god2.x),2); // Math.pow() 제곱을 해주는 메서드 
				long yDist = (long) Math.pow((god1.y-god2.y),2);
				
				double dist = Math.sqrt(xDist+yDist); // Math.sqrt() -> 제곱근 구하기
				
				graph[i].add(new Edge(j,dist));
				
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int godIdx1 = Integer.parseInt(st.nextToken());
			int godIdx2 = Integer.parseInt(st.nextToken());
			
			graph[godIdx1].add(new Edge(godIdx2,0));
			graph[godIdx2].add(new Edge(godIdx1,0));
		}
		
		//mst
		boolean[] chk = new boolean[n+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1,0));
		
		double minLength = 0;
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(chk[e.v]==false) {
				chk[e.v]=true;
				minLength+=e.cost;
				
				for(Edge next : graph[e.v]) {
					if(chk[next.v]==false) {
						pq.offer(next);
					}
				}
			}
		}
		
		System.out.printf("%.2f",minLength);
		

	}
	
	static class Point{
		long x;
		long y;
		
		public Point(long x, long y) {
			this.x=x;
			this.y=y;
		}
	}
	
	
	static class Edge implements Comparable<Edge>{
		int v;
		double cost;
		
		public Edge(int v, double cost) {
			this.v=v;
			this.cost=cost;
		}
		
		public int compareTo(Edge o) {
			return Double.compare(this.cost, o.cost);
		}
	}

}
