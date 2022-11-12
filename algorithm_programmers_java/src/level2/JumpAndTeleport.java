package level2;

// 프로그래머스 알고리즘 레벨2 점프와 순간 이동 문제 풀이  

public class JumpAndTeleport {
	public static void main(String[] args) {
		int n =5000;
		int answer = solution(n);
		System.out.println(answer);

	}
	
	public static int solution(int n) {
		int ans =0; //ans는 점프 횟수.
		
		while(n>0) {
			
			// 홀 수 번일때 점프를 한다.
			// 왜냐하면 계속 순간이동을 했다면 *2가 된다.
			// *2가 됐다면 2의 배수이고 이는 계속해서 짝수가 됨을 의미한다.
			// 그런데 주어진 수 n을 계속 2로 나누다가 홀수가 나왔다면 이는 홀수번에서 점프, 즉 *2를 하지 않고 +1을 했다는 의미이다.
			if(n%2==1) { //  홀수 번일때 점프를 한다.
				ans++;
				n-=1;
			}
			
			n=n/2;
			// 순간이동했을때 현재 이동 거리 *2가 되는데 *2 했을때 n보다 커지면 안된다 (즉 n과 같거나 작아야 한다.)
			// 그렇기 때문에 나누기 2를 해준다.
		}
		
		return ans;
	}

}
