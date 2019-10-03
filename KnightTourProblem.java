package leetcode;

public class KnightTourProblem {
	
	private static int N = 8;
	
	
	private static void printSolution(int sol[][]) { 
        for (int x = 0; x < N; x++) { 
            for (int y = 0; y < N; y++) 
                System.out.print(sol[x][y] + " "); 
            System.out.println(); 
        } 
    } 
	
	private static boolean isValidPosition(int nx,int ny,int[][] board) {
		
		return (nx>=0 && nx<N && ny>=0 && ny<N && board[nx][ny] == -1);
	}
	
	private static boolean KnightTour(int r,int c) {
		
		int[][] board = new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				board[i][j] = -1;
		
		int[] knight_moves_x = {2, 1, -1, -2, -2, -1,  1,  2};
		int[] knight_moves_y = {1, 2,  2,  1, -1, -2, -2, -1}; 
		
		board[r][c] = 0;
		if(!canPlaceKnight(r,c,1,board,knight_moves_x,knight_moves_y)) {
			return false;
		}
		else {
			System.out.println("\n");
			printSolution(board);
		}
		
		return true;
	}
	
	private static boolean canPlaceKnight(int x,int y,int tot,int[][] board, int[] knight_moves_x,int[] knight_moves_y) {
		
		int k,nx,ny;
		if(tot == N * N)
			return true;
		
		for(k=0;k<8;k++) {
			
			nx = x + knight_moves_x[k];
			ny = y + knight_moves_y[k];
			
			if(isValidPosition(nx,ny,board)) {
				
				board[nx][ny] = tot;
				if(canPlaceKnight(nx,ny,tot+1,board,knight_moves_x,knight_moves_y))
					return true;
				else
					board[nx][ny] = -1; // Backtracking Stuff happens here
			}
		}
	    return false; 
	}

	public static void main(String[] args) {
		boolean res = KnightTour(0,0);
		System.out.println();
		if(res)
			System.out.print("Solution Exists as shown in the above board");
		else
			System.out.print("Solution does not exists for this given Knight tour");
	}

}
