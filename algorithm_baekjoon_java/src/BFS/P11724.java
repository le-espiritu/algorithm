package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11724 {
	
	public static List<Integer>[] graph;
	public static boolean[] chk;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		graph=new ArrayList[n+1];
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
		
		chk=new boolean[n+1];
		for(int i=1; i<=n; i++) {
			if(chk[i]==false) {
				chk[i]=true;
				bfs(i);
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	
	public static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.add(num);
		while(!q.isEmpty()) {
			int nowNum = q.poll();
			
			for(int nextNum : graph[nowNum]) {
				if(chk[nextNum]==false) {
					chk[nextNum]=true;
					q.add(nextNum);
				}
			}
		}
	}

}
