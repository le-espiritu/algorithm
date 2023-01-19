package greedy;

import java.util.Scanner;

public class P5585 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pay = sc.nextInt();
		
		int change = 1000-pay;
		
		int[] coins = {500,100,50,10,5,1};
		
		int count=0;
		
		for(int i=0; i<coins.length; i++) {
			count+=change/coins[i];
			change=change%coins[i];
		}
		
		System.out.println(count);

	}

}
