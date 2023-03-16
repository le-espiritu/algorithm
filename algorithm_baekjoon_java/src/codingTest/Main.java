package codingTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args){
		
		String[] strings = {"cheries2 200", "alex111 100", "coco 150", "puyo 120"};
		int answer = solution(2,strings);
		
		System.out.println(answer);
		
	}
	
	static int solution(int k, String[] user_scores) {
		//한페이지에 k명씩 닉네임을 보여줌 
		int answer =0;
		
		HashMap<String, Integer> map = new HashMap<>();
		LinkedList<String[]> list = new LinkedList<>();
		
		for(int i=0; i<k; i++) {
			list.add(new String[] {"name","0"});
		}
		
		
		for(int i=0; i<user_scores.length; i++) {
			String element = user_scores[i];
			StringTokenizer st = new StringTokenizer(element);
			
			String name = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			
			if(map.get(name)==null) {
				map.put(name, score);
			}else if(map.get(name)>=score) {
				continue;
			}else {
				map.replace(name, score);
			}
			
			for(int j=0; j<k; j++) {
				if(map.get(name)>Integer.parseInt(list.get(j)[1])) {
					if(!list.get(j)[0].equals(name)) {
						list.add(j, new String[] {name,score+""});
						answer++;
						break;
					}
					
				} else if(map.get(name)==Integer.parseInt(list.get(j)[1])) {
					break;
				}
				
				if(list.get(j)[0].equals(name)) {
					break;
				}
				
			}
			
		}
		
		
		return answer;
		
	
	}
	

}
