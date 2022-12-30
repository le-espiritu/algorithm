package floyd;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

// 백준 알고리즘 11403번 경로 찾기 문제 - 플로이드 와샬 알고리즘 

public class P11403 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] dist = new int[n+1][n+1];
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				int num = sc.nextInt();
				
				if(num==0) {
					dist[i][j]=100000000;
				}else {
					dist[i][j]=1;
				}
				
			}
		}
		
		
		for(int k=1; k<n+1; k++) {
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					dist[i][j]= Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(dist[i][j]==100000000) {
					System.out.print(0+" ");
				}else {
					System.out.print(1+" ");
				}
			}
			System.out.println();
		}
		

	}

}
