package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 알고리즘 10816번 숫자 카드 문제 풀이 - 이진 탐

public class P10816 {
	
	public static int[] cards;
	public static int[] numbers;
	public static int[] answers;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		cards = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<cards.length; i++) {
			cards[i]= Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cards); // 탐색해야 하는 숫자들 정렬  
		
		
		int m = Integer.parseInt(br.readLine());
		numbers = new int[m];
		answers = new int[m];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			numbers[i]=Integer.parseInt(st.nextToken());
			int count = upper_bound(0,cards.length,numbers[i])-lower_bound(0,cards.length,numbers[i]);
			answers[i]=count;
			
			System.out.print(answers[i]+" ");
		}
		
		

	}
	
	// 중복 원소에 대한 길이는 상한 - 하한으로 구할 수 있다. 
	
	// lower bound 는 하한을 의미한다.
	// 하한은 찾고자 하는 값 이상의 값이 처음으로 나타나는 위치를 의미한다. 
	// 왼쪽부터 볼 때 찾고자 하는값이 같거나 큰 경우를 처음 만나느 위치를 의미한다. 
	public static int lower_bound (int start, int end, int target) {
		if(start == end) {
			return start;
		}
		
		int mid = (start+end)/2;
		if(target<=cards[mid]) {
			end=mid;
			return lower_bound(start,end, target);
		}else {
			start=mid+1;
			return lower_bound(start,end,target);
		}
		
		
	}
	
	// upper bound는 상한을 의미한다.
	// 상한은 찾고자 하는 값을 초과한 값을 처음 만나는 위치다. 
	// 찾고자 하는 값이 더이상 넘어 갈 수 없는 위치를 의미한다. 
	public static int upper_bound(int start, int end, int target) {
		if(start == end) {
			return start;
		}
		
		int mid = (start+end)/2;
		
		if(target<cards[mid]) {
			end=mid;
			return upper_bound(start,end,target);
		}else {
			start =mid+1;
			return upper_bound(start,end,target);
		}
		
	}

}
