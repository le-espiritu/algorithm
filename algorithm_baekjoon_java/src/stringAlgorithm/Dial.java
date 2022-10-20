package stringAlgorithm;

import java.util.Scanner;

//백준 자바 5622번 다이얼 문제 

public class Dial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		int time =0;
		
		for(int i=0; i<word.length(); i++) {
			char a =word.charAt(i);
			switch(a) {
			case 'A': case 'B': case 'C':
				time=time+3;
				break;
				
			case 'D': case 'E': case 'F':
				time=time+4;
				break;
			case 'G': case 'H': case 'I':
				time=time+5;
				break;
			case 'J': case 'K': case 'L':
				time=time+6;
				break;
			case 'M': case 'N': case 'O':
				time=time+7;
				break;
			case 'P': case 'Q': case 'R': case'S':
				time=time+8;
				break;
			case 'V': case 'T': case 'U':
				time=time+9;
				break;
			case 'W': case 'X': case 'Y': case 'Z':
				time=time+10;
				break;
			}
		}
		
		System.out.println(time);

	}

}
