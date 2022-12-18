package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 2606번 바이러스 문제 

public class Virus {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		
		List<Integer>[] net = new ArrayList[n+1];
		for(int i=0; i<net.length; i++) {
			net[i]=new ArrayList<Integer>();
		}
		
		boolean[] chk = new boolean[n+1];
		
		StringTokenizer st;
		for(int i=0; i<p; i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			net[a].add(b);
			net[b].add(a);
		}
		
		int count=0; // 감염 카운트에서 1은 제외하기 때문에 0으로 초기화 
		
		chk[1]=true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		while(!q.isEmpty()) {
			int nowcom = q.poll();
			for(int nextcom : net[nowcom]) {
				if(chk[nextcom]==false) {
					chk[nextcom]=true;
					q.offer(nextcom);
					count++;
				}
			}
		}
		
		System.out.println(count);

	}

}
