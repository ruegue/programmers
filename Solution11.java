package level1;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution11 {
	
	public static String solution(String[] paticipant, String[] completion) {
		String answer ="";
		
		HashMap<String, Integer> map = new HashMap<>();
		
		
		for(String a : participant) {
			map.put(a, map.getOrDefault(a, 0)+1);
		}
		
		
		for(String a : completion) {
			map.put(a, map.get(a)-1);
		}
		
		
		Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
		
		while(iter.hasNext()) {
			Map.Entry<String, Integer> entry = iter.next();
			if(entry.getValue() != 0) {
				answer = entry.getKey();
				break;
			}
		}
		
		
		return answer;
	}

	public static void main(String[] args) {
		String[] paticipant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		String sol = solution(paticipant ,completion);
		
		System.out.println(sol);
	}

}
