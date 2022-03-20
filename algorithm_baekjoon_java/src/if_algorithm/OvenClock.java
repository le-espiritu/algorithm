package if_algorithm;

import java.util.Scanner;

public class OvenClock {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int cm = sc.nextInt();
		int sumM = m+cm;
		
		if(sumM<60) {
			System.out.println(h+" "+sumM);
		}else {
			if((h+(sumM/60))<24) {
				System.out.println((h+(sumM/60))+" "+(sumM%60));
			}else if((h+(sumM/60))==24) {
				System.out.println(0+" "+(sumM%60));
			}else {
				System.out.println(((h+(sumM/60))-24)+" "+(sumM%60));
			}
		}
	}

}
