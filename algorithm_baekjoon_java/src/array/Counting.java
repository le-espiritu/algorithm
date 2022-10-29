package array;

import java.util.Scanner;

//백준 알고리즘 10807번 문제 개수 세기 문제

public class Counting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int count =0;
		
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		int v = sc.nextInt();
		
		for(int j=0; j<arr.length; j++) {
			if(arr[j]==v) {
				count++;
			}
		}
		
		System.out.println(count);

	}

}
