package level2;

//프로그래머스 이진 변환 반복하기 알고리즘 풀이  

public class BinaryTransformation {
	public static void main(String[] args) {
		
		String s = "110010101001";
		int[] answer = solution(s);
		System.out.println("["+answer[0]+","+answer[1]+"]");

	}
	public static int[] solution(String s) {
		int[] answer = new int[2];
		
		StringBuilder sb = new StringBuilder(s);
		
		int zeroCount=0;
		int btCount=0;
		
		while(sb.length()!=1) {
			while((sb.toString()).contains("0")) {
				int i = (sb.toString()).indexOf("0");
				sb.delete(i, i+1);
				zeroCount++;
			}
			String binaryString = Integer.toBinaryString(sb.length()); 
			sb.setLength(0);
			sb=new StringBuilder(binaryString);
			btCount++;
		}
		
		answer[0]=btCount;
		answer[1]=zeroCount;
		
		return answer;
	}
	
	
	//다른 분들의 풀이   
	public static int[] solution2(String s) {
		int[] answer = new int[2];
        int temp;
        while( !s.equals("1") ) {
            answer[1] += s.length();
            s = s.replaceAll("0", "");
            temp = s.length();
            s = Integer.toBinaryString(temp);
            //System.out.println("s : " + s ); 
            answer[0]++;
            answer[1] -= temp;
        }
        return answer;  
	}

}
