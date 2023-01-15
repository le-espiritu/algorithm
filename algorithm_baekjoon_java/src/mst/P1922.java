package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1922 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		List<Edge>[] graph = new ArrayList[n+1];
		for(int i=0; i<graph.length; i++) {
			graph[i]= new ArrayList<>();
		}
		
		StringTokenizer st;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Edge(b,c));
			graph[b].add(new Edge(a,c));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] chk =new boolean[n+1];
		pq.add(new Edge(1,0));
		
		int minCost = 0;
		
		while(!pq.isEmpty()) {
			Edge nowEdge = pq.poll();
			
			if(chk[nowEdge.v]==false) {
				chk[nowEdge.v]=true;
				minCost +=nowEdge.cost;
				
				for(Edge nextEdge : graph[nowEdge.v]) {
					if(chk[nextEdge.v]==false) {
						pq.add(nextEdge);
					}
				}
			}
		}
		
		System.out.println(minCost);
	}
	
	public static class Edge implements Comparable<Edge>{
		int v;
		int cost;
		
		public Edge(int v, int cost) {
			this.v =v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
		

	}

}
