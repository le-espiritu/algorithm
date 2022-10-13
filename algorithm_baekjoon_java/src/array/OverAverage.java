package array;

import java.util.Scanner;

//백준 4344번 문제 평균은 넘겠지를 풀이한 코드  

public class OverAverage {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		
		double[] results = new double[c];
		
		for(int i =0; i<c; i++) {
			int n = sc.nextInt();
			int sum =0;
			int[] scores = new int[n];
			int overStudentsNum =0;
			for(int j=0; j<n; j++) {
				scores[j] = sc.nextInt();
				sum = sum+scores[j];
			}
			int average = sum/n;
			for(int h=0; h<n; h++) {
				if(scores[h]>average) {
					overStudentsNum++;
				}
			}
			double overRatio = (double)overStudentsNum/(double)n*100;
			results[i] = overRatio;
		}
		
		for(int g=0; g<c; g++) {
			System.out.printf("%.3f%%%n",results[g]);
			
		}

	}

}
