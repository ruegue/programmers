package level1;

//encoding이 utf-8이 아니네요. 혹시 4번부터 다른 환경에서 푸셨나요?
public class Solution4 {
	
	public static String solution(int[] number,String hand) {
		String answer = "";
		
		String LeftNumber =  "147*";
		String RightNumber = "369#";
		String MidNnmber = "2580";
		
		String[] location = {"*" , "#"};
		
		for(int i =0; i < number.length ; i++) {
		
		//왼쪽 숫자가 나왔을때
		if(LeftNumber.contains(number[i] + "")) { // int -> string을 하기 위해서 string과 더하는 것은 ng입니다. use Integer.parseInt()
			//왼쪽 손가락 위치를 수정합니다.
			// 이 두줄은 밑에서도 반복되네요. 왼손 엄지를 쓰는 동작과 오른쪽 엄지를 쓰는 동작은 추상화 할 수 있을 것 같습니다.
			answer = moveLeftThumb(answer, location, number[i]);
		}	
		
		//오른쪽 숫자가 나왔을때
		if(RightNumber.contains(number[i] + "")) {
			//오른쪽 손가락 위치를 수정합니다
			answer = moveRightThumb(answer, location, number[i]);
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
				//이제 이 밑으로 좌측 우측 엄지 움직이는 것에 대해서 생각할 것 없이 추상화한 함수를 호출하면 됩니다.
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

	private static String moveRightThumb(String answer, String[] location, int number) {
		location[1] = location[1].replace(location[1], number + "");
		answer = answer + "R";
		return answer;
	}

	private static String moveLeftThumb(String answer, String[] location, int number) {
		location[0] = location[0].replace(location[0], number + "");
		answer = answer + "L";
		return answer;
	}

	public static void main(String[] args) {
		int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		String hand = "right";
		
		String sol = solution(number , hand);
		
		System.out.println(sol);
	
	}

}
