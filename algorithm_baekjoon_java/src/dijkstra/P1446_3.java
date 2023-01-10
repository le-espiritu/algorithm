package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1446_3 {
	
	public static class Path implements Comparable<Path>{
		int v;
		int cost;
		
		public Path(int v, int cost) {
			this.v=v;
			this.cost=cost;
		}

		@Override
		public int compareTo(Path o) {
			return this.cost-o.cost;
		}
	}
	
	public static class ShortPath{
		int start;
		int to;
		int cost;
		
		public ShortPath(int start, int to, int cost) {
			this.start=start;
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		Path[] paths = new Path[d+1];
		for(int i=0; i<paths.length; i++) {
			paths[i]=new Path(i,Integer.MAX_VALUE);
		}
		
		List<ShortPath> shortPathList = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(t>d) {
				continue;
			}
			if(c>=(t-s)) {
				continue;
			}
			
			shortPathList.add(new ShortPath(s,t,c));
		}
		
		PriorityQueue<Path> p = new PriorityQueue<>();
		paths[0].cost=0;
		p.offer(paths[0]);
		
		while(!p.isEmpty()) {
			Path nowPath = p.poll();
			
			if(nowPath.v==d) {
				break;
			}
			
			Path nextPath = paths[nowPath.v+1];
			if(nextPath.cost>nowPath.cost+1) {
				nextPath.cost=nowPath.cost+1;
				p.offer(nextPath);
			}
			
			for(ShortPath shortPath : shortPathList) {
				if(shortPath.start==nowPath.v) {
					Path nextJumpSpot = paths[shortPath.to];
					if(nextJumpSpot.cost>nowPath.cost+shortPath.cost) {
						nextJumpSpot.cost=nowPath.cost+shortPath.cost;
						p.offer(nextJumpSpot);
					}
				}
			}
			
		}
		
		System.out.println(paths[d].cost);
		
	}

}
