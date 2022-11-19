package sort;

import java.util.Scanner;

// 백준 알고리즘 정렬 25305번 커트라인 문제 
// 2022 연세대학교 미래캠퍼스 슬기로운 코딩생활에 $N$명의 학생들이 응시했다. 
// 이들 중 점수가 가장 높은 $k$명은 상을 받을 것이다. 이 때, 상을 받는 커트라인이 몇 점인지 구하라.
// 커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.

public class CutLine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i =0; i<n; i++) {
			arr[i]=sc.nextInt();
			int v = arr[i];
			int j;
			for(j=i-1; j>=0; j--) {
				if(arr[j]>v) {
					arr[j+1]=arr[j];
				}else {
					break;
				}
			}
			arr[j+1]=v;
		}
		
		int cutLine = arr[n-k];
		
		System.out.println(cutLine);

	}

}
