package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 1541번 잃어버린 괄호 문제 - 그리디 알고리즘  

public class P1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strings1 = br.readLine().split("-");
		
		int sum=0;
		int firstSum=0;
		
		for(int i=0; i<strings1.length; i++) {
			int temp =0;
			
			String[] strings2 = strings1[i].split("\\+");
			
			for(int j=0; j<strings2.length; j++) {
				temp += Integer.parseInt(strings2[j]);
			}
			
			if(i==0) {
				firstSum=temp;
			}else {
				sum += temp;
			}
			
		}

		
		System.out.println(firstSum-sum);
	}

}
