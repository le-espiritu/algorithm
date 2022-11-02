package level2;

// 프로그래머스 level2 알고리즘 숫자의 표현 문제  

public class NumberExpression {
	public static void main(String[] args) {
		int n = 15;
		int answer = solution(n);
		System.out.println(answer);

	}
	
	public static int solution(int n) {
		int answer =0;
		
		for(int i =1; i<=n; i++) {
			int sum=i;
			int nextNum=i+1;
			while(sum<n) {
				sum=sum+nextNum;
				nextNum++;
			}
			if(sum==n) {
				answer++;
			}
		}
		return answer;
	}

}
