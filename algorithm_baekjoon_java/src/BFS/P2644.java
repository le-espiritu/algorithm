package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 2644번 문제 - 촌수계산하기 - BFS 알고리즘  

public class P2644 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] level = new int[n+1];
		
		List<Integer>[] graph = new ArrayList[n+1];
		for(int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
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
		
		//그래프 순회
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] chk = new boolean[n+1];
		q.add(a);
		
		
		while(!q.isEmpty()) {
			int now = q.poll();
			chk[now] = true;
			
			if(now==b) {
				break;
			}
			
			for(int next : graph[now]) {
				if(chk[next]==false) {
					level[next]=level[now]+1;
					q.add(next);
				}
			}
		}
		
		if(level[b]==0) {
			System.out.println(-1);
		}else {
			System.out.println(level[b]);
		}

	}

}
