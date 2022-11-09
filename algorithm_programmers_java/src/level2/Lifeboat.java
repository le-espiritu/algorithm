package level2;

import java.util.Arrays;

// 프로그래머스 레벨2 구명보트 알고리즘 

public class Lifeboat {
	public static void main(String[] args) {
		int[] people = {70, 80, 50};
		int limit = 100;
		
		int answer = solution(people,limit);
		
		System.out.println(answer);

	}
	
	
	public static int solution(int[] people, int limit) {
		int answer =0;
		
		Arrays.sort(people);
		
		int peopleNum = people.length;
		int firstIdx =0;
		int lastIdx =people.length-1;
		
		while(peopleNum!=0) {
			if(firstIdx==lastIdx) {
				answer++;
				break;
			}
			if(people[lastIdx]+people[firstIdx]<=limit) {
				peopleNum = peopleNum-2;
				firstIdx++;
				lastIdx--;
			}else {
				peopleNum --;
				lastIdx--;
			}
			
			answer++;
		}
		return answer;
	}
	
	
	
	
	// 다른 분의 풀
	public static int solution2(int[]people,int limit) {
		
		Arrays.sort(people); //오름차순으로 정렬
		
        int i = 0, j = people.length - 1; // i는 첫번째 인덱스부터 올라가는 인덱스, j는 끝에서 부터 내려오는 인덱
        
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }
        return people.length - i;
        
        // 보트가 최대로 많이 필요한 갯수는 사람의 수(people.length) 만큼이다.
        // 그러나 2명이 같이 타게되면, 2명이 같이 탄 횟수 만큼 보트의 갯수가 줄어들 수 있다.
        // i는 인덱스를 나타내줌과 동시에 2명이 같이 탄 횟수를 나타내주기도 한다.
        // 그렇기 때문에 people.length -i를 해줘서 최소 보트 갯수를 구하는 것이다. 
	}

}
