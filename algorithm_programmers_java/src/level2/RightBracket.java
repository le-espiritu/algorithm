package level2;

import java.util.Stack;

// 프로그래머스 알고리즘 레벨2 올바른 괄호 문제 

public class RightBracket {
	public static void main(String[] args) {
		String s = ")()(";
		
		boolean b = solution(s);
		System.out.println(b);

	}
	
	//stack을 사용하는 풀이 방법 
	public static boolean solution(String s) {
		boolean answer = true;
		
		Stack<Character> st = new Stack<>();
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='(') {
				st.push('(');
			}else {
				if(st.empty()) {
					answer=false;
				}else {
					st.pop();
				}
				
			}
		}
		
		if(!st.empty()) {
			answer=false;
		}
		return answer;
	}
	
	// stack을 쓰지 않는 풀이 방법 
	public static boolean solution2(String s) {
		boolean answer = true;
		
		int count=0;
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='(') {
				count++;
			}else {
				if(count==0) {
					answer=false;
				}else {
					count--;
				}
			}
		}
		
		if(count!=0) {
			answer=false;
		}
		
		return answer;
	}

}
