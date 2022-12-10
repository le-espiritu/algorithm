package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 백준 알고리즘 1753번 최단경로 문제 - 다익스트라 알고리즘 활용하여 풀이 

/*
 1.아이디어 
 - 한점시작, 모든 거리 : 다익스트라
 - 간선, 인접리스트 저장
 - 거리배열 무한대 초기화
 - 시작점 : 거리배열 0, 힙에 넣어주기
 - 힙에서 빼면서 다음의 것들 수행
 	- 최신값인지 먼저 확인
 	- 간선을 타고 간 비용이 더 작으면 갱신
 	
2. 시간복잡도
- 다익스트라 : O(ElogV)
	- E : 3e5
	- V : 2e4, logV = 20
	- ElogV = 6e6 > 가
	
3. 자료구조
- 힙
- 최단거리(비용) 배열 : int[]
- 인접리스트 : ArrayList[] 
 */


public class ShortestPath {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		List<Node>[] graph = new ArrayList[V+1];
		for(int i=0; i<V+1; i++) {
			graph[i]=new ArrayList<>();
		}
		int[] dist = new int[V+1];
		for(int i =0; i<V+1; i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v,w));
		}
		
		PriorityQueue<Node> p = new PriorityQueue<>();
		// 시작점 초기화
		dist[start]=0;
		p.offer(new Node(start,0));
		
		while(!p.isEmpty()) {
			Node cNode = p.poll();
			
			if(cNode.cost>dist[cNode.idx]) {
				continue;
			}
			
			for(Node nNode : graph[cNode.idx]) {
				if(dist[nNode.idx]>cNode.cost+nNode.cost) {
					dist[nNode.idx]=cNode.cost+nNode.cost;
					p.offer(new Node(nNode.idx,dist[nNode.idx]));
				}
			}
			
		}
		
		for(int i=1; i<dist.length; i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(dist[i]);
			}
		}

	}
	
	static class Node implements Comparable<Node>{
		int idx;
		int cost;
		
		public Node(int idx, int cost) {
			this.idx=idx;
			this.cost=cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
		
	}

}
