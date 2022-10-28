package level2;

import java.util.Scanner;
import java.util.StringTokenizer;

// 프로그그래머스 레벨2 JadenCase 문자열 만들기 문제 

public class JadenCase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String answer = solution(s);
		System.out.println(answer);

	}
	
	public static String solution(String s) {
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringTokenizer st = new StringTokenizer(s," ",true);
		
		while(st.hasMoreTokens()) {
			String word = st.nextToken();
			sb2.append(word);
			char a = sb2.charAt(0);
			a = Character.toUpperCase(a);
			sb2.deleteCharAt(0);
			word = sb2.toString();
			word = word.toLowerCase();
			String upperA =Character.toString(a);

			sb.append(upperA+word);
			sb2.setLength(0);
		}
		
		String answer =sb.toString();
		return answer;
	}

}
