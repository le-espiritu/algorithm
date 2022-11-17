package sort;

import java.util.Scanner;

// 백준 알고리즘 정렬 알고리즘 2587번 대표값2 문제
// 다섯 개의 자연수가 주어질 때 이들의 평균과 중앙값을 구하는 프로그램을 작성하시오.

public class RepresentativeValue2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		int sum=0;
		
		for(int i=0; i<5; i++) {
			arr[i]=sc.nextInt();
			int v = arr[i];
			int j;
			
			sum +=v;
			
			for(j=i-1; j>=0; j--) {
				if(arr[j]>v) {
					arr[j+1]=arr[j];
				}else {
					break;
				}
			}
			
			arr[j+1]=v;
			
		}
		
		int avg = sum/5;
		int centerValue = arr[2];
		
		System.out.println(avg);
		System.out.println(centerValue);

	}

}
