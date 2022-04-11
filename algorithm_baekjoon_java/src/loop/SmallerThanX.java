package loop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmallerThanX {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		
		List<Integer> a = new ArrayList<>();
		//int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			int numbers = sc.nextInt();
			a.add(numbers);
			//arr[i]=sc.nextInt();
		}
		
		for(int j=0; j<a.size(); j++) {
			if(a.get(j)<x) {
				System.out.print(a.get(j)+" ");
			}
			//if(arr[j]<x) {
			//	System.out.print(arr[j]+" ");
			//}
		}
	}

}
