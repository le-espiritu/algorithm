package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 알고리즘 15651 N과 M 3 문제 - 백트래킹  

public class P15651 {
	
	public static int n;
	public static int m;
	public static int[] rst;
	public static StringBuilder sb;
	// 반복적으로 출력하는 방법을 사용하지 않고 StringBuilder를 활용함 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		rst=new int[m];
		
		sb = new StringBuilder();
		bt(0);
		System.out.print(sb);

	}
	
	public static void bt(int depth) {
		if(depth==m) {
			//StringBuilder를 사용하지 않고 단순히 출력을 반복적으로 사용했을 경우 시간초과남 
			for(int k=0; k<rst.length; k++) {
				sb.append(rst[k]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=n; i++) {
			rst[depth]=i;
			bt(depth+1);
		}
	}

}
