package level2;

import java.util.Arrays;

// 프로그래머스 알고리즘 레벨2 N개의 최소공배수 구하는 알고리즘  

public class TheLeastCommonMultiple {
	public static void main(String[] args) {
		int[] arr = {2,6,8,14};
		int answer = solution(arr);
		System.out.println(answer);

	}
	
	public static int solution(int[] arr) {
		int answer = 0;
		
		Arrays.sort(arr);
		
		int maxNum = arr[arr.length-1];  // 배열에서 가장 큰 수  
		int multipleCount=1; // 배수의 횟수 
		

		if(arr.length==1) { //  만약 배열에 값이 1개 밖에 없으면 이 값을 리턴해줌 
			answer=maxNum;
			return answer;
		}
		
		int flagCount=arr.length-1; // 배열에서 가장 큰수의 배수를 배열에서 큰수를 제외한 나머지 수들로 나누었을때 딱 나눠 떨어지는지 확인하기 위한 카운트 
									// 모두 나눠 떨어진다면 (flagCount가 0이 된다면) 공배수를 찾음을 의미함 
		
		while(flagCount>0) {
			int num=maxNum*multipleCount;
			
			
			for(int i=arr.length-2; i>=0; i--) {
				if(num%arr[i]==0) {
					flagCount--;
				}
			}
			if(flagCount==0) {
				answer=num;
			}else {
				flagCount=arr.length-1; // 공배수가 아니라면 flagCount를 다시 초기화 
			}
			
			multipleCount++;
		}
		
		return answer;
	}

}
