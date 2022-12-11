package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 알고리즘 11404번 플로이드 문제 풀이

/*
1.아이디어
- 모든점 -> 모든점 : 플로이드
- 비용배열 INF 로 초기화
- 간선의 비용 대입
- 거쳐서(경유하여) 비용 줄어들 경우, 갱신 (for문 3번)

2.시간복잡도
- 플로이드 :O(V^3)
- 1e6 -> 가능

3.변수
- 비용 배열 ,int[][]
*/

public class Floyd {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] dist = new int[n+1][n+1]; // 인덱스 좀더 편하게 사용하기 위해 +1해줌 
		for(int i =1; i<n+1; i++) {
			for(int j =1; j<n+1; j++) {
				if(i==j) {
					dist[i][j]=0;
				}else {
					dist[i][j]=100_000_000;
				}
			}
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			dist[a][b]=Math.min(dist[a][b], c);
			//dist[b][a]=Math.min(dist[b][a], c);
		}
		
		// 플로이드 알고리즘
		for(int k =1; k<n+1; k++) {
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		}
		
		//출력
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(dist[i][j]==100_000_000) {
					System.out.print(0+" ");
				}else {
					System.out.print(dist[i][j]+" ");
				}
			}
			System.out.println();
		}

	}

}
