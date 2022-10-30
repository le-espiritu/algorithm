package level2;

import java.util.Arrays;
import java.util.Collections;

// 프로그래머스 알고리즘 레벨 2 최솟값 만들기 문제 풀이 

public class MakingMinimum {
	public static void main(String[] args) {
		int[] a = {1, 2};
		int[] b = {3, 4};
		
		int answer = solution(a,b);
		
		System.out.println(answer);

	}
	
	public static int solution(int[] a, int[]b) {
		int answer=0;
		Arrays.sort(a);
		//System.out.println(Arrays.toString(a));
		
		Integer[] b2 = new Integer[b.length];
		
		for(int i=0; i<b.length; i++) {
			b2[i] = b[i];
		}
		Arrays.sort(b2, Collections.reverseOrder());
		
		//System.out.println(Arrays.toString(b2));
		
		for(int i=0; i<a.length; i++) {
			answer = answer+ a[i]*b2[i];
		}
		
		
		return answer;
	}

}
