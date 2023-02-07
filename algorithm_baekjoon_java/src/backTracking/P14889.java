package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14889 {
	
	public static int n;
	public static int[][] power;
	public static boolean[] chk;
	public static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		power=new int[n][n];
		chk=new boolean[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				power[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		bt(0,0);
		
		System.out.println(min);

	}
	
	public static void bt(int idx, int depth) {
		if(depth==n/2) {
			int startSum=0;
			int linkSum=0;
			
			for(int i=0; i<chk.length; i++) {
				for(int j=i; j<chk.length; j++) {
					if(chk[i]==true && chk[j]==true) {
						startSum += power[i][j]+power[j][i];
					}
					
					if(chk[i]==false && chk[j]==false) {
						linkSum += power[i][j]+power[j][i];
					}
				}
			}
			
			int result = Math.abs(startSum-linkSum);
			min = Math.min(min, result);
			return;
		}
		
		for(int i=idx; i<n; i++) {
			chk[i]=true;
			bt(i+1,depth+1);
			chk[i]=false;
		}
	}

}
