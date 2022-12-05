package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 알고리즘 2559번 수열 문제 - 투포인터 활용하여 풀이 
/*
1. 아이디어
- 투포인터를 활용
- for문으로, 처음에 k개 값을 저장
- 다음 인덱스를 더해주고, 이전 인덱스 빼줌
- 이때마다 최대값을 갱신

2. 시간복잡도
- O(N) = 1e5 > 가능 -> 문제에서 N의 최대값은 10만이었고, 따라서 2억 미만이기때문에 가능
- 원래 O(2N)이다. (n개 만큼 다음 인덱스를 더해주고 이전 인덱스를 빼주는 2번의 작업을 해주기 때문)
- 그러나 시간복잡도에서 상수는 무시하기 때문에 O(N)의 시간복잡도가 되었다. 

3. 자료구조
- 각 숫자들 N개 저장 배열 : int[]
- 숫자들 최대 100 이기 때문에 int배열 가능

- k개를 더한 값을 저장하는 변수 : int 가능
- k*100(각 숫자들의 최대값) -> 10만(k의 최대값) * 100(각 숫자들의 최대값) = 1000만 => int의 최대값 21억 미만이니 가능 

- 최대값을 담는 변수 자료형  : int 
*/

public class Progression2559Two {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st=new StringTokenizer(br.readLine());
		for(int i =0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int sum=0;
		for(int i=0; i<k; i++) { // 처음 k값 만큼 합을 구함
			sum+=arr[i];
		}
		int maxV = sum;
		
		for(int i=k; i<n; i++) {
			sum+=arr[i]; // 처음 구한 합에 다음 인덱스를 더해줌
			sum-=arr[i-k]; // 처음 구한 합에서 처음 인덱스를 빼줌.
			maxV = Math.max(maxV, sum); // 새로 구한 합과 최대값 비교하여 최대값 경신
		}
		
		System.out.println(maxV);

	}

}
