package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1613 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] relation = new int[n+1][n+1];
		int INF = 100000000;
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i==j) {
					relation[i][j]=0;
				}else {
					relation[i][j]= INF;
				}
			}
		}
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int history1 = Integer.parseInt(st.nextToken());
			int history2 = Integer.parseInt(st.nextToken());
			
			relation[history1][history2]=1;
 		}
		
		for(int g=1; g<n+1; g++) {
			for (int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					if(relation[i][j]>relation[i][g]+relation[g][j]) {
						relation[i][j]=relation[i][g]+relation[g][j];
					}
				}
			}
		}
		
		int s = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<s; i++) {
			st = new StringTokenizer(br.readLine());
			
			int his1 = Integer.parseInt(st.nextToken());
			int his2 = Integer.parseInt(st.nextToken());
			
			if(relation[his1][his2]>=INF && relation[his2][his1]>=INF) {
				sb.append(0+"\n");
			}
			else if(relation[his1][his2]<relation[his2][his1]) {
				sb.append(-1+"\n");
			}
			else if(relation[his1][his2]>relation[his2][his1]) {
				sb.append(1+"\n");
			}
 		}
		
		System.out.println(sb);

	}

}
