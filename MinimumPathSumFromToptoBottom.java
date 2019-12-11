package leetcode;

public class MinimumPathSumFromToptoBottom {
	
	 // Leetcode 64
	 private static int minPathSum(int[][] grid) {
	        
	        int sum = 0;
	        int row = grid.length;
	        int col = grid[0].length;
	        
	        int res[][] = new int[row][col];
	        
	        res[0][0]=grid[0][0];
	        for(int i=1;i<col;i++){
	            
	            res[0][i]=grid[0][i];
	            res[0][i]=res[0][i]+res[0][i-1];

	        }
	        
	        for(int i=1;i<row;i++){
	            
	            res[i][0]=grid[i][0];
	            res[i][0]=res[i][0]+res[i-1][0]; 

	        }
	        
	        System.out.println();
	        for(int i=1;i<row;i++){
	            for(int j=1;j<col;j++){
	                res[i][j] = grid[i][j] + Math.min(res[i-1][j],res[i][j-1]);
	            }
	        }
	        
	 
	        return res[row-1][col-1];
	        
	        
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] grid = new int[3][3];
		int ans = minPathSum(grid);
		System.out.print(ans);
	}

}
