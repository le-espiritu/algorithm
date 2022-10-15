package function;

import java.util.Scanner;

// 백준 1065번 문제 - 한수의 갯수 구하기  - 내 방식으로 풀어봄 - 시간이 좀 오래거릴고 메모리 용량도 비교적 크다. 
public class HanSu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int count =0;
		for(int i=1; i<=c; i++) {
			if(findHansu(i)) {
				count++;
			}
		}
		System.out.println(count);

	}
	public static boolean findHansu(int num) {
		boolean find = false;
		
		if(num<100) {
			find = true;
		}else {
			int n= num%10;
			num=num/10;
			int gap=num%10-n;
			while(num!=0) {
				n = num%10;
				num=num/10;
				if(num<10) {
					if(num-n == gap) {
						find = true;
						break;
					}
				}
				if(num%10-n == gap) {
					find = true;
				}else {
					find = false;
					break;
				}
				
			}
		}

		
		return find;
	}

}
