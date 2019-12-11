package leetcode;

import java.util.Deque;
import java.util.LinkedList;

// Leetcode :  https://leetcode.com/problems/walls-and-gates/

class Solution {				
	
	private static final int[][] neigh = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
	private static int INF = 2147483647;
	private static class Cell{
		int row;
		int col;
		public Cell(int r,int c) {
			this.row = r;
			this.col = c;
		}
	}
	
	private static void addNeighbours(int[][] gates,int row,int col,Deque<Cell> q) {
		
		for(int[] d:neigh) {
			int x = row + d[0];
			int y = col + d[1];
			
			if(x<0 || x>=gates.length || y<0 || y>=gates[0].length || gates[x][y] != INF)
				continue;
			
			gates[x][y] = 1 + gates[row][col];
			q.offerFirst(new Cell(x,y));
		}
	}
	
	public static void wallsAndGates(int[][] gates) {
		Deque<Cell> q = new LinkedList<>();
		int row = gates.length;
		int col = gates[0].length;
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(gates[i][j] == 0)
					q.offerFirst(new Cell(i,j));
			}
		}
		
		while(!q.isEmpty()) {
			Cell c = q.pollLast();
			addNeighbours(gates,c.row,c.col,q);
		}
	}
}
public class WallsAndGates{
	private static int INF = 2147483647;
	private static int[][] gates = new int[][] {
												 {INF,-1,0,INF},
											 	 {INF,INF,INF,-1},
												 {INF,-1,INF,-1},
												 {0,-1,INF,INF}
											   };
	public static void main(String[] args) {
		Solution.wallsAndGates(gates);
		for(int i=0;i<gates.length;i++) {
			for(int j=0;j<gates[0].length;j++) {
				System.out.print(gates[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
