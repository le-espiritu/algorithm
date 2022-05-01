package array;

import java.util.Scanner;

public class CountNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int result = a*b*c;
		
		//String strResult = result+"";  아래와 동일  
		String strResult = Integer.toString(result);
		//System.out.println(strResult);
		
		String[] arrStrResult = strResult.split("");
		
		for(int j=0; j<=9; j++) {
			int count=0;
			for(int i =0; i<arrStrResult.length; i++) {
				int numberI = Integer.parseInt(arrStrResult[i]);
				if(numberI==j) {
					count++;
				}
			}
			System.out.println(count);
		}
		
		
	}

}
