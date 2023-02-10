package greedy;

import java.util.Scanner;

public class P1789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long s = sc.nextLong();
		
		long num=0;
		long n=0;
		long sum=0;
		
		while(true) {
			
			long rs = s-sum;
			
			if(rs==0) {
				break;
			}else if(rs>num) {
				num++;
			}else if(rs<=num) {
				break;
			}
			
			sum+=num;
			n++;
			
		}
		
		System.out.println(n);

	}

}
