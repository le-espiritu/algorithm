package codingTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

// 가비아 코테 커피가 만들어지는 순서 문제 풀이 

public class GabiTest3 {

	public static void main(String[] args) {
		
		// 테스트 케이스 
		int[] arr = {4, 2, 2, 5, 3};
		int[] answer = solution(3, arr);
		
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i]);
		}

	}
	
	static int[] solution(int N, int[] coffee_times) {
		int m = coffee_times.length;
		
		int[] answer = new int[m];
		
		int idx=0; // answer에 답을 차례로 저장할 때 사용할 index;
		
		boolean[] chk = new boolean[m];
		
		ArrayList<Coffee> list = new ArrayList<>();
		PriorityQueue<Coffee> list2 = new PriorityQueue<>();
		
		while(true) {
			
			if(list.size()<N) {
				for(int i=0; i<m; i++) {
					if(chk[i]==false) {
						list.add(new Coffee(i+1,coffee_times[i]));
						chk[i]=true;
					}
				}
			}
			
			
			
			Iterator<Coffee> itr = list.iterator();
			while(itr.hasNext()) {
				Coffee coffee = itr.next();
				coffee.time--;
				if(coffee.time==0) {
					itr.remove();
					list2.add(coffee);
				}
			}
			
			//list2 정렬해줌 -> 우선순위 큐라서 이미 정렬되어있음  
			
			
			//최종 답에 넣기
			if(!list2.isEmpty()) {
				for(int i=0; i<list2.size(); i++) {
					answer[idx] = list2.poll().num;
					idx++;
				}
			}
			
			if(idx==m) {
				break;
			}
			
		}
		
		return answer;
	}
	
	static class Coffee implements Comparable<Coffee> {
		int num;
		int time;
		
		public Coffee(int num, int time) {
			this.num=num;
			this.time=time;
		}

		@Override
		public int compareTo(Coffee o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.num, o.num);
		}

	}

}
