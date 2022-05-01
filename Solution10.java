package level1;

import java.util.ArrayList;

public class Solution10 {

	public static int solution(int[] nums) {
		int answer = 0;
		ArrayList<Integer> list = new ArrayList();
		
		for(int i =0; i < nums.length ; i++) {
			for(int j = i + 1 ; j < nums.length ; j++) {
				for(int k = j + 1; k < nums.length ; k++) {
					int sum = nums[i] + nums[j] + nums[k];
					list.add(sum);
				}
			}
		}
		
		for(int i = 0 ; i < list.size() ; i++) {
			int cnt = 0;
			int a = list.get(i);

			for(int j = 1; j <= a ; j++) {
				if(a % j == 0) {
					cnt++;
				}
			}
			
			if(cnt == 2) {
				answer++;
			}
		}
		
		return answer;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {1,2,7,6,4};
		int sol = solution(nums);
		System.out.println(sol);
	}

}
