package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1446_2 {
	
	public static class Path implements Comparable<Path>{
		int start;
		int to;
		int cost;
		
		public Path(int start, int to, int cost) {
			this.start = start;
			this.to = to;
			this.cost=cost;
		}

		@Override
		public int compareTo(Path o) {
			return this.cost-o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[d+1];
		for(int i=0; i<dist.length; i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		
		List<Path>[] paths =new ArrayList[d];
		for(int i=0; i<paths.length; i++) {
			paths[i]=new ArrayList<>();
			paths[i].add(new Path(i,i+1,1));
		}
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(t>d) {
				continue;
			}
			if(c>=t-s) {
				continue;
			}
			
			paths[s].add(new Path(s,t,c));
		}
		
		PriorityQueue<Path> p = new PriorityQueue<>();
		p.offer(new Path(0,0,0));
		dist[0]=0;
		
		while(!p.isEmpty()) {
			Path nowPath =p.poll();
			
			if(nowPath.cost>dist[nowPath.to]) {
				continue;
			}
			
			if(nowPath.to==d) {
				break;
			}
			
			for(Path nextPath : paths[nowPath.to]) {
				if(dist[nextPath.to]>nowPath.cost+nextPath.cost) {
					dist[nextPath.to]=nowPath.cost+nextPath.cost;
					p.offer(new Path(nextPath.start,nextPath.to,dist[nextPath.to]));
				}
			}
		}
		
		System.out.println(dist[d]);
		

	}

}
