package level1;

public class Solution7 {
	
	public static int[] solution(int[] lottos, int[] win_nums) {
		 
		int Maxrank;
		int Minrank;
		int count=0;
		int zero=0;
		
		for(int i=0; i<lottos.length; i++) {
			for(int j=0; j<win_nums.length;j++) {
				if(lottos[i]==win_nums[j]) {
					++count;
				}
			}
		}
		
		for(int i=0; i<lottos.length; i++) {
			if(lottos[i]==0)
				++zero;
		}
		
		if(count<2) {
			Minrank = 6;
		}else {
		Minrank = 7-count;
		}
		if(count==0 && zero ==0) {
			Maxrank = 6;
		}else {
			Maxrank = 7-count-zero;
		}
		
		int[] answer = {Maxrank,Minrank};
	    return answer;
	}
	
	public static void main(String[] args) {
	
		 int [] arr1 = {1,2,3,4,5,6};
		 int [] arr2 = {7,8,9,10,11,12};
		
		System.out.println(solution(arr1, arr2)[0]);
		System.out.println(solution(arr1, arr2)[1]);
	
	
	}

}
