package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 알고리즘 1920번 수 찾기 문제 - 이진탐색을 활용하여 풀기

/*
1. 아이디어 
- N개의 숫자를 정렬
- M개를 for문 돌면서, 이진탐색
- 이진탐색 안에서 마지막에 데이터 찾으면, 1출력, 아니면 0출력

2. 시간복잡도 
- N개 입력값 정렬 = O(N logN)
- M개를 N개중에서 탐색 = O(M logN)
- 총합 : O((N+M)logN) > 가능

3. 자료구조 
- N개 숫자 : int[]
- M개 숫자 : int[]
*/

public class NumberSearch {
	
	public static int[] nArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		nArr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			nArr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nArr);
		
		int m = Integer.parseInt(br.readLine());
		int[] mArr = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			mArr[i]=Integer.parseInt(st.nextToken());
			search(0,n-1,mArr[i]);
		}
		
		
	}
	
	public static void search(int st, int en, int target) {
		if(st==en) {
			if(nArr[st]== target) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
			return;
			
		}
		
		int mid = (st+en)/2;
		
		if(nArr[mid]<target) {
			search(mid+1,en,target);
		}else {
			search(st,mid,target);
		}
		
	}
	
	

}
