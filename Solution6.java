package level1;

import java.util.Arrays;

public class Solution6 {
	
	public static int solution(int[] numbers) {
		int answer= 0;
		int[] allNumber = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		for(int num : allNumber) {
			if(!Arrays.toString(numbers).contains(num + ""))
				answer += num;
		}
		
		
		return answer;
	}

	public static void main(String[] args) {
		int[] numbers = {5,8,4,0,6,7,9};
		
		int sol = solution(numbers);
		
		System.out.println(sol);
	}

}
