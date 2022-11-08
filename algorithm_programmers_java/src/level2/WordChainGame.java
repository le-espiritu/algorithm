package level2;

import java.util.Arrays;

// 프로그래머스 레벨2 영어 끝말잇기 알고리즘

public class WordChainGame {
	public static void main(String[] args) {
		int n = 2;
		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
		int[] answer = solution(n,words);
		
		System.out.println("["+answer[0]+","+answer[1]+"]");

	}
	
	public static int[] solution(int n, String[] words) {
		int[] answer= new int[2];
		
		int turn=0;
		int num=0;
		
		boolean flag = true;
		
		int arrIdx=0;
		
		while(flag) {
			turn++;
			for(int i=1; i<=n; i++) {
				
				if(arrIdx!=0) {
					if(words[arrIdx].charAt(0)!=words[arrIdx-1].charAt(words[arrIdx-1].length()-1)) {
						num=i;
						flag=false;
					}
				}
				
				if(Arrays.asList(words).indexOf(words[arrIdx])!=arrIdx) {
					num=i;
					flag=false;
				}
				
				
				if(arrIdx==words.length-1) {
					flag = false;
				}
				arrIdx++;
			}
		}
		
		answer[0]= num;
		if(num==0) {
			answer[1]=0;
		}else {
			answer[1]= turn;
		}
		return answer;
	}

}
