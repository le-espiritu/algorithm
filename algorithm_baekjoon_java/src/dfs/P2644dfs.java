package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 백준 알고리즘 - 2644 촌수계산 문제 풀이 - DFS알고리즘 활용  

public class P2644dfs {
	
	public static int[] dist;
	public static List<Integer>[] graph;
	public static boolean[] chk;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		dist= new int[n+1];
		graph = new ArrayList[n+1];
		for(int i=0; i<graph.length; i++) {
			graph[i]=new ArrayList<>();
		}
		chk = new boolean[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			graph[c].add(d);
			graph[d].add(c);
		}
		
		dfs(a,b);
		
		if(dist[b]==0) {
			System.out.println(-1);
		}else {
			System.out.println(dist[b]);
		}

	}
	
	public static void dfs(int a, int b) {
		
		chk[a]=true;
		
		if(a==b) {
			return;
		}
		
		for(int next : graph[a]) {
			if(chk[next]==false) {
				dist[next]=dist[a]+1;
				dfs(next,b);
			}
		}
	}
}
