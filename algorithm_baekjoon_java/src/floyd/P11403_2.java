package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11403_2 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		int[][] map = new int[n+1][n+1];
		for(int i=1; i<n+1; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1; j<n+1; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k=1; k<n+1; k++) {
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					if(map[i][k]==1 && map[k][j]==1) {
						map[i][j]=1;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}

}




