package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1446 {
	
	public static class Edge implements Comparable<Edge>{
		
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
	
	public static class ShortEdge{
		int from;
		int to;
		int cost;
		
		public ShortEdge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		List<ShortEdge> shortEdges = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			
			// 문제에서 고속도로에서는 다시 되돌아갈 수 없기때문에 to가 최종 목적이니 d보다 크다면 지름길이 될 수가 없다.
			if (to>d) {
				continue;
			}
			// 지름길 비용이라고 주어진 값이 사실 원래 거리보다 같거나 길다면 지름길이라고 할 수 없다.
			if(c >= (to-start)) {
				continue;
			}
			
			//지름길들을 저장  
			shortEdges.add(new ShortEdge(start,to,c));
		}
		
		
		PriorityQueue<Edge> p = new PriorityQueue<>();
		Edge[] edges = new Edge[d+1];
		for(int i=0; i<edges.length; i++) {
			edges[i]=new Edge(i,Integer.MAX_VALUE);
		}
		edges[0].cost=0;
		p.add(edges[0]);
		
		while(!p.isEmpty()) { // while(true)로 해줘도 됨 
			Edge front = p.poll();
			
			
			// 아래 edges[front.v+1] 코드 때문에 break문 해줘야 함 
			// 그렇지 않으면 out of index 발생 
			if(front.v ==d) {
				break;
			}
			
			Edge next = edges[front.v+1];
			if(next.cost >front.cost+1) {
				next.cost = front.cost+1;
				p.offer(next);
			}
			
			for (ShortEdge sEdge : shortEdges) {
				if(sEdge.from == front.v) {
					Edge shortNext = edges[sEdge.to];
					if(shortNext.cost>front.cost+sEdge.cost) {
						shortNext.cost = front.cost+sEdge.cost;
						p.offer(shortNext);
					}
				}
			}
		}
		
		System.out.println(edges[d].cost);

	}

}
