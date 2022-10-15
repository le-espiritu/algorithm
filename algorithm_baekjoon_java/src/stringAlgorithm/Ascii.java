package stringAlgorithm;
// 자바 11654번 문제 - 아스키 코드값을 출력하는 문제 

import java.util.Scanner;

public class Ascii {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ch = sc.next().charAt(0);
		int code = (int)ch;
		
		System.out.println(code);

	}

}
