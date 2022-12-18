package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 백준 2606번 바이러스 풀이 - dfs로 풀이  - 맞음 

public class Virus {
	
	public static int n;
	public static int p;
	public static List<Integer>[] list;
	public static boolean[] chk;
	public static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		p = Integer.parseInt(br.readLine());
		
		chk=new boolean[n+1];
		
		//인접리스트 생성
		list = new ArrayList[n+1];
		for(int i=0; i<list.length; i++) {
			list[i]=new ArrayList<>();
		}
		
		StringTokenizer st;
		for(int i=0; i<p; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		chk[1]=true;
		dfs(1);
		System.out.println(count);

	}
	
	public static void dfs(int nowcom) {
		
		boolean flag=false;
		for(int nextcom : list[nowcom]) {
			if(chk[nextcom]==false) {
				chk[nextcom]=true;
				count++;
				flag=true;
				dfs(nextcom);
			}
		}
		if(!flag) {
			return;
		}
	}

}
