package level1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class Solution5 {
	
	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack[] low = new Stack[board.length];
		Stack<Integer> group = new Stack();
		
		//먼저 인형을 쌓습니다.
		for(int i=0; i < board.length ; i++) {
			low[i] = new Stack<Integer>();
		}
		
		for(int i = board.length -1; i>=0; i--) {
			for(int j=0; j <board[i].length ; j++) {
				if(board[i][j]!=0) {
					low[j].push(board[i][j]);
				}
			}
		}
		
		
		//인형을 뽑고 없어진 인형갯수를 구합니다.
		for(int i=0; i < moves.length ; i++) {
			
			if(low[moves[i] -1].empty())
				continue;
			
			int a = (int) low[moves[i]-1].pop();
			
			if(group.empty()) {
				group.push(a);
				continue;
			}
			
			if(a == group.peek()) {
				answer++;
				group.pop();
			}else {
				group.push(a);
			}
		}
		
		return answer*2;
	}

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0} , {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
		int[] moves = {1 ,5, 3, 5, 1, 2, 1, 4};
		
		
		int sol = solution(board , moves);
		
		System.out.println(sol);
	}

}
