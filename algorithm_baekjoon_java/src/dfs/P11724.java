package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P11724 {
	
	public static List<Integer>[] graph;
	public static boolean[] chk;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n+1];
		for(int i=0; i<graph.length; i++) {
			graph[i]=new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		int count=0;
		
		chk= new boolean[n+1];
		for(int i=1; i<=n; i++) {
			if(chk[i]==false) {
				chk[i]=true;
				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	
	public static void dfs(int num) {
		for(int nextNum : graph[num]) {
			if(chk[nextNum]==false) {
				chk[nextNum]=true;
				dfs(nextNum);
			}
		}
	}

}
