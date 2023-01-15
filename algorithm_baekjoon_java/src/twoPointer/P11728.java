package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11728 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] Aarr = new int[n];
		int[] Barr = new int[m];
		
		st=new StringTokenizer(br.readLine());
		for(int i =0; i<Aarr.length; i++) {
			Aarr[i]=Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<Barr.length; i++) {
			Barr[i]=Integer.parseInt(st.nextToken());
		}
		
		//int[] rsArr =new int[n+m];
		StringBuilder sb = new StringBuilder();
		
		int aP =0;
		int bP =0;
		//int rsP =0;
		
		while(true) {
			
			if(aP==n || bP==m) {
				break;
			}
			
			if(Aarr[aP]<Barr[bP]) {
				//rsArr[rsP]=Aarr[aP];
				sb.append(Aarr[aP]+" ");
				aP++;
			}else {
				//rsArr[rsP]=Barr[bP];
				sb.append(Barr[bP]+" ");
				bP++;
			}
			
			//rsP++;
		}
		
		while(aP<n) {
			//rsArr[rsP]=Aarr[aP];
			sb.append(Aarr[aP]+" ");
			//rsP++;
			aP++;
		}
		
		while(bP<m) {
			//rsArr[rsP]=Barr[bP];
			sb.append(Barr[bP]+" ");
			//rsP++;
			bP++;
		}
		
		System.out.println(sb);

	}

}
