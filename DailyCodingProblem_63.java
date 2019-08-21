package leetcode;

public class DailyCodingProblem_63 {
	
	 	private static int[] nr = new int[] {0,1,-1,0};
	    private static int[] nc = new int[] {1,0,0,-1};
	   
	    private static boolean searchWord(char[][] board,String word,boolean[][] visited,int i,int j,int wl,int index,int row,int col){
	        
	        if(index == wl)
	            return true;
	        
	        for(int k = 0;k<4;k++){
	            
	            int x = i+nr[k];
	            int y = j+nc[k];
	            
	            if(x<row && x>=0 && y>=0 && y<col && visited[x][y] == false && board[x][y]==word.charAt(index)){
	                
	               visited[x][y] = true;
	                boolean found = searchWord(board,word,visited,x,y,wl,index+1,row,col);
	                if(found)
	                    return true;
	                visited[x][y] = false;
	            }
	        }
	        
	        return false;
	        
	    }
	    private static boolean wordSearchLC79(char[][] board, String word) {
	        
	        int n = word.length();
	        if(n == 0)
	            return true;
	        int row = board.length;
	        int col = board[0].length;
	        boolean[][] visited = new boolean[row][col];
	        
	        for(int i=0;i<row;i++){
	            for(int j=0;j<col;j++){
	                
	                if(board[i][j] == word.charAt(0)){
	                    visited[i][j] = true;
	                    boolean found = searchWord(board,word,visited,i,j,n,1,row,col);
	                    
	                    if(found)
	                        return true;
	                    visited[i][j] = false;
	                    
	                }
	            }
	        }
	         
	        return false;
	    }

	public static void main(String[] args) {
		
		char[][] grid = new char[][] {
			 {'A','B','C','E','D'},
			 {'D','E','C','T','X'},
			 {'R','D','E','U','K'},
			 {'Q','S','G','V','J'},
			 };
		boolean res = wordSearchLC79(grid,"ABCCEDRQSGE");
		System.out.print("Found : " + res);


	}

}
