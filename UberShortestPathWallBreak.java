package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class UberShortestPathWallBreak {
	private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static class Entry{
		int r,c,d;
		public Entry(int r,int c,int d){
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	
	
	private  static int shortestPathwithWallBreak(int[][] matrix,int k) {
		
		int row = matrix.length;
		int col = matrix[0].length;
		
		Queue<Entry> q = new ArrayDeque<>();
		boolean[][][] vis = new boolean[row][col][k+1];
		q.add(new Entry(0,0,0));
		vis[0][0][0] = true;
		int cc=0;
		while(!q.isEmpty()) {
			cc++;
			for(int i=0;i<q.size();i++) {
				Entry entry = q.poll();
				if(entry.r == row-1 && entry.c == col-1) {
					return cc+1;
				}
				
				 for (int[] dir : DIRS) {
	                    int r = entry.r + dir[0];
	                    int c = entry.c + dir[1];
	                    if (isSafe1(matrix, r, c, vis,entry.d)) {
	                    	
	                    	int d = entry.d + matrix[r][c];
	                    	if(d<=k) {
		                    	 vis[r][c][d] = true;
		                         q.add(new Entry(r,c,d));
	                    	}
	                         
	                    }

 				 }
				
			}
			
		}
		
		return -1;
	}
	private static boolean isSafe1(int[][] grid, int r, int c, boolean[][][] visited,int k) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && !visited[r][c][k];
    }
	
	private static boolean isSafe(int[][] grid, int r, int c, boolean[][] visited) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && !visited[r][c] && grid[r][c] == 0;
    }

	private  static boolean shortestPathwithoutWallBreak(int[][] matrix) {
		
		int row = matrix.length;
		int col = matrix[0].length;
		
		Queue<Entry> q = new ArrayDeque<>();
		boolean[][] vis = new boolean[row][col];
		vis[0][0] = true;
		q.add(new Entry(0,0,0));

		while(!q.isEmpty()) {
			
			for(int i=0;i<q.size();i++) {
				Entry entry = q.poll();
				if(entry.r == row-1 && entry.c == col-1) {
					return true;
				}
				
				 for (int[] dir : DIRS) {
	                    int r = entry.r + dir[0];
	                    int c = entry.c + dir[1];
	                    
	                    if (isSafe(matrix, r, c, vis)) {
	                    	 vis[r][c] = true;
	                         q.add(new Entry(r, c,entry.d+1));
	                         
	                    }
	                   
	                    
				 }
				
			}
			
		}
		
		return false;
	}

	public static void main(String[] args) {
		
		int[][] matrix = new int[][] {{0, 1, 0, 1, 0},
									  {0, 1, 0, 1, 0},
									  {0, 1, 0, 1, 0},
									  {0, 1, 0, 1, 0},
									  {1, 0, 0, 1, 0}
									 };
									 
	
		int steps = shortestPathwithWallBreak(matrix,2);
		System.out.println(steps);
		boolean mat = shortestPathwithoutWallBreak(matrix);
		System.out.println(mat);
	}

}
