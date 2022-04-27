package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution1 {
	
	public static int[] solution(String[] id_list, String[] report, int k) {
		
		ArrayList<String> suspendedUser = new ArrayList<>();
		HashSet<String> set = new HashSet(Arrays.asList(report));
		HashMap<String , List<String>> map = new HashMap<>();
		int [] answer = new int[id_list.length];
		
        //누가 누구를 신고했고 신고당했는지 map을 구한다.
		for(int i=0; i < id_list.length ; i++) {
			map.put(id_list[i], new ArrayList<String>());
		}
		
		for(String s : set) {
			String[] str = s.split(" ");
			String from = str[0];
			String to = str[1];
			map.get(to).add(from);
		}

		//누가 정지를 당했는지 구한다.
		for(int i=0; i < id_list.length ; i++) {
			 
			if(map.get(id_list[i]).size() >= k) {
				suspendedUser.add(id_list[i]);
			}
		}
		
		
//		이메일 받은 횟수를 구한다.
		for(int i=0; i < id_list.length ; i++) {
			
			for(String a : suspendedUser) {
				String b = id_list[i] + " " + a;
				if(set.contains(b))
					answer[i]++;
			}
		}
		
		return answer;
	}
