package leetcode;

public class SudokuSolver {
	
	private static char empty = '.';
	
	private static boolean solve(char[][] board, int row,int col) {
		
		
		if(col == board[row].length) {
			col=0;
			row++;
		}
		
		if(row == board.length)
			return true;
		
		if(board[row][col] != empty){
			solve(board,row,col+1);
		}
		
		for(int i=1;i<=board.length;i++) {
			
			char ch = (char) (i+'0');
			
			if(isValidPlacement(board,row,col,ch)) {
				board[row][col] = ch;
				if(solve(board,row,col+1))
					return true;
			}
		}
		
		board[row][col] = empty;
		return false;
		
	}
	
	
	private static boolean isValidPlacement(char[][] board,int row,int col,char c) {
		
		// Checking for the row constraint
		for(char[] ele :board) {
			if(c == ele[col])
				return false;
		}
		
		// Checking for the column constraint
		for(int i=0;i<board.length;i++) {
			if(c == board[row][i])
				return false;
		}
		
		
		// Checking Sub Grid Constraint
		
		// bs = board size (9*9)
		int bs = (int) Math.sqrt(board.length);
		
		// which grid the char is present
		int I = row / bs;
		int J = col / bs;
		
		// top row and top col for the current grid
		int i = I * bs;
		int j = J * bs;
		
		for(int p=0;p<bs;p++)
			for(int q=0;q<bs;q++)
				if(board[p+i][q+j] == c )
					return false;
		
		
		return true;
		
	}
	
	
	private static boolean sudokuSolver(char[][] board) {
		return solve(board,0,0);
	}

	public static void main(String[] args) {
		
		char[][] board = new char[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
            	board[i][j] = '.';
            }
        }

        board[0] = "..9748...".toCharArray();
        board[1] = "7........".toCharArray();
        board[2] = ".2.1.9...".toCharArray();
        board[3] = "..7...24.".toCharArray();
        board[4] = ".64.1.59.".toCharArray();
        board[5] = ".98...3..".toCharArray();
        board[6] = "...8.3.2.".toCharArray();
        board[7] = "........6".toCharArray();
        board[8] = "...2759..".toCharArray();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        boolean sudoku = sudokuSolver(board);
        
        System.out.println(sudoku);
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
	}

}
