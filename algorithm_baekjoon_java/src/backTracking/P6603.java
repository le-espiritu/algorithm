package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6603 {
	
	public static int[] arr;
	public static int[] ansArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st= new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if(k==0) {
				break;
			}
			
			arr=new int[k];
			ansArr=new int[6];
			for(int i=0; i<arr.length; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			bt(0,0);
			System.out.println();
		}
		

	}
	
	public static void bt(int idx, int depth) {
		if(depth==6) {
			for(int i=0; i<ansArr.length; i++) {
				System.out.print(ansArr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		
		for(int i=idx; i<arr.length; i++) {
			ansArr[depth]=arr[i];
			bt(i+1,depth+1);
		}
	}

}
