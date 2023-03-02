package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2470 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<arr.length; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int[] answer=new int[2];
		
		int stP =0;
		int endP = n-1;
		int rs = Integer.MAX_VALUE;
		
		while(stP<endP) {
			int sum = arr[stP]+arr[endP];
			
			if(Math.abs(sum)<rs) {
				rs=Math.abs(sum);
				answer[0]=arr[stP];
				answer[1]=arr[endP];
				if(rs==0) {
					break;
				}
			}
			
			if(sum>0) {
				endP--;
			}else {
				stP++;
			}
		}
		
		Arrays.sort(answer);
		
		System.out.print(answer[0]+" "+answer[1]);

	}

}
