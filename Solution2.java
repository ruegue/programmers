package level1;

public class Solution2 {
	
	public static String solution(String new_id) {
		String answer = "";
		
		 //1단계 소문자만들기
		new_id = new_id.toLowerCase();
		
		//2단계 문제 제외하기
		for(int i=0; i < new_id.length() ; i++) {
			char a = new_id.charAt(i);
			if(!((a >= 'a' && a  <= 'z') || (a >= '0' && a <= '9') || a == '-' || a == '_' || a == '.')) {
				new_id = new_id.replace(a + "", "");
				i--;
			}
		}

		//3단계 2번이상 연속된 마침표 치환
		while(new_id.indexOf("..")>-1) {
			new_id = new_id.replace("..", ".");
		}
		
		//4단계 처음과 끝 마침표 제거
		if(new_id.charAt(0) == '.') {
			new_id = new_id.substring(1);
		}
		
		if(new_id.length()!=0 && new_id.charAt(new_id.length()-1) == '.') {
			new_id = new_id.substring(0, new_id.length()-1);
		}
		
		//5단계 빈문자열이면 "a" 대입
		if(new_id.equals("")) {
			new_id = new_id + "a";
		}
		
		 //6단계 16자 이상이면 15문자만 남기기 그리고 마지막 마침표제거
		if(new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
		}
		
		if(new_id.length()!=0 && new_id.charAt(new_id.length()-1) == '.') {
			new_id = new_id.substring(0, new_id.length()-1);
		}
		
		 //7단계 길이가 2자 이하라면 3이 될때까지 반복
		if(new_id.length() <= 2) {
			char c = new_id.charAt(new_id.length()-1);
	
			while(new_id.length()!=3) {
				new_id = new_id + c + "";
			}
		}
		return new_id;
	}
	

	public static void main(String[] args) {
		String new_id = "abcdefghijklmn.p";
		
//		for(int i=0; i < new_id.length() ; i++) {
//			char a = new_id.charAt(i);
//			if(!((a >= 'a' && a  <= 'z') || (a >= '0' && a <= '9') || a == '-' || a == '_' || a == '.')) {
//				String new_id1 = new_id.substring(0, i);
//				String new_id2 = new_id.substring(i+1);
//				new_id = new_id1 + new_id2;
//				i--;
//			}
//		}
		
		
		
		String sol = solution(new_id);
		
		System.out.println(sol);
		
	}

}
