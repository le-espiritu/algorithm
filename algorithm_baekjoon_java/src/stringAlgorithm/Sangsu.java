package stringAlgorithm;

import java.util.Scanner;

//백준 2908번 상수 문제 
//상수는 수를 다른 사람과 다르게 거꾸로 읽는다. 예를 들어, 734와 893을 칠판에 적었다면, 상수는 이 수를 437과 398로 읽는다. 
//따라서, 상수는 두 수중 큰 수인 437을 큰 수라고 말할 것이다.
//두 수가 주어졌을 때, 상수의 대답을 출력하는 프로그램을 작성하시오.

public class Sangsu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		
		StringBuilder aSb = new StringBuilder(a);
		String reversedA =aSb.reverse().toString();
		//reverse() 메소드만 사용하면 스트링빌더 객체가 반환된다. 그러므로 스트링으로 변환해주기위해 toString() 메서드를 이용하였다.
		int intReversedA = Integer.parseInt(reversedA);
 		
		StringBuilder bSb = new StringBuilder(b);
		String reversedB = bSb.reverse().toString();
		int intReversedB = Integer.parseInt(reversedB);
		
		if(intReversedA > intReversedB) {
			System.out.println(intReversedA);
		}else if(intReversedB>intReversedA) {
			System.out.println(intReversedB);
		}

	}

}
