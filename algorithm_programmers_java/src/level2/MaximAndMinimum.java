
package level2;

import java.util.Scanner;

public class MaximAndMinimum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		String answer = solution(s);
		System.out.println(answer);
		sc.close();
		
	}
	
	public static String solution(String s) {
		String[] arrS = s.split(" ");
		
		int max = Integer.parseInt((arrS[0]));
		int min = Integer.parseInt((arrS[0]));
		
		for(int i=1; i<arrS.length; i++) {
			int num = Integer.parseInt((arrS[i]));
			if(num>max) {
				max=num;
			}
			if(num<min) {
				min=num;
			}
		}
		String sMax = Integer.toString(max);
		String sMin = Integer.toString(min);
		
		String answer = sMin+" "+sMax;
		return answer;
	}

}
