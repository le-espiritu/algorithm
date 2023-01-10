package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1389번 케빈 베이컨의 6단계 법칙 문제 풀이 - 플로이드 

public class P1389 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] dist = new int[n+1][n+1];
		for(int i =0; i<n+1; i++) {
			for(int j=0; j<n+1; j++) {
				if(i==j) {
					dist[i][j]=0;
					continue;
				}
				dist[i][j]=26000000;
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			dist[a][b]=Math.min(dist[a][b], 1);
			dist[b][a]=Math.min(dist[b][a], 1);
		}
		
		for(int k=1; k<n+1; k++) {
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		}
		
		int minSum=Integer.MAX_VALUE;
		int minNum=0;
		
		for(int i=1; i<n+1; i++) {
			int temp=0;
			
			for(int j=1; j<n+1; j++ ) {
				temp += dist[i][j];
			}
			
			if(temp<minSum) {
				minSum=temp;
				minNum=i;
			}
		}
		
		System.out.print(minNum);

	}

}
