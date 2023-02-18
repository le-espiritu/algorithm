package backTracking;

import java.util.Scanner;

public class P1182_2 {
	
	public static int n;
	public static int s;
	public static int[] arr;
	public static int count=0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		s = sc.nextInt();
		
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		bt(0,0);
		if(s==0) {
			System.out.println(count-1);
		}else {
			System.out.println(count);
		}

	}
	
	public static void bt(int depth, int sum) {
		if(depth==n) {
			if(sum==s) {
				count++;
			}
			return;
		}
		
		bt(depth+1,sum+arr[depth]);
		bt(depth+1,sum);
	}

}
