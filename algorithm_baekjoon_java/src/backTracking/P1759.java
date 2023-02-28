package backTracking;

import java.util.Arrays;
import java.util.Scanner;

public class P1759 {
	
	public static int l;
	public static int c;
	public static char[] alphabets;
	public static char[] answer;
	public static StringBuilder sb = new StringBuilder();
	
	public static int vowelCount=0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		l = sc.nextInt();
		c = sc.nextInt();
		
		sc.nextLine();
		
		String line = sc.nextLine();
		String[] alphas = line.split(" ");
		
		alphabets=new char[c];
		
		for(int i=0; i<c; i++) {
			alphabets[i]=alphas[i].charAt(0);
		}
		
		Arrays.sort(alphabets);
		
		answer=new char[l];
		
		bt(0,0);
		
		System.out.println(sb.toString());

	}
	
	public static void bt(int idx, int depth) {
		if(depth==l) {
			
			if(vowelCount>0 && vowelCount<=l-2) {
				for(int i=0;i<answer.length; i++) {
					sb.append(answer[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		for(int i=idx; i<alphabets.length; i++) {
			
			answer[depth]=alphabets[i];
			
			if(answer[depth]=='a' || answer[depth]=='e' || answer[depth]=='i' || answer[depth]=='o'||answer[depth]=='u') {
				vowelCount++;
				bt(i+1,depth+1);
				vowelCount--;
			}
			else {
				bt(i+1,depth+1);
			}
		}
	}

}
