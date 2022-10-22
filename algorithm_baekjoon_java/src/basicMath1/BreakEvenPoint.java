package basicMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1712번 문제 손익분기점 구하는 문제 

public class BreakEvenPoint {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long fixedCost = Long.parseLong(st.nextToken());
		long variableCost = Long.parseLong(st.nextToken());
		long computerPrice = Long.parseLong(st.nextToken());
		
		long count=0;
		
		if(computerPrice<=variableCost) {
			count=-1;
		}else {
			count=fixedCost/(computerPrice-variableCost)+1;
			
		}
		
		System.out.println(count);
		
	

	}

}
