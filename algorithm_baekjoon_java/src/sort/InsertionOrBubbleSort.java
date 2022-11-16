package sort;

import java.util.Scanner;

// 백준 알고리즘 정렬 2750번 문제 수 정렬하기 문제 풀이 
// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오. 

public class InsertionOrBubbleSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i]= sc.nextInt();
			int e=arr[i];
			int j;
			for( j=i-1; j>=0; j--) {
				if(e<arr[j]) {
					arr[j+1]=arr[j];
				}else {
					break;
				}
			}
			arr[j+1]=e;
		}
		
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
