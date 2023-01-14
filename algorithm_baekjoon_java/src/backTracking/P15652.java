package backTracking;

import java.util.Scanner;

public class P15652 {
	
	public static int n;
	public static int m;
	
	public static int[] answer;
	public static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		answer=new int[m];
		sb=new StringBuilder();
		
		bt(1,0);
		
		System.out.println(sb);

	}
	
	public static void bt(int start, int depth) {
		if(depth ==m) {
			
			for(int i=0; i<answer.length; i++) {
				sb.append(answer[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<=n; i++) {
			
				answer[depth]=i;
				bt(i,depth+1);
			
			
		
		}
	}

}
