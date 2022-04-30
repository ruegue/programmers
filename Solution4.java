package level1;

public class Solution4 {
	
	public static String solution(int[] number,String hand) {
		String answer = "";
		
		String LeftNumber =  "147*";
		String RightNumber = "369#";
		String MidNnmber = "2580";
		
		String[] location = {"*" , "#"};
		
		for(int i =0; i < number.length ; i++) {
		
		//���� ���ڰ� ��������
		if(LeftNumber.contains(number[i] + "")) {
			//���� �հ��� ��ġ�� �����մϴ�.
			location[0] = location[0].replace(location[0], number[i] + "");
			answer = answer + "L";
		}	
		
		//������ ���ڰ� ��������
		if(RightNumber.contains(number[i] + "")) {
			//������ �հ��� ��ġ�� �����մϴ�
			location[1] = location[1].replace(location[1], number[i] + "");
			answer = answer + "R";
		}
		
		
		//��� ���ڰ� �������� �� �Ÿ� ����� �ؾ��Ҷ�
		if(MidNnmber.contains(number[i] + "")) {
		
			//���� �հ����� ���ʿ� ������ ��ǥ
			int[] L = { 0 , LeftNumber.indexOf(location[0])};
			
			//���� �հ����� ��� ������ ��ǥ
			if(LeftNumber.indexOf(location[0]) == -1) {
				L = new int[] { 1 , MidNnmber.indexOf(location[0])};
			}
			
			//��� ��ǥ
			int[] M = { 1 , MidNnmber.indexOf(number[i]+"")};
			
			//������ �հ����� �����ʿ� ������ ��ǥ
			int[] R = { 0 , RightNumber.indexOf(location[1])};
			
			//������ �հ����� ��� ������ ��ǥ
			if(RightNumber.indexOf(location[1]) == -1) {
				R = new int[] { 1 , MidNnmber.indexOf(location[1])};
			}
			
			//����ź�Ÿ��� �Ÿ����ϱ�
			int distanseL = Math.abs(L[0] - M[0]) + Math.abs(L[1] - M[1]);
			int distanseR = Math.abs(R[0] - M[0]) + Math.abs(R[1] - M[1]);
			
			//�� �Ÿ��� ���� ���
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
