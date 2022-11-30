package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 백준 알고리즘 2667번 단지번호붙이기 문제 - dfs를 활용하여 풀이 

public class ComplexLabelling {
	
	public static int n;
	public static int count;
	public static int[][] arr;
	public static boolean[][] visit;
	public static int[] xD = {1,0,-1,0};
	public static int[] yD = {0,-1,0,1};
	public static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		visit = new boolean[n][n];
		
		for(int i =0; i<n; i++) {
			//st = new StringTokenizer(br.readLine(),"");
			String line = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j]=Character.getNumericValue(line.charAt(j));
			}
		}
		
		br.close();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				count=0;
				dfs(i,j);
				if(count>0) {
					list.add(count);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
	
	public static void dfs(int i, int j) {
		if(arr[i][j]==1 && !visit[i][j]) {
			visit[i][j]=true;
			count++;
			
			for(int k=0; k<4; k++) {
				int nextX = i+xD[k];
				int nextY = j+yD[k];
				
				if(nextX<0 || nextX>=n || nextY<0 || nextY>=n) {
					continue;
				}
				
				dfs(nextX, nextY);
			}
			
			
		}
		
	}

}
