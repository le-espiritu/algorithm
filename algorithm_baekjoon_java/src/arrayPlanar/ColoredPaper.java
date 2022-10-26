package arrayPlanar;

import java.util.Scanner;

// 백준 2563번 문제 색종이 문제  

public class ColoredPaper {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[100][100];
		
		int n = sc.nextInt();
		
		int count=0;
		
		for(int i =0; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int a=x; a<x+10; a++) {
				for(int b=y; b<y+10; b++) {
					arr[a][b]=1;
				}
			}
		}
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(arr[i][j]==1) {
					count++;
				}
			}
		}
		
		System.out.println(count);
		

	}

}
