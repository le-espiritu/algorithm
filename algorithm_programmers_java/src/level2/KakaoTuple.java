package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 프로그래머스 알고리즘 레벨2 튜플 문제 풀

public class KakaoTuple {
	public static void main(String[] args) {
		
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		int[] answer = solution(s);
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}

	}
	
	public static int[] solution(String s) {
		
		
		StringBuilder sb = new StringBuilder(s);
		sb.delete(0,2);
		sb.delete(s.length()-4,s.length()-1);
		String sb2 = (sb.toString());
		sb2=sb2.replace("},{", " ");
		
		String[] strArr = sb2.split(" ");
		
		int[] answer = new int[strArr.length];
		Set<Integer> set = new HashSet<Integer>(); 
		// set은 순서를 지켜줘야해서 사용못할 줄 알았지만 아래 int idx때문에 사용할 수 있게됨. 시간복잡도 면에서는 set을 활용하는게 나음  
		//List<Integer> list = new ArrayList<Integer>();
		
		
		Arrays.sort(strArr, Comparator.comparing(String::length));
		
		int idx =0;
		
		for(String strEl : strArr ) {
			String[] emp = strEl.split(",");
			for(int i =0; i<emp.length; i++) {
				int num = Integer.parseInt(emp[i]);
				if(!set.contains(num)) {
					set.add(num);
					answer[idx]=num;
					idx++;
					
				}
				
			}
		}
		
		
		return answer;
	}
	
	
	// 다른분이 푸신 풀이 
	public int[] solution2(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }

}
