package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1238 {
	
	public static int n;
	
	public static List<Edge>[] graph;
	public static List<Edge>[] reversedGraph;
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n+1];
		reversedGraph = new ArrayList[n+1];
		for(int i=0; i<graph.length; i++) {
			graph[i]= new ArrayList<>();
			reversedGraph[i]= new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Edge(b,t));
			
			reversedGraph[b].add(new Edge(a,t));
		}
		
		int[] backFromXArr = dik(x,graph);
		int[] goToXArr = dik(x,reversedGraph);
		
		int maxCost =0;
		
		for(int i=0; i<backFromXArr.length; i++) {
			int sum = backFromXArr[i]+goToXArr[i];
			maxCost = Math.max(maxCost, sum);
		}
		
		System.out.println(maxCost);

	}
	
	public static int[] dik (int start, List<Edge>[] gr) {
		
		int[] dist = new int[n+1];
		for(int i=1; i<dist.length; i++) {
			dist[i]= Integer.MAX_VALUE;
		}
		
		PriorityQueue<Edge> pq =new PriorityQueue<>();
		pq.add(new Edge(start,0));
		dist[start]=0;
		
		while(!pq.isEmpty()) {
			Edge nowEdge = pq.poll();
			
			if(nowEdge.cost>dist[nowEdge.v]) {
				continue;
			}
			
			for(Edge nextEdge : gr[nowEdge.v]) {
				if(dist[nextEdge.v]>nowEdge.cost+nextEdge.cost) {
					dist[nextEdge.v]=nowEdge.cost+nextEdge.cost;
					pq.add(new Edge(nextEdge.v,dist[nextEdge.v]));
				}
			}
		}
		
		return dist;
	}
	
	
	public static class Edge implements Comparable<Edge>{
		int v;
		int cost;
		
		public Edge(int v, int cost) {
			this.v=v;
			this.cost=cost;
		}
		
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

}
