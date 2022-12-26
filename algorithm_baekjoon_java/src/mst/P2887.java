package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2887 {
	
	public static class Planet{ // vertex
		int index;
		int x;
		int y;
		int z;
		
		public Planet(int index, int x, int y, int z) {
			this.index = index;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	public static class Edge implements Comparable<Edge>{
		int start; // 시작 버텍스 
		int to; // 시작 버텍스로부터 이어지는 다음 버텍스
		int distance; // 거리 , 비용 
		
		public Edge(int start, int to, int distance) {
			this.start = start;
			this.to = to;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge o) {
			return this.distance-o.distance;
			//return Integer.compare(this.distant, o.distant); // 이 코드로도 가능할 듯 
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Planet[] planets;
		List<Edge>[] adjList;
		
		//행성을 n개 만큼 담을 배열 생성 
		planets = new Planet[n];
		
		// n개 행성의 좌표를 차례로 입력받음 
		// 각 행성에 인덱스를 부여하여 각 행성을 구별함 
		StringTokenizer st;
		for(int i=0; i<n; i++) { 
			st = new StringTokenizer(br.readLine());
			int x =Integer.parseInt(st.nextToken());
			int y =Integer.parseInt(st.nextToken());
			int z =Integer.parseInt(st.nextToken());
			
			planets[i] = new Planet(i,x,y,z);
		}
		
		//인접리스트 생성 
		adjList = new ArrayList[n];
		for(int i=0; i<n; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		// 주어진 정점에 대한 간선을 모두 구하면 대략 500억개이다.
		// 그래서 필요한 간선만 추려내야 한다. 
		// 각 축선을 기준(x축, y축, z축)으로 오름차순 정렬하면 
		// 각 좌표의 인접해 있는 좌표(정점)와의 거리가 최적의 간선이 된다.
		// 위 방식으로 구하면 총  3 x (n-1) 개의 간선을 구할 수 있게 된다. (3은 각각 오름차순 정렬한 x,y,z 를 의미함)
		// 위 방식이 적용되는 이유는 a에서 b라는 행성간의 거리비용이 x축을 기준으로 구한 비용(|xA-xB|),
		// y축을 기준으로 구한 비용(|yA-yB|), z축을 기준으로 구한비용(|zA-zB|) 들을 비교했을때
		// 가장 작은 값이기 때문이다. 
		
		// x를 기준으로 정렬 
		// x를 기준하여 planet들을 정렬하고 
		// 이로 인해 x글 기준으로 인접한 planet들을 찾을 수 있고 인접한 plane들을 간선으로 이어줄 수 있다.
		// 이러한 planet들을 마침 위에서 planets 배열에 담아 두었다.
		// 따라서 Arrays.sort 메서드를 활용하여 정렬할 수 있는데,
		// 정렬 기준을 정해줘야 한다. x를 기준으로 오름차순 정렬한다고 했으니 이를 코드를 통해 구현해줘야 한다.
		Arrays.sort(planets, new Comparator<Planet>() {
			@Override
			public int compare(Planet o1, Planet o2) {
				return o1.x -o2.x;
			}
		});
		
		// x를 기준으로 planets배열을 위에서 정렬해준뒤 
		// 아래에서는 이제 x를 기준으로 인접한 행성들끼리 차례로 간선으로 이어준다. 
		for( int i=0; i<n-1; i++) {
			Planet p1 = planets[i];
			Planet p2 = planets[i+1];
			int distance = Math.abs(p1.x-p2.x);
			adjList[p1.index].add(new Edge(p1.index,p2.index,distance));
			adjList[p2.index].add(new Edge(p2.index,p1.index,distance));
		}
		
		// y를 기준으로 정렬 
		// y를 기준하여 planet들을 정렬하고 
		// 이로 인해 y를 기준으로 인접한 planet들을 찾을 수 있고 인접한 plane들을 간선으로 이어줄 수 있다.
		// 따라서 Arrays.sort 메서드를 활용하여 planets배열을 y를 기준으로 다시정렬한다. 
		// 정렬 기준을 y를 기준으로 오름차순 정렬한다고 했으니 이를 코드를 통해 구현해줘야 한다.
		Arrays.sort(planets, new Comparator<Planet>() {
			@Override
			public int compare(Planet o1, Planet o2) {
				return o1.y-o2.y;
			}
		});
		
		// y를 기준으로 planets배열을 위에서 정렬해준뒤 
		// 아래에서는 이제 y를 기준으로 인접한 행성들끼리 차례로 간선으로 이어준다. 
		for(int i=0; i<n-1; i++) {
			Planet p1 = planets[i];
			Planet p2 = planets[i+1];
			int distance = Math.abs(p1.y-p2.y);
			adjList[p1.index].add(new Edge(p1.index,p2.index,distance));
			adjList[p2.index].add(new Edge(p2.index,p1.index,distance));
		}
		
		// z를 기준으로 정렬 
		// z를 기준하여 planet들을 정렬하고 
		// 이로 인해 z를 기준으로 인접한 planet들을 찾을 수 있고 인접한 plane들을 간선으로 이어줄 수 있다.
		// 따라서 Arrays.sort 메서드를 활용하여 planets배열을 z를 기준으로 다시정렬한다. 
		// 정렬 기준을 z를 기준으로 오름차순 정렬한다고 했으니 이를 코드를 통해 구현해줘야 한다.
		Arrays.sort(planets,new Comparator<Planet>() {
			@Override
			public int compare(Planet o1, Planet o2) {
				return o1.z-o2.z;
			}
		});
		
		// z를 기준으로 planets배열을 위에서 정렬해준뒤 
		// 아래에서는 이제 z를 기준으로 인접한 행성들끼리 차례로 간선으로 이어준다. 
		for(int i=0; i<n-1; i++) {
			Planet p1 = planets[i];
			Planet p2 = planets[i+1];
			int distance = Math.abs(p1.z-p2.z);
			adjList[p1.index].add(new Edge(p1.index,p2.index,distance));
			adjList[p2.index].add(new Edge(p2.index,p1.index,distance));
		}
		
		// 위에서 간선을 잇는 작업을 하고나면 
		// 인접리스트에서 어떤행성과 어떤행성간의 간선이 x,y,z 세 기준중 하나의 기준으로만 이어져있을 수도 있다.
		// 예를 들어 x의 기준으로 이어진 간선만 있다면 y,와 z 기준으로는 인접하지 않았다는 의미이고,
		// 이는 곧 x의 기준으로 이어진 간선이 최소값/최소비용이 된다는 의미이다.
		
		// 만약 어떤행성과 어떤행성으로 가는 간선이 x,y,z 세 기준으로 모두 중복으로 이어져있는 경우,
		// 프림 알고리즘을 통해(우선순위 큐) 이 세 기준중 가장 최소값인 간선만 선택될 것이기 때문에 문제없다.
		
		// 사실 위에서 적은 경우를 딱히 고민하지 않았어도 된다.
		// 왜냐하면 mst 알고리즘 자체가 다음 정점(행성)이 어디든 상관 없이 기준 정점을 기점으로 당장
		// 최소의비용인 간선을 선택하는 알고리즘이기 때문이다. 
		
		// 위와 같은 경우를 고민한 이유는
		// 평소의 mst 같은 경우라면 a라는 정점에서 b라는 정점으로 가는 간선은 1개 밖에 없었을 것이다.
		// 그러나 이 문제 같은 경우 x,y,z 축을 고려해야하기 때문에 
		// a라는 정점에서 b라는 정점으로 가는 간선이 최대 3개가 된다. 
		// (x,y,z 세 기준으로 모두 a,b가 인접해 있을때만 최대 3개이다. 세 기준이 모두 인접해 있지 않으면 3개보다 작을 수 있다.)
		// 하지만 해당 문제에서 
		//		두 행성 A(xA, yA, zA)와 B(xB, yB, zB)를 터널로 연결할 때 드는 비용은 min(|xA-xB|, |yA-yB|, |zA-zB|)이다.
		// 라는 조건을 줬기 때문에 3개의 간선을 각각 x축 기준인지, y축 기준인지 z축 기준인지 고려할 필요 없이
		// mst 알고리즘을 통해 최단 간선만 고르면 된다.
		// 즉, 기존 mst에서와 같이 다음 정점이 어디든간에(방문하지 않았다는 조건하에), 또 x축 기준 간선이었든간에,
		// y축 간선이었든 간에, z축 기준 간선이었든 간에 상관없이 최단 비용만 선택하면 된다.
		
		
		// 프림 알고리즘 시작 
		boolean[] chk = new boolean[n];
		PriorityQueue<Edge> p = new PriorityQueue<>();
		
		p.add(new Edge(0,0,0));
		//p.addAll(adjList[0]);
		//chk[0] = true; // 다른분은 이렇게도 시작함 
		
		int sumDistance=0;
		
		while(!p.isEmpty()) {
			Edge edge = p.poll();
			if(chk[edge.to]==false) {
				chk[edge.to]=true;
				sumDistance += edge.distance;
				
				for(Edge nextEdge : adjList[edge.to]) {
					if(chk[nextEdge.to] == false) {
						p.add(nextEdge);
					}
				}
			}
		}
		
		System.out.println(sumDistance);
		
	}

}
