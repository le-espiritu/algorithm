package binarySearch;

import java.util.Scanner;

public class P12015 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] seq = new int[n];
		int[] lis = new int[n];
		
		for(int i=0; i<n; i++) {
			seq[i]=sc.nextInt();
		}
		
		lis[0]= seq[0];
		int lisLength =1;
		
		for (int i=1; i<n; i++) {
			int searchNum = seq[i];
			
			if(lis[lisLength-1]<searchNum) { // lisLength-1 lis배열의 마지막 값을 가르키는 인덱스 
				lisLength++;
				lis[lisLength-1]= searchNum; // 탐색값이 크다면 lis배열의 최근 원소로 저장한다. 
			}
			else { // 탐색값이 lis배열의 최근값 보다 작거나 같다면 
				// lower Bound 이분탐색을 진행한다.
				int lo =0;
				int hi = lisLength;
				
				while(lo<hi) {
					int mid = (lo+hi)/2;
					
					if(lis[mid]<searchNum) {
						lo=mid+1;
					}
					else { // 탐색값(searchNum)이 lis[mid] 보다 작거나 같다면 
						hi=mid;
					}
				}
				
				lis[lo]= searchNum;
			}
		}
		
		System.out.println(lisLength);

	}

}
