package level2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// 프로그래머스 알고리즘 레벨2 위장 문제 풀이 

public class Camouflage {
	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		int answer = solution(clothes);
		System.out.println(answer);
		

	}
	
	public static int solution(String[][] clothes) {
		int answer = 1;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(String[] cloth : clothes) {
			map.put(cloth[1], map.getOrDefault(cloth[1], 0)+1);
		}
		
		Iterator<Integer> I = map.values().iterator();
		
		while(I.hasNext()) {
			answer *=(I.next().intValue()+1);
		}
		
		return answer-1;
	}
	
	
	//다른 분들 풀이 방법  
	public int solution2(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String key = clothes[i][1];
            if(!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        Iterator<Integer> it = map.values().iterator();
        while(it.hasNext()) {
            answer *= it.next().intValue()+1;
        }
        return answer-1;
    }
	

}
