package level2;

import java.util.Stack;

// 프로그래머스 알고리즘 레벨2 괄호 회전하기 문제 풀이 


public class BracketRotation {
	public static void main(String[] args) {
		String s= "[](){}";
		int answer=solution(s);
		System.out.println(answer);

	}
	
	public static int solution(String s) {
		int answer = 0;
		
		StringBuilder sb = new StringBuilder(s);
		Stack<Character> stack = new Stack<Character>();
		
		for(int x=0; x<s.length(); x++) {
			for(int idx=0; idx<s.length(); idx++) {
				Character ch = s.charAt(idx);
				switch(ch) {
					case ']':
						if(!(stack.isEmpty()) && stack.peek()=='[') {
							stack.pop();
						}else {
							stack.push(']');
						}
						
						break;
					case ')':
						if(!(stack.isEmpty()) && stack.peek()=='(') {
							stack.pop();
						}else {
							stack.push(')');
						}
						
						break;
					case '}':
						if(!(stack.isEmpty()) && stack.peek()=='{') {
							stack.pop();
						}else {
							stack.push('}');
						}
						
						break;
					default :
						stack.push(ch);
				}
			}
			
			if(stack.isEmpty()) {
				answer++;
			}
			
			stack.clear();
			
			Character chForRotation = s.charAt(0);
			sb.deleteCharAt(0);
			sb.append(chForRotation);
			s=sb.toString();
			
		}
		return answer;
	}

}
