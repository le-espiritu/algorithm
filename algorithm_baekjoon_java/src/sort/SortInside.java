package sort;

import java.util.Scanner;

// 백준 알고리즘 1427번 소트인사이드 문제 
// String.toCharArray() 메소드를 활용할 수도 있다.
// 이는 문자열을 한 글자씩 쪼개서 char타입의 배열에 집어넣어주는 메소드이다.
// String s1 = "hello"
// char[] charArr = s1.toCharArray();

public class SortInside {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String strN = Integer.toString(n);
		String[] strNArr = strN.split("");
		int[] arr = new int[strNArr.length];
		
		for(int i =0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(strNArr[i]);
		}
		
		for(int i =0; i<arr.length; i++) {
			int v = arr[i];
			int j;
			for(j=i-1; j>=0; j--) {
				if(arr[j]<v) {
					arr[j+1]=arr[j];
				}else {
					break;
				}
			}
			
			arr[j+1]=v;
			
		}
		
		for(int i =0; i<arr.length; i++) {
			System.out.print(arr[i]);
		}

	}

}
