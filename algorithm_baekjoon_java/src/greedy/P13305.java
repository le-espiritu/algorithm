package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13305 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 도시의 개수
		
		long[] dists = new long[n-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<dists.length; i++) {
			dists[i]= Long.parseLong(st.nextToken());
		}
		
		long[] prices = new long[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<prices.length; i++) {
			prices[i]=Long.parseLong(st.nextToken());
		}
		
		int minPriceIdx =0;
		
		long minPrice=0;
		
		for(int i=0; i<n-1; i++) {
			minPrice += dists[i]*prices[minPriceIdx];
			if(prices[minPriceIdx]>prices[i+1]) {
				minPriceIdx=i+1;
			}
		}
		
		System.out.println(minPrice);

	}

}
