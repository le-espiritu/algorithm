package array;

import java.util.Scanner;

public class OX {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		
		//String.charAt() 문자열에서 문자 추출
		//String.subString() 문자열에서 문자 추출
		//String.subString(3) => 3번 인덱스 부터 뽑기
		//String.subString(2,4) => 2번 인덱스부터 4번 인덱스 전까지 뽑기  
		
		for(int i =0; i<num; i++) {
			int score =0;
			int count= 0;
			String str = sc.next();
			String[] strArr = str.split("");
			for(int j=0; j<strArr.length; j++) {
				if(strArr[j].equals("O")) {
					if(j==0 || strArr[j-1].equals("X")) {
						score ++;
						count = 0;
						count ++;
					}else {
						score += (count+1);
						count ++;
					}
				}
			}
			System.out.println(score);
		}

	}

}
