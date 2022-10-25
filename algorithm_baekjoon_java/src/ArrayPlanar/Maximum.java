package ArrayPlanar;

import java.util.Scanner;

// 백준 2566번 문제 최댓값 구하기 

public class Maximum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[9][9];
		
		int max =0;
		int row =0;
		int col =0;
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				arr[i][j]= sc.nextInt();
				if(arr[i][j]>=max) { // 최대값이 0일때를 고려하여 >=로 함.
					max = arr[i][j];
					row = i+1;
					col = j+1;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(row+" "+col);

	}

}
