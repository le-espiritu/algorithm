package level2;

// 프로그래머스 알고리즘 레벨 2 예상 대진표 문제 풀이   

public class ExpectedTournament {
	public static void main(String[] args) {
		int n =8;
		int a = 2;
		int b = 3;
		
		int answer = solution(n,a,b);
		
		System.out.println(answer);

	}
	
	public static int solution(int n, int a, int b) {
		int answer =0;
		
		boolean flag = true;
		
		while(flag) {
			
			if(a-b==1||a-b==-1) {
				int sum=a+b;
				if((sum/2)%2!=0){
					answer++;
					return answer;
				}
			}
			
			a=(int)(Math.floor((a+1)/2)); // Math.ceil() 은 올림. round()는 반올림 floor()는 내림  
			b=(int)(Math.floor((b+1)/2));
			
			answer++;
			
		}
		
		return answer;
	}
	
	
	// 다른 분들의 풀이 방법  
	public static int solution2(int n, int a, int b) {
		int round = 0;
        while(a != b) // a와 b가 같다는건 대진표에서 둘이 만났다는 뜻이다. 둘 중 어떤게 이겨도 동일한 번호를 부여받기 때문이다.
        {
            a = a/2 + a%2; // 다음 라운드에서 a의 번호를 구하는 식 
            b = b/2 + b%2; // 다음 라운드에서 b의 번호를 구하는 식  
            round++;
        }
        return round;
	}
	
	// 위 코드를 아래코드와 함께 보면 이해가 쉬워진다. 
	public static int solution3(int n, int a, int b) {
		int answer =0;
		while(true) {
			a = a/2 + a%2;
			b = b/2 + b%2;
			answer++;
			if(a == b) {
				break;
			}
		}
		
		return answer;
	}

}
