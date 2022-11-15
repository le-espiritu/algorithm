package array;

import java.util.Scanner;

// 백준 알고리즘 1차원 배열 5597번 문제 과제 안 내신 분..? 문제 풀이
// 교수님이 내준 특별과제를 28명이 제출했는데, 그 중에서 제출 안 한 학생 2명의 출석번호를 구하는 프로그램을 작성하시오. 
// 입력은 총 28줄로 각 제출자(학생)의 출석번호 n(1 ≤ n ≤ 30)가 한 줄에 하나씩 주어진다. 출석번호에 중복은 없다.

public class Assignment {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[] checkArr = new boolean[31];
		
		for(int i =0; i<checkArr.length; i++) {
			checkArr[i]=false;
		}
		
		for(int i=0; i<28; i++) {
			int n = sc.nextInt();
			checkArr[n]=true;
		}
		
		for(int i=1; i<checkArr.length; i++) {
			if(checkArr[i]==false) {
				System.out.println(i);
			}
		}

	}

}
