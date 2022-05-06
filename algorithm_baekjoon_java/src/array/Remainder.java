package array;

import java.util.Scanner;

public class Remainder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		int count =0;
		boolean find = true;
		
		for(int i =0; i<10; i++) {
			arr[i]=(sc.nextInt()%42);
		}
		
		for(int i =0; i<10; i++) {
			for(int j =i+1; j<10; j++) {
				if(arr[i]==arr[j]) {
					find=false;
					break;
				}
			}
			if(find==true) {
				count++;
			}
			find=true;
			
		}
		
		System.out.println(count);
	}

}
