package sort;

import java.util.Scanner;

// 백준 알고리즘 정렬 11651번 좌표 정렬하기2 문제 
// 2차원 평면 위의 점 N개가 주어진다. 
// 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

public class CoordinateSort2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		String[] arr = new String[n];
		
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextLine();
		}
		
		for(int i=0; i<arr.length; i++) {
			String[] strV = arr[i].split(" ");
			int vx = Integer.parseInt(strV[0]);
			int vy = Integer.parseInt(strV[1]);
			int j;
			for(j=i-1; j>=0; j--) {
				String[] strV2 = arr[j].split(" ");
				int vx2 = Integer.parseInt(strV2[0]);
				int vy2 = Integer.parseInt(strV2[1]);
				if(vy2>vy) {
					arr[j+1]=arr[j];
				}else if(vy2==vy) {
					if(vx2>vx) {
						arr[j+1]=arr[j];
					}
				}else {
					break;
				}
			}
			
			arr[j+1]=arr[i];
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

}
