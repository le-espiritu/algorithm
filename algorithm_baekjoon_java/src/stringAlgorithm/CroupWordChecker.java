package stringAlgorithm;
// 백준 알고리즘 1316번 문제 그룹 단어 체커 

import java.util.Scanner;

public class CroupWordChecker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count=0;
		
		for(int i=0; i<n; i++) {
			String word = sc.next();
			String[] wordSplit = word.split("");
			boolean gw = true; 
			
			if(word.length()<=2) {
				count++;
			}else {
				for(int j=0; j<wordSplit.length; j++) {
					
					for(int g=j+2; g<wordSplit.length; g++ ) {
						if(wordSplit[j].equals(wordSplit[g])) {
							if(!(wordSplit[g].equals(wordSplit[g-1]))) {
								gw=false;
								break;
							}
							
						}
					}
					
					if(!gw) {
						break;
					}
			
				}
				
				if(gw) {
					count++;
				}
			}
			
		}
		
		System.out.println(count);
		
	}

}
