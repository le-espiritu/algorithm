package greedy;

import java.util.Scanner;

public class P10162 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		int[] buttons= {300,60,10};
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<buttons.length; i++) {
			int count = t/buttons[i];
			sb.append(count+" ");
			t=t%buttons[i];
		}
		
		if(t!=0) {
			System.out.println(-1);
		}else {
			System.out.println(sb);
		}

	}

}
