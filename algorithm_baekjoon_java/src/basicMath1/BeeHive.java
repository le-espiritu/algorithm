package basicMath1;

import java.util.Scanner;

// 백준 2292번 벌집 문제   
public class BeeHive {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long count=1;
		long result =1;
		
		while(result<n) {
			result=result+count*6;
			count++;
		}
		
		System.out.println(count);

	}

}
