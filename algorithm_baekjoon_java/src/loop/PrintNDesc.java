package loop;

import java.util.Scanner;

public class PrintNDesc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = n; i>0; i--) {
			System.out.println(i);
		}
	}

}
