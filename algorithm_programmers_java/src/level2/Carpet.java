package level2;

//프로그래머스 레벨2 알고리즘 카펫 문제 

public class Carpet {
	public static void main(String[] args) {
		int brown = 24;
		int yellow = 24;
		
		int[] answer = solution(brown,yellow);
		
		System.out.println("["+answer[0]+","+answer[1]+"]");

	}
	
	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		
		for(int i=1; i<=yellow; i++) {
			if((yellow%i)==0) {
				int yellW=yellow/i;
				if(((yellW*2)+(i*2)+4)==brown) {
					answer[0]=yellW+2;
					answer[1]=i+2;
					break;
				}
			}
		}
		return answer;
	}

}
