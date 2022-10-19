package stringAlgorithm;

import java.util.Scanner;
import java.util.StringTokenizer;

// 자바 1152번 문제 단어의 개수 구하는 문제 
// 영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오. 
// 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.

public class CountNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine(); // nextLine()은 enter키 입력을 기다린다.
		//str=str.trim(); // String.trim()은 문자열 앞 뒤의 공백을 제거한다. (문자열 중간에 있는 공백은 제거하지 못한다.) 
		//String[] words = str.split(" ");
		//split() 을 사용할 경우 빈공백을 입력받았을시 배열의 길이가 0이아닌 1이 반환되기 때문에 문제가 생긴다. 
		StringTokenizer st = new StringTokenizer(str," ");
		
		System.out.println(st.countTokens());

	}

}
