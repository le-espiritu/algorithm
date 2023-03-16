package codingTest;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class GabiTest1 {

	public static void main(String[] args){
		
		//String[] strings ={"alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300", "cheries2 110"};
		// k = 3
		
		String[] strings = {"alex111 100", "cheries2 200", "alex111 200", "cheries2 150", "coco 50", "coco 200"};
		// k= 3
		
		//String[] strings = {"cheries2 200", "alex111 100", "coco 150", "puyo 120"};
		// k=2
		int answer = solution(3,strings);
		
		System.out.println(answer);
		
	}
	
	static int solution(int k, String[] user_scores) {
		//한페이지에 k명씩 닉네임을 보여줌 
		int answer =0;
		
		int m = user_scores.length;
		
		LinkedList<Report> list = new LinkedList<>();
		for(int i=0; i<m; i++) {
			list.add(i, null);
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(user_scores[i]);
			String name = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			
			boolean isReplaced = false;
			
			for(int j=0; j<k; j++) {
				if(list.get(j)==null) { // 리스트가 비어있는 경우 
					list.add(j,new Report(name,score));
					answer++;
					break;
				}else { // 리스트가 비지 않은 경우 
					Report r = list.get(j);
					
					if(score>r.score) {
						if(!name.equals(r.name)) { // 이름이 같지 않은 경우 
							list.add(j, new Report(name, score));
							isReplaced=true;
							answer++;
							
						}else { // 이름이 같은 경우 
							r.score=score;
						}
						
						break;
					}
					
					
				}
			}
			
			
		}
		
		return answer;
		
	}
	
	static class Report{
		String name;
		int score;
		
		public Report(String name, int score) {
			this.name=name;
			this.score=score;
		}
	}
	

}
