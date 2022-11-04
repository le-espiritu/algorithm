package level2;

// 프로그래머스 레벨2 알고리즘 다음 큰 숫자 문제 풀이 

public class NextBiggerNumber {

	public static void main(String[] args) {
		int n = 15;
		int answer = solution(n);
		System.out.println(answer);

	}
	
	public static int solution(int n) {
		
		int nCount=0;
		
		String nBinaryStr = Integer.toBinaryString(n);
		for(int i=0; i<nBinaryStr.length(); i++) {
			if(nBinaryStr.charAt(i)=='1') {
				nCount++;
			}
		}
		
		boolean find = false;
		
		while(!find) {
			n=n+1;
			int nCount2=0;
			String nBinaryStr2 = Integer.toBinaryString(n);
			for(int i=0; i<nBinaryStr2.length(); i++) {
				if(nBinaryStr2.charAt(i)=='1') {
					nCount2++;
				}
			}
			if(nCount2==nCount) {
				find = true;
			}
		}
		
		int answer=n;
		return answer;
	}
	
	
	// 다른 분의 풀이 - Integer.bitCount(int n) 메서드를 이용함. 
	// bitCount(int n)메서드는 n을 binary로 변환후 1의 개수를 리턴해준다. 
	public static int solution2(int n){
		int a = Integer.bitCount(n);
		int compare = n+1;
		
		while(true) {
			if(Integer.bitCount(compare)==a) {
				break;
			}
			compare++;
		}
		
		return compare;
	}

}
