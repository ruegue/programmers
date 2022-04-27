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
		
		ArrayList list2 = new ArrayList<>();
		HashSet set = new HashSet(Arrays.asList(report));
		HashMap<String , List<String>> map = new HashMap<>();
		int [] answer = new int[id_list.length];
		
		//누가 누구를 신고했는지 짝지워준다
		for(int i=0; i < id_list.length ; i++) {
			
			ArrayList list1 = new ArrayList<>();
			
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				String[] a = it.next().split(" ");
				if(id_list[i].equals(a[0])) 
					list1.add(a[1]);
			}
			map.put(id_list[i], list1);
		}
		
		for(int i = 0; i < id_list.length ; i++) {
			int count = 0;
			
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				String[] a = it.next().split(" ");
				if(id_list[i].equals(a[1])) {
					count++;
				}
			}
			
			if(count >= k) {
				list2.add(id_list[i]);
			}
		}
		
		for(int i =0; i < id_list.length ; i++) {
			
			int count = 0;
			List list = map.get(id_list[i]);
			for(int j = 0; j < list.size() ; j++) {
				Iterator<String> it = list2.iterator();
				while(it.hasNext()){
					if(list.get(j).equals(it.next())) {
						count++;
					}
				}
			}
			
			answer[i] = count;
			
		}
		return answer;
	}
	 
	public static void main(String[] args) {
		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
		String[] id_list = {"con", "ryan"};

		int[] sol = solution(id_list, report, 2);
		
		System.out.println(Arrays.toString(sol));
	
		}
}
