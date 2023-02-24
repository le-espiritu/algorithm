package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P6497 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			
			String line = br.readLine();
			if(line.equals("0 0")) {
				break;
			}
			
			StringTokenizer st = new StringTokenizer(line);
			
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			List<Edge>[] graph = new ArrayList[m];
			for(int i=0; i<graph.length; i++) {
				graph[i]=new ArrayList<>();
			}
			
			int sum=0;
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				
				graph[x].add(new Edge(y,z));
				graph[y].add(new Edge(x,z));
				
				sum+=z;
			}
			
			
			//mst
			boolean[] chk = new boolean[m];
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.offer(new Edge(0,0));
			int minSum=0;
			
			while(!pq.isEmpty()) {
				Edge e = pq.poll();
				if(chk[e.v]==false) {
					minSum += e.cost;
					chk[e.v]=true;
					
					for(Edge next : graph[e.v]) {
						if(chk[next.v]==false) {
							pq.offer(next);
						}
					}
				}
			}
			
			int answer = sum-minSum;
			sb.append(answer+"\n");
			
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
