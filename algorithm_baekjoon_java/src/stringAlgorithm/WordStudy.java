package stringAlgorithm;

import java.util.Scanner;

// 백준 1157번 단어 공부 알고리즘 문제를 풀이한 코드  
// 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오 

public class WordStudy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		word=word.toUpperCase();
		int max=0;
		char maxAlp = ' ';
		
		for(char i = 'A'; i<='Z'; i++) {
			int count=0;
			for(int j=0; j<word.length(); j++) {
				if(i == word.charAt(j)) {
					count++;
				}
			}
			if(count>max) {
				max= count;
				maxAlp=i;
			}else if(count>0 && count==max) {
				maxAlp='?';
			}
		}
		
		System.out.println(maxAlp);

	}

}
