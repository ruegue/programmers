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
		HashSet set = new HashSet(Arrays.asList(report));
		HashMap<String , List<String>> map = new HashMap<>();
		int [] answer = new int[id_list.length];
		
		//누가 유저를 신고했는지 묶어준다.
		for(int i=0; i < id_list.length ; i++) {
			
			ArrayList Accuser = new ArrayList<>();
			
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				String[] a = it.next().split(" ");
				if(id_list[i].equals(a[1])) 
					Accuser.add(a[0]);
			}
			map.put(id_list[i], Accuser);
		}
		
		//누가 정지를 당했는지 구한다.
		for(int i=0; i < id_list.length ; i++) {
			 
			if(map.get(id_list[i]).size() >= k) {
				suspendedUser.add(id_list[i]);
			}
		}
		
		//이메일 보내기
		for(int i=0; i < id_list.length ; i++) {
			int count = 0;
			
			for(String a : suspendedUser) {
				String b = id_list[i] + " " + a;
				if(set.contains(b))
				count++;
			}
			
			answer[i] = count;
		}
		
		return answer;
	}
