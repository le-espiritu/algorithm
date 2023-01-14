package Simulation;

import java.util.Scanner;

public class P1018 {
	
	public static boolean[][] arr;
	
	public static int min=64;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		arr = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String str = sc.next();
			for(int j=0; j<m; j++) {
				char c = str.charAt(j);
				if(c=='W') {
					arr[i][j]=true;
				}else {
					arr[i][j]=false;
				}
			}
		}
		
		int n_row =n-7;
		int m_col =m-7;
		
		for(int i=0; i<n_row; i++) {
			for(int j=0; j<m_col; j++) {
				find(i, j);
			}
		}
		
		System.out.println(min);

	}
	
	public static void find(int x, int y) {
		int end_x = x+8;
		int end_y = y+8;
		int count =0;
		
		boolean tf = arr[x][y]; // 첫 번째 칸의 색
		
		for (int i=x; i<end_x; i++) {
			for(int j=y; j<end_y; j++) {
				if(arr[i][j]!=tf) {
					count++;
				}
				tf = !tf;
			}
			
			tf = !tf; // 만약 체스판이 짝수(8x8)가 아니라 홀수(7x7) 였으면 안해줘도 됨 
		}
		
		// 첫 번째 칸을 기준으로 할 때의 색칠 할 개수(count)와
		// 첫 번째 칸의 색의 반대되는 색을 기준으로 할 때의
		// 색칠 할 개수(64-count) 중 최솟값을 count에 저장 
		count = Math.min(count, 64 - count);
		
		min = Math.min(min, count);
	}

}
