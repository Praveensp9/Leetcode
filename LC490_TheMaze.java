package leetcode;

import java.util.Queue;
import java.util.LinkedList;

public class LC490_TheMaze {
	
	private static boolean canMove(int x,int y,int[][] maze,boolean[][] visited) {
		return (x>=0 && x<maze.length && y>=0 && y<maze.length && maze[x][y] == 0) && !visited[x][y];
	}
	
	// BFS to solve this problem
	private static boolean solveMaze(int[][] maze,int[] start,int[] end) {
		
		int row = maze.length;
		int col = maze[0].length;
		
		boolean[][] visited = new boolean[row][col];
		
		int[][] dirs={{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
		
		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		visited[start[0]][start[1]] = true;
		
		while(!q.isEmpty()) {
			int[] s = q.poll();
			if(s[0] == end[0] && s[1] == end[1])
				return true;
			
			for(int[] dir:dirs) {
				int x = dir[0] + s[0];
				int y = dir[1] + s[1];
				
				if(canMove(x,y,maze,visited)) {
					q.add(new int[] {x,y});
                    visited[x][y] = true;
				}
			}
		}
		
		return false;
		
	}

	public static void main(String[] args) {
		int[][] maze = new int[][] {
			{0,0,1,0,0},
			{0,0,0,0,0},
			{0,0,0,1,0},
			{1,1,0,1,1},
			{0,0,0,0,0}
		};
		int[] start = new int[] {0,4};
		int[] end = new int[] {4,4};
		
		boolean res = solveMaze(maze,start,end);
		
		System.out.print(res);
	}

}
