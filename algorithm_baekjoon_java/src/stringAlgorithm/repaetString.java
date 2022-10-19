package stringAlgorithm;

import java.util.Scanner;

public class repaetString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<t; i++) {
			int r=sc.nextInt();
			String s = sc.next();
			String[] ss= s.split("");
			for(int j=0; j<ss.length; j++) {
				for(int g=1; g<=r; g++) {
					sb.append(ss[j]);
				}
				
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}

}
