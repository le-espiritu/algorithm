package stringAlgorithm;

import java.util.Scanner;

//백준 10809번 문제 알파벳 찾기를 풀이한 코드 

public class FindAlphabet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		for(char i='a'; i<='z'; i++) {
			String alp = Character.toString(i);
			System.out.print(s.indexOf(alp)+" ");
		}

	}

}
