package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 백준 1504번 문제 풀이 - 다익스트라 알고리즘 

public class P1504 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int[] dist;
		List<Node>[] graph;
		
		dist = new int[n+1];
		for(int i=0; i<dist.length; i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		
		graph=new ArrayList[n+1];
		for(int i=0; i<graph.length; i++) {
			graph[i]= new ArrayList<>();
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[start].add(new Node(to,cost));
			graph[to].add(new Node(start,cost));
		}
		
		st= new StringTokenizer(br.readLine());
		int u = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1,0));
		dist[1]=0;
		
		boolean uChck = false;
		boolean vChck = false;
		
		while(!pq.isEmpty()) {
			Node nowNode = pq.poll();
			
			if(nowNode.c>dist[nowNode.v]) {
				continue;
			}
			
			if(nowNode.v==u) {
				uChck=true;
			}
			if(nowNode.v==v) {
				vChck=true;
			}
			
			for(Node nextNode : graph[nowNode.v]) {
				
				if(nextNode.v==n && uChck==false || vChck==false) {
					continue;
					
				}
				if(dist[nextNode.v]>nowNode.c+nextNode.c) {
					
					dist[nextNode.v]=nowNode.c+nextNode.c;
					pq.add(new Node(nextNode.v,dist[nextNode.v]));
					
				}
			}
		}
		
		if(dist[n]==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(dist[n]);
		}
		

	}
	
	public static class Node implements Comparable<Node>{
		int v;
		int c;
		
		public Node(int v, int c) {
			this.v = v;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.c, o.c);
		}
	}

}
