package twoPointer;

import java.util.Scanner;

public class P2467 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		int[] answer = new int[2];
		
		int min=Integer.MAX_VALUE;
		int startP=0;
		int endP=n-1;
		
		while(startP<endP) {
			int sum=arr[startP]+arr[endP];
			int result = Math.abs(sum);
			if(result<min) {
				min=result;
				answer[0]=arr[startP];
				answer[1]=arr[endP];
			}
			
			if(sum>0) {
				endP--;
			}
			else if(sum<=0) {
				startP++;
			}
		}
		
		System.out.println(answer[0]+" "+answer[1]);

	}

}
