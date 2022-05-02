package level1;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution11 {
	
	public static String solution(String[] paticipant, String[] completion) {
		String answer ="";
		
		for(int i = 0; i < paticipant.length ; i++) {
			for(int j =0; j < completion.length ; j++) {
				if(paticipant[i]=="")
					break;
				if(completion[j]=="")
					continue;
	
				if(paticipant[i].equals(completion[j])) {
					paticipant[i] = "";
					completion[j] = "";
				}
			}
		}
		
		for(int i=0; i < paticipant.length ; i++) {
			if(paticipant[i]!="")
				answer = paticipant[i];
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
