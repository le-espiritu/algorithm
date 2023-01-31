package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P4386 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Planet[] planets = new Planet[n];
		
		for(int i=0; i<planets.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			
			planets[i]= new Planet(i,x,y);
		}
		
		List<Edge>[] graph = new ArrayList[n];
		for(int i=0; i<graph.length; i++) {
			graph[i]=new ArrayList<>();
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				Planet planet1 = planets[i];
				Planet planet2 = planets[j];
				
				if(planet1.idx == planet2.idx) {
					continue;
				}
				
				double cost = Math.sqrt(Math.pow(planet2.x-planet1.x,2)+ Math.pow(planet2.y-planet1.y,2));
				
				graph[planet1.idx].add(new Edge(planet2.idx,cost));
				
			}
		}
		
		boolean[] chk = new boolean[n];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0,0));
		
		double cost =0;
		
		while(!pq.isEmpty()) {
			Edge nowEdge = pq.poll();
			
			if(chk[nowEdge.v]==false) {
				chk[nowEdge.v]=true;
				cost+=nowEdge.cost;
				
				for(Edge next : graph[nowEdge.v]) {
					if(chk[next.v]==false) {
						pq.offer(next);
					}
				}
			}
		}
		
		System.out.println(cost);

	}
	
	public static class Planet{
		int idx;
		double x;
		double y;
		
		public Planet(int idx, double x, double y) {
			this.idx=idx;
			this.x=x;
			this.y=y;
		}
	}
	
	public static class Edge implements Comparable<Edge>{
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
