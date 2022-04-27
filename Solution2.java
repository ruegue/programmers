package level1;

public class Solution2 {
	
	public static String solution(String new_id) {
		String answer = "";
		
		new_id = new_id.toLowerCase();
		
		for(int i=0; i < new_id.length() ; i++) {
			char a = new_id.charAt(i);
			if(!((a >= 'a' && a  <= 'z') || (a >= '0' && a <= '9') || a == '-' || a == '_' || a == '.')) {
				new_id = new_id.replace(a + "", "");
				i--;
			}
		}

		while(new_id.indexOf("..")>-1) {
			new_id = new_id.replace("..", ".");
		}
		
		if(new_id.charAt(0) == '.') {
			new_id = new_id.substring(1);
		}
		
		if(new_id.length()!=0 && new_id.charAt(new_id.length()-1) == '.') {
			new_id = new_id.substring(0, new_id.length()-1);
		}
		
		if(new_id.equals("")) {
			new_id = new_id + "a";
		}
		
		if(new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
		}
		
		if(new_id.length()!=0 && new_id.charAt(new_id.length()-1) == '.') {
			new_id = new_id.substring(0, new_id.length()-1);
		}
		
		if(new_id.length() <= 2) {
			char c = new_id.charAt(new_id.length()-1);
	
			while(new_id.length()!=3) {
				new_id = new_id + c + "";
			}
		}

		return new_id;
	}
}
