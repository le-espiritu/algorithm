package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1854 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		List<Edge> graph[] = new ArrayList[n+1];
		for(int i=0; i<graph.length; i++) {
			graph[i]= new ArrayList<>();
		}
		
		//int[] dist = new int[n+1];
		//Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<Integer>[] dist = new PriorityQueue[n+1];
		for(int i=1; i<dist.length; i++) {
			dist[i]= new PriorityQueue<>(Collections.reverseOrder()); // 우선순위큐 내림차순 정렬 
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Edge(b,c));
		}
		
		
		//다익스트라
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1,0));
		dist[1].add(0);
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			
			for(Edge next : graph[e.v]) {
				if(dist[next.v].size()<k) {
					dist[next.v].add(e.cost+next.cost);
					pq.add(new Edge(next.v,e.cost+next.cost));
				}else { // dist[next.v].size()>=k 인 경우 
					// 아래 if문을 만족하지 않으면 pq에 Edge를 추가하지 못한다.
					// 즉 비용의 합이 우리가 알고싶은 k번째로 최단경로인 범위를 넘어서기 때문에 
					// 이 비용에 대한 어떤 처리를 해줄 필요가 없는 것이다.
					// 때문에 시간복잡도 측면에서 이 코드는 시간초과가 나지 않는다. 
					if((dist[next.v].peek())>e.cost+next.cost) {
						dist[next.v].poll();
						dist[next.v].add(e.cost+next.cost);
						pq.add(new Edge(next.v,e.cost+next.cost));
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<dist.length; i++) {
			if(dist[i].size()<k) {
				sb.append(-1+"\n");
				
			}
			else {
				sb.append(dist[i].poll()+"\n");
			}
		}
		
		System.out.println(sb);

	}
	
	static class Edge implements Comparable<Edge>{
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
