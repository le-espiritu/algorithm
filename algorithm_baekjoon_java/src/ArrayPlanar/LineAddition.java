package ArrayPlanar;

import java.util.Scanner;

// 백준 2738번 문 - 행렬 덧셈 문제
// N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오. 
public class LineAddition {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] arr1 = new int[n][m];
		int[][] arr2 = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr1[i][j]= sc.nextInt();
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr2[i][j]= sc.nextInt();
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(arr1[i][j]+arr2[i][j]+" ");
			}
			System.out.println("");
		}

	}

}
