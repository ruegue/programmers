package level1;

public class Solution4 {
	
	public static String solution(int[] number,String hand) {
		String answer = "";
		
		String LeftNumber =  "147*";
		String RightNumber = "369#";
		String MidNnmber = "2580";
		
		String[] location = {"*" , "#"};
		
		for(int i =0; i < number.length ; i++) {
		
		//왼쪽 숫자가 나왔을때
		if(LeftNumber.contains(number[i] + "")) {
			//왼쪽 손가락 위치를 수정합니다.
			location[0] = location[0].replace(location[0], number[i] + "");
			answer = answer + "L";
		}	
		
		//오른쪽 숫자가 나왔을때
		if(RightNumber.contains(number[i] + "")) {
			//오른쪽 손가락 위치를 수정합니다
			location[1] = location[1].replace(location[1], number[i] + "");
			answer = answer + "R";
		}
		
		
		//가운데 숫자가 나왔을때 즉 거리 계산을 해야할때
		if(MidNnmber.contains(number[i] + "")) {
		
			//왼쪽 손가락이 왼쪽에 있을때 좌표
			int[] L = { 0 , LeftNumber.indexOf(location[0])};
			
			//왼쪽 손가락이 가운데 있을때 좌표
			if(LeftNumber.indexOf(location[0]) == -1) {
				L = new int[] { 1 , MidNnmber.indexOf(location[0])};
			}
			
			//가운데 좌표
			int[] M = { 1 , MidNnmber.indexOf(number[i]+"")};
			
			//오른쪽 손가락이 오른쪽에 있을때 좌표
			int[] R = { 0 , RightNumber.indexOf(location[1])};
			
			//오른쪽 손가락이 가운데 있을때 좌표
			if(RightNumber.indexOf(location[1]) == -1) {
				R = new int[] { 1 , MidNnmber.indexOf(location[1])};
			}
			
			//맨하탄거리로 거리구하기
			int distanseL = Math.abs(L[0] - M[0]) + Math.abs(L[1] - M[1]);
			int distanseR = Math.abs(R[0] - M[0]) + Math.abs(R[1] - M[1]);
			
			//각 거리에 따른 결과
			if(distanseL > distanseR) {
				location[1] = location[1].replace(location[1], number[i] + "");
				answer = answer + "R";
			}
				
			if(distanseL < distanseR){
				location[0] = location[0].replace(location[0], number[i] + "");
				answer = answer + "L";
			}
			
			if(distanseL == distanseR) {
				if(hand.equals("left")) {
					location[0] = location[0].replace(location[0], number[i] + "");
					answer = answer + "L";
				}
					
				if(hand.equals("right")) {
					location[1] = location[1].replace(location[1], number[i] + "");
					answer = answer + "R";
				}
			}		
		}
	}
		return answer;	
	
}	

	public static void main(String[] args) {
		int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		String hand = "right";
		
		String sol = solution(number , hand);
		
		System.out.println(sol);
	
	}

}
