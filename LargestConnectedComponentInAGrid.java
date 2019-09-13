package leetcode;

public class LargestConnectedComponentInAGrid {
	
	 private static int dfs(int i, int j,int N,int M,boolean[][] vis,int[][] grid) {
	        if (i < 0 || j < 0 || i >= N || j >= M || vis[i][j]|| grid[i][j] != 1) 
	            return 0;

	        int c = 1;

	        vis[i][j] = true;

	        c += dfs(i+1,j,N,M,vis,grid);
	        c += dfs(i,j+1,N,M,vis,grid);
	        c += dfs(i-1,j,N,M,vis,grid);
	        c += dfs(i,j-1,N,M,vis,grid);
	        c += dfs(i+1,j+1,N,M,vis,grid);
	        c += dfs(i+1,j-1,N,M,vis,grid);
	        c += dfs(i-1,j+1,N,M,vis,grid);
	        c += dfs(i-1,j-1,N,M,vis,grid);
	        
	        return c;
	    }

	  
	   private static int connectedCell(int[][] matrix) {

	            int max = 0;
	            int N = matrix.length;
	            int M = matrix[0].length;
	            boolean[][] vis = new boolean[N][M];
	            for (int i = 0; i < N; i++) {
	                for (int j = 0; j < M; j++) {
	                    if (vis[i][j] || matrix[i][j] == 0) 
	                        continue;
	                    max = Math.max(max, dfs(i,j,N,M,vis,matrix));
	                }
	            }

	            return max;

	    }


	public static void main(String[] args) {
		int[][] matrix = new int[][] 
			  { {1, 4, 4, 4, 4, 3, 3, 1}, 
	            {2, 1, 1, 4, 3, 3, 1, 1}, 
	            {3, 2, 1, 1, 2, 3, 2, 1}, 
	            {3, 3, 2, 1, 2, 2, 2, 2}, 
	            {3, 1, 3, 1, 1, 4, 4, 4}, 
	            {1, 1, 3, 1, 1, 4, 4, 4}
	          };
			 
	System.out.print(connectedCell(matrix));


	}

}
