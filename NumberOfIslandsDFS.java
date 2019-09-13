package leetcode;

import java.util.Queue;
import java.util.LinkedList;

public class NumberOfIslandsDFS {
	
	// BFS Solution
	private static void bfs(char[][] grid, boolean[][] visited, int i, int j) {
		int rows = grid.length, cols = grid[0].length;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{i,j});
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				int[] temp = queue.poll();
				int x = temp[0], y = temp[1];

				if (x-1 >= 0 && grid[x-1][y] == '1' && !visited[x-1][y]) {
					queue.offer(new int[]{x-1, y});
					visited[x-1][y] = true;
				}

				if (x+1 < rows && grid[x+1][y] == '1' && !visited[x+1][y]) {
					queue.offer(new int[]{x+1, y});
					visited[x+1][y] = true;
				}

				if (y-1 >= 0 && grid[x][y-1] == '1' && !visited[x][y-1]) {
					queue.offer(new int[]{x, y-1});
					visited[x][y-1] = true;
				} 

				if (y+1 < cols && grid[x][y+1] == '1' && !visited[x][y+1]) {
					queue.offer(new int[]{x, y+1});
					visited[x][y+1] = true;
				}
			}

		}
	}
    
    private  static boolean island(char[][] g,boolean[][] visited , int r, int c){
        int n=g.length;
        int m=g[0].length;
        return (r>=0) && (r<n) && (c>=0) && (c<m) && ((g[r][c] == '1') && !visited[r][c]);
    }
    
	// DFS Solution
    private static void islandsUsingDFS(char[][] grid,boolean[][] visited,int i,int j){

        
        if (!island(grid,visited,i,j))
        	return;
        visited[i][j] = true;
        islandsUsingDFS(grid,visited,i+0,j-1);
        islandsUsingDFS(grid,visited,i-1,j+0);
        islandsUsingDFS(grid,visited,i+0,j+1);
        islandsUsingDFS(grid,visited,i+1,j+0);
        
    }
    
    private static  int numIslands(char[][] grid) {
        
        
        if(grid.length  == 0)
            return 0;
        int cnt = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean[][] visited = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                
                //System.out.print(grid[i][j] + " , ");
                //System.out.println(visited[i][j]+ " :" + i + " : " + j);
                if(grid[i][j] == '1' && !visited[i][j]){

                	islandsUsingDFS(grid,visited,i,j);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }

	public static void main(String[] args) {
		char[][] grid = new char[][] {
									 {'1','1','1','1','0'},
									 {'1','1','0','1','0'},
									 {'1','1','0','0','0'},
									 {'0','0','0','0','0'},
									 };
		int res = numIslands(grid);
		System.out.print("Number of Islands : " + res);

	}

}



/*
 * private static boolean[][] islandsUsingDFS(char[][] grid,boolean[][]
 * visited,int r,int c){
 * 
 * int[] nr= {0,-1,0,1}; int[] nc= {-1,0,1,0};
 * 
 * 
 * visited[r][c] = true; for(int k=0;k<4;k++){
 * 
 * //System.out.println(k); if(island(grid,visited,r,c))
 * islandsUsingDFS(grid,visited,r+nr[k],c+nc[k]); } return visited;
 * 
 * }
 */
