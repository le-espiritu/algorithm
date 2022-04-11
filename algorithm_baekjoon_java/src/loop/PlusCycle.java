package loop;

import java.util.Scanner;

public class PlusCycle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count =0;
		int a = n/10;
		int b = n%10;
		
		while(true) {
			
			int rigntNumberOfSum = (a+b)%10;
			int newNumber = (b*10)+rigntNumberOfSum;
			
			if(n==newNumber){
				count++;
				System.out.println(count);
				break;
			}
			a = newNumber/10;
			b = newNumber%10;
			count++;
		}
		
	}

}
