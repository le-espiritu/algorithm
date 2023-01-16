package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2458 {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		boolean[][] graph = new boolean[n+1][n+1];
		boolean[][] reversedGraph = new boolean[n+1][n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b]=true;
			reversedGraph[b][a]=true;
		}
		
		for(int k=1;k<n+1; k++) {
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					if(graph[i][k] && graph[k][j]) {
						graph[i][j]=true;
					}
				}
			}
		}
		
		for(int k=1; k<n+1; k++) {
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					if(reversedGraph[i][k]&&reversedGraph[k][j]) {
						reversedGraph[i][j]=true;
					}
				}
			}
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				graph[i][j]= graph[i][j] || reversedGraph[i][j];
			}
		}
		
		int answer =0;
		outer : for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(j==i) {
					continue;
				}
				
				if(graph[i][j]==false) {
					continue outer;
				}
			}
			answer++;
		}
		
		System.out.println(answer);

	}

}
