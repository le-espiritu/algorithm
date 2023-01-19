package dp;

import java.util.Scanner;

public class P1149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] arr = new int[n][3];
		for(int i=0; i<n; i++) {
			for(int j=0; j<3; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		
		int[][] dpArr = new int[n][3];
		dpArr[0][0]=arr[0][0];
		dpArr[0][1]=arr[0][1];
		dpArr[0][2]=arr[0][2];
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<3; j++) {
				if(dpArr[i][j]==0) {
					if(j==0) {
						dpArr[i][j]=Math.min(dpArr[i-1][1],dpArr[i-1][2]) + arr[i][j];
					}
					else if(j==1) {
						dpArr[i][j]=Math.min(dpArr[i-1][0],dpArr[i-1][2]) + arr[i][j];
					}
					else if(j==2) {
						dpArr[i][j]=Math.min(dpArr[i-1][0],dpArr[i-1][1]) + arr[i][j];
					}
					
				}
			}
		}
		
		int answer=0;
		
		answer = Math.min(dpArr[n-1][0], dpArr[n-1][1]);
		answer = Math.min(answer, dpArr[n-1][2]);
		
		System.out.println(answer);

	}

}
