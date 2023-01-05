package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 백준 1647번 도시 분할 계획 문제 풀이 - mst 알고리즘 활

class Edge implements Comparable<Edge>{
	
	int v;
	int cost;
	
	public Edge(int v, int cost) {
		this.v=v;
		this.cost=cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost-o.cost;
	}
	
}

public class P1647 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Edge>[] graph = new ArrayList[n+1];
		for(int i=0; i<graph.length; i++) {
			graph[i]= new ArrayList<>();
		}
		
		for(int i =0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Edge(b,c));
			graph[b].add(new Edge(a,c));
		}
		
		PriorityQueue<Edge> p = new PriorityQueue<Edge>();
		boolean[] chk = new boolean[n+1];
		
		p.add(new Edge(1,0));
		
		int totalCost=0;
		int maxCost=0;
		
		while(!p.isEmpty()) {
			Edge nowEdge = p.poll();
			
			if(chk[nowEdge.v]==false) {
				chk[nowEdge.v]=true;
				totalCost +=nowEdge.cost;
				maxCost = Math.max(nowEdge.cost, maxCost);
				
				for(Edge nextEdge : graph[nowEdge.v]) {
					if(chk[nextEdge.v]==false) {
						p.add(nextEdge);
					}
				}
			}
		}
		
		System.out.println(totalCost-maxCost);


	}

}
