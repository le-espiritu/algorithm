package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P2660 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int INF = 100000000;
		
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
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a==-1 && b==-1) {
				break;
			}
			
			dist[a][b]=1;
			dist[b][a]=1;
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
		
		int min = Integer.MAX_VALUE;
		int[] scores = new int[n+1];
		
		for(int i=1; i<n+1; i++) {
			int max =0;
			for(int j=1; j<n+1; j++) {
				if(i==j) {
					continue;
				}
				if(dist[i][j]!=INF) {
					max=Math.max(max, dist[i][j]);
				}
			}
			scores[i]=max;
			min=Math.min(min, scores[i]);
			
		}
		
		int count=0;
		ArrayList<Integer> candidates = new ArrayList<>();
		
		for(int i=1; i<scores.length; i++) {
			if(scores[i]==min) {
				count++;
				
				candidates.add(i);
			}
		}
		
		Collections.sort(candidates);
		
		StringBuilder sortedCandi = new StringBuilder();
		for(int i=0; i<candidates.size(); i++) {
			sortedCandi.append(candidates.get(i)+" ");
		}
		
		System.out.println(min+" "+count);
		System.out.println(sortedCandi);

	}

}
