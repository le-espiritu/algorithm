package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1956 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int[][] dist = new int[v+1][v+1];
		int inf = 100000000;
		
		for(int i=1; i<v+1; i++) {
			for(int j=1; j<v+1; j++) {
				if(i==j) {
					dist[i][j]=0;
				}else {
					dist[i][j]=inf;
				}
			}
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			dist[a][b]=c;
		}
		
		for(int k=1; k<v+1; k++) {
			for(int i=1; i<v+1; i++) {
				for(int j=1; j<v+1; j++) {
					if(dist[i][j]>dist[i][k]+dist[k][j]) {
						dist[i][j]=dist[i][k]+dist[k][j];
					}
				}
			}
		}
		
		int min = inf;
		
		for(int i=1; i<v+1; i++) {
			for(int j=1; j<v+1; j++) {
				if(i==j) {
					continue;
				}
				int result = dist[i][j]+dist[j][i];
				min = Math.min(min, result);
			}
		}
		
		if(min==inf) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}

	}

}
