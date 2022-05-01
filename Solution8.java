package level1;

public class Solution8 {
	
	public static int solution(int[] absolutes, boolean [] sings) {
		int answer = 0;
		
		for(int i=0; i < absolutes.length ; i++) {
			
			if(sings[i]==true) {
				answer += absolutes[i];
			}else {
				answer -= absolutes[i];
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int[] absolutes = {4,7,12};
		boolean[] sings = {true,false,true};
		
		int sol = solution(absolutes, sings);
		
		System.out.println(sol);
	}

}
