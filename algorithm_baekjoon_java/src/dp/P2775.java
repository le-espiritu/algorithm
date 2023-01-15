package dp;

import java.util.Scanner;

public class P2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[15][15];
		for(int i=0; i<15; i++) {
			arr[0][i]=i;
		}
		
		for(int i=1; i<15; i++) {
			int sum=0;
			for(int j=0; j<15; j++) {
				sum+=arr[i-1][j];
				arr[i][j]=sum;
				//System.out.print("arr["+i+"]["+j+"]="+arr[i][j]+" ");
			}
			//System.out.println();
		}
		
		StringBuilder sb = new StringBuilder();
		
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			sb.append(arr[k][n]+"\n");
		}
		
		System.out.println(sb);
	}

}
