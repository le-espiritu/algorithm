package level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 프로그래머스 레벨2 영어 끝말잇기 알고리즘

public class WordChainGame {
	public static void main(String[] args) {
		int n = 2;
		String[] words = {"hello", "one", "even", "never", "riverw", "world", "draw"};
		//String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
		int[] answer = solution(n,words);
		
		System.out.println("["+answer[0]+","+answer[1]+"]");

	}
	
	public static int[] solution(int n, String[] words) {
		int[] answer= {0,0};
		
		int arrIdx=0;
		int turn=0;
		
		boolean flag = true;
		
		while(flag) {
			turn++;
			for(int i=1; i<=n; i++) {
				
				if(arrIdx==words.length) {
					break;
				}
				
				if(arrIdx!=0) {
					if(words[arrIdx].charAt(0)!=words[arrIdx-1].charAt(words[arrIdx-1].length()-1)) {
						answer[0]=i;
						answer[1]=turn;
						return answer;
					}
					
					
					else if(Arrays.asList(words).indexOf(words[arrIdx])!=arrIdx) {
						answer[0]=i;
						answer[1]=turn;
						return answer;
					}
				}

				arrIdx++;
			}
			if(arrIdx==words.length) {
				break;
			}
		}
		

		return answer;
	}
	
	
	
	
	
	// 다른 분의 알고리즘 - set 인터페이스 사용 
	public int[] solution2(int n, String[] words) {

        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        char lastChar = words[0].charAt(words[0].length() - 1);
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            int now = i % n; // 전체 인원수(n) 만큼 나눈 나머지를 통해 사람의 번호를 구할 수 있다. 그리고 words[0]때문에 +1 해줌 
            int turn = i / n;
            String word = words[i];
            if (word.charAt(0) != lastChar || set.contains(word)) { // set은 데이터를 찾을 때  O(1)시간 복잡도를 가져  O(n) 시간 복잡도를 가지는  List를 사용하는 것보다 성능이 더 좋다. 
                answer[0] = now + 1; // words[0]때문에 +1 해줌 
                answer[1] = turn + 1; // words[0]때문에 +1 해줌 
                break;
            }
            set.add(word);
            lastChar = word.charAt(word.length() - 1);
        }

        return answer;
    }

}
