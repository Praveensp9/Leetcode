package leetcode;


// Solution is in place without using extra memory

// To make this work for large matrix, we use files to store out matrix data
// data read only the top row and bottom row of a cell which has all the 
// 8 neighbours into the memory to execute the code and update the matrix for 
// all the cells
public class GameOfLife_LC298 {
	
	
	private static  int  r = 0;
	private static  int  c = 0;
	
	private  GameOfLife_LC298(int r,int c){
		GameOfLife_LC298.r= r;
		GameOfLife_LC298.c= c;
	}
	
	private static int[][] neighbours = new int[][]{{0,-1},{-1,0},{0,1},{1,0},{1,-1},{-1,-1},{-1,1},{1,1}};
	
	private static int liveOrDead(int x,int y,int[][] board) {
		int res=0;
		
		for(int[] neigh : neighbours) {
			
			int nx = x + neigh[0];
			int ny = y + neigh[1];
			
			if( nx>=0 && nx<r && ny>=0 && ny<c && (board[nx][ny] & 1) == 1)
				res++;
		}
		return res;
	}
	
	
	private void gameOfLife(int[][] board) {
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				int cell = liveOrDead(i,j,board);
				if(cell == 2 && (board[i][j] & 1) == 1 || cell == 3)
					board[i][j] = board[i][j] | 2;
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++)
				board[i][j]= board[i][j] >> 1;
		}
		
	}

	public static void main(String[] args) {
		int[][] board = new int[][] {
			 {0,1,0},
			 {0,0,1},
			 {1,1,1},
			 {0,0,0}};
			 
		GameOfLife_LC298 gol = new GameOfLife_LC298(board.length,board[0].length);
		gol.gameOfLife(board);
		 
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
