package stringAlgorithm;

import java.util.Scanner;

// 백준 2941번 문제 크로아티아 알파벳 갯수 세기 

public class CroatiaAlphabet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		StringBuilder sb = new StringBuilder(word);
		int count =0;
		
		while(word.contains("c=")) {
			int idx = word.indexOf("c=");
			sb.replace(idx, idx+2,"0");
			word=sb.toString();
			count++;
		}
		
		while(word.contains("c-")) {
			int idx = word.indexOf("c-");
			sb.replace(idx, idx+2,"0");
			word=sb.toString();
			count++;
		}
		
		while(word.contains("dz=")) {
			int idx = word.indexOf("dz=");
			sb.replace(idx, idx+3,"0");
			word=sb.toString();
			count++;
		}
		
		while(word.contains("d-")) {
			int idx = word.indexOf("d-");
			sb.replace(idx, idx+2,"0");
			word=sb.toString();
			count++;
		}
		
		while(word.contains("lj")) {
			int idx = word.indexOf("lj");
			sb.replace(idx, idx+2,"0");
			word=sb.toString();
			count++;
		}
		
		while(word.contains("nj")) {
			int idx = word.indexOf("nj");
			sb.replace(idx, idx+2,"0");
			word=sb.toString();
			count++;
		}
		
		while(word.contains("s=")) {
			int idx = word.indexOf("s=");
			sb.replace(idx, idx+2,"0");
			word=sb.toString();
			count++;
		}
		
		while(word.contains("z=")) {
			int idx = word.indexOf("z=");
			sb.replace(idx, idx+2,"0");
			word=sb.toString();
			count++;
		}
		
		for(int i=0; i<sb.length(); i++) {
			if(!(Character.toString(sb.charAt(i)).equals("0"))) {
				sb.replace(i,i+1,"0");
				count++;
			}
		}
		
		System.out.println(count);

	}

}
