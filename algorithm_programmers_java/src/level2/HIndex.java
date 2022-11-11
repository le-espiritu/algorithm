package level2;

import java.util.Arrays;

// 프로그래머스 알고리즘 레벨 2 H-Index를 구하는 문제 

public class HIndex {
	public static void main(String[] args) {
		int[]citations = {3,0,6,1,5};
		//int[]citations = {0,0,0,0,0};
		int answer = solution(citations);
		System.out.println(answer);

	}
	
	public static int solution(int[] citations) {
		int answer =0;
		
		Arrays.sort(citations);
		
		int count =0;
		
		for(int hIndex=0; hIndex<=citations.length; hIndex++) {
			for(int j=0; j<citations.length; j++) {
				if(count>hIndex) {
					break;
				}
				if(hIndex>citations[j]) {
					count++;
				}
			}
			
			if(count==0 && hIndex==0) {
				boolean flag = true;
				for(int i=0; i<citations.length; i++) {
					if(citations[i]!=0) {
						flag=false;
					}
				}
				if(flag) {
					return 0;
				}
			}
			else if(citations.length-count>=hIndex) {
				answer=hIndex;
			}
			
			count=0;
		}
		return answer;
	}

}
