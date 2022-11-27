package levle1;

// 프로그래머스 알고리즘 레벨1 짝수와 홀수 문제 풀이 

public class EvenAndOddNumbers {
	public static void main(String[] args) {
		int num=0;
		String answer = solution(num);
		System.out.println(answer);

	}
	
	public static String solution(int num) {
		String answer="";
		
		if(num%2==0) {
			answer="Even";
		}else {
			answer="Odd";
		}
		
		return answer;
	}
	
	// 다른 분의 풀이 : 삼항 연산자 사용  
	public static String solution2(int num) {
		return num%2==0? "Even" : "Odd";
	}

}
