package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 알고리즘 2559번 수열 문제 - 투포인터 활용하여 풀이 
// 처음 아이디어 : 각 원소마다 모든 값을 순회하여 풀이함 
// for문으로 각 숫자의 위치에서 이후 k개의 수를 더하고 최대값으로 갱신
// 시간 복잡도 : for문: O(N) 각 위치에서 K개의 값 더함 : O(K)
// 총 O(NK) 
// 해당 문제에서 해당풀이는 시간복잡도가 2억이 넘어가서 시간을 초과하기 때문에 적절하지 않다. 

public class Progression2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int max =0;
		for(int i =0; i<n-k; i++) {
			int sum=0;
			for(int j=0; j<k; j++) {
				sum += arr[i+j];
			}
			if(sum>max) {
				max=sum;
			}
		}
		
		System.out.println(max);

	}

}
