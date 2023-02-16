package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14938 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken()); // 수색범위 
		int r = Integer.parseInt(st.nextToken()); // 길의 개수 
		
		st = new StringTokenizer(br.readLine());
		int[] items = new int[n+1];
		for(int i=1; i<items.length; i++) {
			items[i]=Integer.parseInt(st.nextToken());
		}
		
		int INF=100000000;
		
		int[][] dist = new int[n+1][n+1];
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i==j) {
					dist[i][j]=0;
				}else {
					dist[i][j]=INF;
				}
				
			}
		}
		
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			dist[a][b]=distance;
			dist[b][a]=distance;
		}
		
		
		for(int k=1; k<n+1; k++) {
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					if(dist[i][j]>dist[i][k]+dist[k][j]) {
						dist[i][j]=dist[i][k]+dist[k][j];
					}
				}
			}
		}
		
		int max =0;
		
		for(int i=1; i<n+1; i++) {
			int sum=0;
			for(int j=1; j<n+1; j++) {
				if(dist[i][j]<=m) {
					sum+=items[j];
				}
			}
			max = Math.max(max, sum);
		}
		
		System.out.println(max);

	}

}
