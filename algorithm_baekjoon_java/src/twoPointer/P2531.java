package twoPointer;

import java.util.Scanner;

public class P2531 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int d = sc.nextInt();
		int k = sc.nextInt();
		int c = sc.nextInt();
		
		int[] chk = new int[d+1];
		chk[c]++;
		
		int[] arr = new int[n];
		
		for(int i=0; i<arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int i=0; i<k; i++) {
			int num = arr[i];
			chk[num]++;
		}
		
		int stP=0;
		int endP=k-1;
		int max =0;
		
		while(true) {
			int sum=0;
			for(int i=1; i<chk.length; i++) {
				if(chk[i]!=0) {
					sum++;
				}
			}
			
			max=Math.max(max, sum);
			
			chk[arr[stP]]--;
			stP=(stP+(n+1))%n;
			endP=(endP+(n+1))%n;
			
			if(endP==(k-1)) {
				break;
			}
			
			chk[arr[endP]]++;
		}
		
		System.out.println(max);
		

	}

}
