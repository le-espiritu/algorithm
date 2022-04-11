package loop;

import java.util.Scanner;

public class PlusUntilZero {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a==0&&b==0) {
				break;
			}else {
				System.out.println(a+b);
			}
		}
	}

}
