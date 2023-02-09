package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2805 {
	
	public static int n;
	public static int m;
	public static int[] trees;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		trees= new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<trees.length; i++) {
			trees[i]= Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(trees);
		
		int high = trees[n-1];
		
		int result = bs(1,high+1,m);
		
		System.out.println(result);

	}
	
	public static int bs(int st, int hi, int target) {
		
		while(st<hi) {
			int mid = (st+hi)/2;
			
			long sum =0;
			for(int i=0; i<trees.length; i++) {
				if(mid>=trees[i]) {
					continue;
				}
				
				int rs = trees[i]-mid;
				sum+=rs;
			}
			
			if(sum<target) {
				hi=mid;
			}else {
				st=mid+1;
			}
		}
		
		return st-1;
	}

}
