package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P10282 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			List<Edge>[] graph = new ArrayList[n+1];
			int[] dist = new int[n+1];
			for(int j=1; j<n+1; j++) {
				graph[j]=new ArrayList<>();
				dist[j]= Integer.MAX_VALUE;
			}
			
			for(int j=0; j<d; j++) {
				st = new StringTokenizer(br.readLine());
				int a =Integer.parseInt(st.nextToken());
				int b =Integer.parseInt(st.nextToken());
				int s =Integer.parseInt(st.nextToken());
				
				graph[b].add(new Edge(a,s));
			}
			
			//다익스트라
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.offer(new Edge(c,0));
			dist[c]=0;
			
			while(!pq.isEmpty()) {
				Edge e = pq.poll();
				
				if(e.cost>dist[e.v]) {
					continue;
				}
				
				for(Edge next : graph[e.v]) {
					if(dist[next.v]>e.cost+next.cost) {
						dist[next.v]=e.cost+next.cost;
						pq.offer(new Edge(next.v,dist[next.v]));
					}
				}
			}
			
			int count =0;
			int time =0;
			
			for(int j=1; j<dist.length; j++) {
				if(dist[j]!=Integer.MAX_VALUE) {
					count++;
					time = Math.max(time, dist[j]);
				}
			}
			
			sb.append(count+" "+time+"\n");
		}
		
		System.out.println(sb);
		
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
