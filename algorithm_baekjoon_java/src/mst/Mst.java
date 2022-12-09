package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 백준 1197 최소 스패닝 트리 - mst prim 알고리즘 활용하여 풀이  

/*
1.아이디어 
- mst 기본문제, 외우기
- 힙에 시작점 넣기
- 힙이 비워질때까지 다음의 작업을 반복
	- 힙의 최소값 꺼내서, 해당 노드 방문 안했다면
	- 방문표시, 해당 비용 추가, 연결된 간선들 힙에 넣어주기  

2. 시간복잡도
- mst : O(ElogE)

3. 자료구조 
- 간선 저장 되는 인접리스트 
- 힙
- 방문 여부 : boolean[]
- mst 결과값 : int 
*/

public class Mst {
	public static class Edge implements Comparable<Edge>{
		
		int v;
		int ecost;
		
		public Edge(int v, int ecost) {
			this.v=v;
			this.ecost=ecost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.ecost-o.ecost;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		// 인접리스트 생성 
		// 2차원 배열을 생성해도 될듯.
		List<Edge>[] edges = new ArrayList[v+1];
		for(int i=0; i<edges.length; i++) {
			edges[i]=new ArrayList<>();
		}
		
		boolean[] chk = new boolean[v+1];
		int rs =0;
		
		for(int i=0; i<e; i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges[a].add(new Edge(b,c));
			edges[b].add(new Edge(a,c));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(1,0));
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(chk[edge.v]==false) {
				chk[edge.v]=true;
				rs += edge.ecost;
				
				for(Edge nextEdge : edges[edge.v]) {
					if(chk[nextEdge.v]==false) {
						pq.add(nextEdge);
					}
				}
				
			}
		}
		
		System.out.println(rs);
		

	}

}
