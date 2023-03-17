package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// 해당 문제는 이전에 연산한 값을 활용하기 때문에 
// 최소값을 구하기 위해서는 작은 값들을 먼저 연산해줘야 한다. 
// (큰값을 먼저 연산한다면 그 값을 이후에 다시 활용하기 때문에 최소값이 나올 수 없다.)
// 그렇다고 오름차순 정렬 후 순서대로 누적합을 활용하면 안된다. 
// 연산하여 나온 값이 아직 연산을 하지 않은 값보다 클 수도 있고 순서대로 누적합을 하면 이 큰 값을 먼저 연산하게 되기 때문이다.
// 따라서 항상 작은 값들을 먼저 계산하기 위해 '우선순위 큐'를 활용한다. 
// 참고 -> https://jangcenter.tistory.com/96

public class P1715 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		for(int i=0; i<n; i++) {
			pq.offer(sc.nextLong());
		}
		
		long minCount=0;
		
		while(pq.size()>1) {
			long cardSet1 = pq.poll();
			long cardSet2 = pq.poll();
			
			long sum = cardSet1+cardSet2;
			
			minCount+=sum;
			
			pq.offer(sum);
		}
		
		System.out.println(minCount);

	}

}
