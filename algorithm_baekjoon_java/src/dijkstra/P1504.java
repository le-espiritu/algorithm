package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 백준 1504번 문제 풀이 - 다익스트라 알고리즘 


// public class 와  그냥 class의 차이 이해하기 
// class 앞에 public이 붙은경우 자바 파일명과 public이 붙은 class 명이 동일해야 한다.
class Node implements Comparable<Node>{ 
	int v;
	int c;
	
	public Node(int v, int c) {
		this.v = v;
		this.c = c;
	}
	
	public int compareTo(Node o) {
		return Integer.compare(this.c, o.c);
	}
}

public class P1504 {
	
	public static int[] dist;
	public static List<Node>[] graph;
	public static final int INF = 200000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		
		dist = new int[n+1];
		Arrays.fill(dist, INF);
		
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
		
		//반드시 거쳐야하는 정점들 입력받음
		st= new StringTokenizer(br.readLine());
		int u = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		int result1 =0;
		result1 += dijk(1,u);
		result1 += dijk(u,v);
		result1 += dijk(v,n);
		
		int result2 =0;
		result2 += dijk(1,v);
		result2 += dijk(v,u);
		result2 += dijk(u,n);
		
		int answer = Math.min(result1, result2);
		
		if(answer >= INF) { // 크거나 같아야함. 왜냐하면 INF 자체도  인피니티 값이니까. 
			System.out.println(-1);
		}else {
			System.out.println(answer);
		}
		
	}
	
	
	public static int dijk(int start, int to) {
		Arrays.fill(dist, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		dist[start]=0;
		
		
		while(!pq.isEmpty()) {
			Node nowNode = pq.poll();
			
			if(nowNode.c>dist[nowNode.v]) {
				continue;
			}
			
			
			for(Node nextNode : graph[nowNode.v]) {
		
				if(dist[nextNode.v]>nowNode.c+nextNode.c) {
					
					dist[nextNode.v]=nowNode.c+nextNode.c;
					pq.add(new Node(nextNode.v,dist[nextNode.v]));
					
				}
			}
		}
		
		
		return dist[to];
	}
	


}
