package level2;

// 프로그래머스 알고리즘 레벨2 피보나치 수 문제 
// 피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다. 

public class FibonacciNumber {
	
	
	public static int preNum=1; // F(n-1)
	public static int preNum2=0; // F(n-2)
	public static int answer=0; // F(n-1) + F(n-2)
	
	public static void main(String[] args) {
		int n =5;
		int result = solution(n);
		System.out.println(result);

	}
	
	
	// 재귀 호출 대신 for문을 사용함 - 이러한 풀이 방식을 동적 계획법(Dynamic Programming) 이라고 함.
	public static int solution(int n) {
		
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		
		else {
			for(int i=2; i<=n; i++) {
				F(i);
			}
			return (answer%1234567);
		}
		
	}
	

	
	public static void F(int n) {
		
		answer= (preNum2+preNum)%1234567;
		preNum2=preNum;
		preNum=answer;
		
	}
	
	// 아래는 다름분의 풀이 
	// 조건이 2이상의 n이 입력되었을 때를 한정하므로,
	// n이 1이거나 0인 경우를 고려한 알고리즘은 아님. 
	public int solution2(int n) {
        int f0 = 0;
        int f1 = 1;
        int f2 = 1;
        for(int i = 2 ; i <= n ; i++) {
            f2 = f0 + f1;
            f0 = f1 % 1234567;
            f1 = f2 % 1234567;
        }

        return f2%1234567;
    }
	
	
	// 아래는 재귀함수 기법 
	public static int F2(int n) {
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		int result =F2(n-1)+F2(n-2);
		
		return result;
	}

}
