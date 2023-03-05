package greedy;

import java.util.Scanner;

public class P13305_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long[] dist = new long[n-1];
		long[] prices = new long[n];
		
		for(int i=0; i<dist.length; i++) {
			dist[i]= sc.nextLong();
		}
		
		for(int i=0; i<prices.length; i++) {
			prices[i]=sc.nextLong();
		}
		
		long minPrice = prices[0];
		long sum=0;
		
		for(int i=0; i<n-1; i++) {
			if(minPrice>prices[i]) {
				minPrice=prices[i];
			}
			
			sum+=dist[i]*minPrice;
		}
		
		System.out.println(sum);

	}

}
