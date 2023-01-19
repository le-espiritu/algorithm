package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1966 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] arr;
		Queue<Docu> qu;
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			arr=new int[n];
			qu=new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[j]=Integer.parseInt(st.nextToken());
				qu.add(new Docu(j,arr[j]));
			}
			
			int goalOrder = arr[m];
			
			Arrays.sort(arr);
			int idxForMax = arr.length-1;
			int maxOrder = arr[idxForMax];
			
			int count=0;
			
			while(true) {
				Docu nowDocu = qu.poll();
				if(nowDocu.order==goalOrder && nowDocu.idx==m) {
					if(nowDocu.order==maxOrder) {
						count++;
						//System.out.println(count);
						sb.append(count+"\n");
						break;
					}
					qu.add(nowDocu);
				}else if(nowDocu.order<maxOrder) {
					qu.add(nowDocu);
				}else if(nowDocu.order==maxOrder) {
					maxOrder = arr[--idxForMax];
					count++;
				}
				
			}
		}
		
		System.out.println(sb);

	}
	
	public static class Docu{
		int idx;
		int order;
		
		public Docu(int idx, int order) {
			this.idx=idx;
			this.order=order;
		}
	}

}
