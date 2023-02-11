package dp;

import java.util.ArrayList;
import java.util.Scanner;

public class P11053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		ArrayList<Integer> rs = new ArrayList<>();
		
		int pre = 0;
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			if(num>pre) {
				rs.add(num);
				pre=num;
			}
		}
		
		System.out.println(rs.size());

	}

}
