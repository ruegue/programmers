package level1;

import java.util.*;
import java.util.stream.Collectors;

public class Solution1 {

    public static int[] solution(String[] id_list, String[] report, int k) {

        Set<String> set = new HashSet<>(Arrays.asList(report));
        int[] answer = new int[id_list.length];

        Map<String, List<String>> accusedAndAccuserMapping = getAccusedAndAccuserMapping(id_list, set);

        List<String> suspendedUser = Arrays.stream(id_list).filter(id -> accusedAndAccuserMapping.get(id).size() >= k ).collect(Collectors.toList());


//		이메일 받은 횟수를 구한다.
        for (int i = 0; i < id_list.length; i++) {

            for (String a : suspendedUser) {
                String b = id_list[i] + " " + a;
                if (set.contains(b))
                    answer[i]++;
            }
        }

        return answer;
    }

    private static Map<String, List<String>> getAccusedAndAccuserMapping(String[] id_list, Set<String> set) {

        Map<String, List<String>> map = new HashMap<>();
        //누가 누구를 신고했고 신고당했는지 map을 구한다.
        for (String id : id_list) {
            map.put(id, new ArrayList<>());
        }

        for (String s : set) {
            String[] str = s.split(" ");
            String from = str[0];
            String to = str[1];
            map.get(to).add(from);
        }

        return map;
    }
}
