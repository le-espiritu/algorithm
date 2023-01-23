package backTracking;

import java.util.Scanner;

public class P14888 {
	
	public static int n;
	public static int[] numbers;
	public static int[] operators; 
	
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		n= sc.nextInt();
		numbers=new int[n];
		
		for(int i=0; i<n; i++) {
			numbers[i]=sc.nextInt();
		}
		
		
		operators=new int[4];
		for(int i=0; i<4; i++) {
			operators[i]=sc.nextInt();
		}
		
		bt(numbers[0],1);
		
		System.out.println(max);
		System.out.println(min);

	}
	
	public static void bt(int num, int idx) {
		
		if(idx==n) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(operators[i]>0) {
				operators[i]--;
				
				if(i==0) {
					//num+=numbers[idx]; 백트래킹 특성상 이렇게 변수 값을 변형시켜주면 안됨  
					// 왜냐하면 되돌아봐서 num값을 다시 활용하기 때문에  
					int result = num+numbers[idx];
					bt(result,idx+1);
				}
				else if(i==1) {
					int result = num-numbers[idx];
					bt(result,idx+1);
				}
				else if(i==2) {
					int result = num*numbers[idx];
					bt(result,idx+1);
				}
				else if(i==3) {
					int result = num/numbers[idx];
					bt(result,idx+1);
				}
				operators[i]++;
			}
		}
		
	}
	
}
