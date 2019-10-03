package leetcode;

import java.util.*;
import java.util.Arrays;

public class NQueensProblemUsingBackTrack {

	private static  class Queen{
		int row=0,col=0;
		public Queen(int r,int c) {
			this.row = r;
			this.col = c;
		}
	}
	
	
	private static List<List<String>> distinctNqueensSolution(int n){
		List<List<String>> res = new ArrayList<List<String>>();
		
		
		return res;
	}
	
	private  boolean solve(int n,int row,Queen[] queen) {
		
		if(n == row)
			return true;
		
		int c;
		
		for(c=0;c<n;c++) {
			boolean solution = true;
			
			// check whether we can place the queen at this row and col
			
			for(int quen = 0; quen < row;quen++) {
				if(queen[quen].col == c || queen[quen].row - queen[quen].col == row - c ||
						queen[quen].row+queen[quen].col == row+c) {
					solution = false;
					break;
				}
			}
			
			if(solution) {
				queen[row] = new Queen(row,c);
				if(solve(n,row+1,queen)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	private  Queen[] solveNQueensProblem(int n) {
		
		Queen[] queen = new Queen[n];
		boolean issafe = solve(n,0,queen);
		if(issafe)
			return queen;
		else
			return new Queen[0];
	}
	public static void main(String[] args) {
		NQueensProblemUsingBackTrack nqueens = new NQueensProblemUsingBackTrack();
		Queen[] queen = nqueens.solveNQueensProblem(5);
		
		Arrays.stream(queen).forEach(q -> System.out.println(q.row + " "+ q.col));
		
		
		List<List<String>> res = nqueens.distinctNqueensSolution(4);
	}

}
