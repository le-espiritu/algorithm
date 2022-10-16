package stringAlgorithm;

import java.util.Scanner;

//백준 알고리즘 11720번 문제 숫자의 합을 풀이한 코드  

public class SumOfNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String strNumber = sc.next();
		String[] strNumbers = strNumber.split("");
		
		int sum =0;
		
		for(int i =0; i<n; i++) {
			
			sum = sum+Integer.parseInt(strNumbers[i]);
		}
		
		System.out.println(sum);

	}

}
