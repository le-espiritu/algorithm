package backTracking;

import java.util.Scanner;

public class P1182 {

	public static int n;
	public static int s;
	public static int[] arr;
	public static int sum=0;
	public static int count=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		
		arr=new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		bt(0);
		
		System.out.println(count);

	}
	
	public static void bt(int idx) {
		for(int i=idx; i<arr.length; i++) {
			sum += arr[i];
			if(sum==s) {
				count++;
			}
			bt(i+1);
			sum -= arr[i];
		}
	}

}
