package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10159 {
	
	public static int INF= 1000000000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		boolean[][] dist =new boolean[n+1][n+1];
		boolean[][] reverseDist = new boolean[n+1][n+1];
		
		
		StringTokenizer st;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			dist[a][b]=true;
			reverseDist[b][a]=true;
		}
		
		for(int k=1; k<n+1; k++) {
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					if(dist[i][k]==true && dist[k][j]==true) {
						dist[i][j]=true;
					}
					
					if(reverseDist[i][k]==true && reverseDist[k][j]==true) {
						reverseDist[i][j]=true;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<n+1; i++) {
			int count=0;
			for(int j=1; j<n+1; j++) {
				dist[i][j]= dist[i][j]|reverseDist[i][j];
			
				if(dist[i][j]==false) {
					count++;
				}
			}
			sb.append(count-1+"\n");
		}
		
		System.out.println(sb);

	}

}
