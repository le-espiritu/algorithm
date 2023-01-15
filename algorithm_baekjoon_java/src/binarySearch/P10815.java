package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10815 {
	
	public static int[] cards;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		cards = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			cards[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cards);
		
		StringBuilder sb = new StringBuilder();
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			int target = Integer.parseInt(st.nextToken());
			int rs = bs(0,n-1,target);
			sb.append(rs+" ");
		}
		
		System.out.println(sb);

	}
	
	public static int bs(int start, int end, int target) {
		if(start==end) {
			if(cards[start]==target) {
				return 1;
			}else {
				return 0;
			}
		}
		
		int mid = (start+end)/2;
		
		if(target<=cards[mid]) {
			return bs(start,mid,target);
		}else {
			return bs(mid+1,end,target);
		}
	}

}
