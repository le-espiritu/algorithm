package level2;

import java.util.LinkedList;
import java.util.List;

// 프로그래머스 알고리즘 레벨2 캐시 문제 풀이
// 캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용한다.
// cache hit일 경우 실행시간은 1이다.
// cache miss일 경우 실행시간은 5이다.
// LRU 알고리즘은 https://j2wooooo.tistory.com/121 여기 설명을 보면 이해하기 쉽다.
// LRU 알고리즘은 가장 오랫동안 참조되지 않은 페이지를 교체하는 기법이다.

public class KakaoCache {
	public static void main(String[] args) {
		int cacheSize =0;
		//String[] cities= {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		//String[] cities= {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		String[] cities= {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		int answer = solution(cacheSize,cities);
		System.out.println(answer);

	}
	
	public static int solution(int cacheSize, String[] cities) {
		int answer =0;
		
		int cacheSzieForCount=cacheSize;
		
		List<String> list = new LinkedList<String>();
		
		for(int i=0; i<cities.length; i++) {
			String lowerCity = cities[i].toLowerCase();
			if(list.contains(lowerCity)) {
				answer++;
				list.remove(lowerCity);
				list.add(lowerCity);
			}else {
				if(cacheSzieForCount>0) {
					list.add(lowerCity);
					cacheSzieForCount--;
				}else if(cacheSzieForCount==0) {
					if(cacheSize>0) {
						list.remove(0);
						list.add(lowerCity);
					}
					
				}
				
				answer +=5;
			}
			
		}
		
		return answer;
	}

}
