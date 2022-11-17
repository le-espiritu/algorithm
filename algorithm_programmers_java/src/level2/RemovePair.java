package level2;

import java.util.Stack;

// 이 파일은 맥북 한글 포맷 기준인 utf-8로 인코딩 되어있다.
//프로그래머스 레벨2 짝지어 제거하기 알고리즘 풀이  

public class RemovePair {
	public static void main(String[] args) {
		String s = "baabaa";
		int answer = solution(s);
		System.out.println(answer);

	}
	
	
	//효율성까지 고려한 알고리즘 -> stack을 사용함
	public static int solution(String s) {
		int answer=0;
		
		Stack<Character> st = new Stack<>(); // 객체형태만 담을 수 있음. 기본형 타입 담을 수 없음.
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(!st.isEmpty() && st.peek()==c) { // stack의 peek()메서드는 스택에서 top에 있는 데이터를 반환한다.
				st.pop();
			}else {
				st.push(c);
			}
		}
		
		answer = (st.isEmpty()) ?  1:0;
		// 또는  answer = (st.size()==0) ? 1:0;
		
		return answer;
	}
	
	
	// 효율성 통과되지 못한 코드
	public static int mySolution(String s) {
		
		StringBuilder sb = new StringBuilder(s);
		int answer = 0;
		boolean flag=true;
		
		while(flag) {
			int removeCount=0;
			for(int i=0; i<sb.length()-1; i++) {
				if(sb.charAt(i)==sb.charAt(i+1)) {
					sb.delete(i, i+2);
					removeCount++;
				}
			}
			if(sb.length()==0) {
				answer=1;
				flag=false;
			}
			if(removeCount==0) {
				answer=0;
				break;
			}
		}
		
		return answer;
		
		
	}

}
