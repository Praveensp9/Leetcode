package leetcode;

public class RatInMaze {
	
	private static final int[] start = new int[] {0,0};
	private static final int[] end = new int[] {4,4};
	
	private static void print(int[][] sol) 
	    { 
	        for (int i = 0; i < sol.length; i++) { 
	            for (int j = 0; j < sol[0].length; j++) 
	                System.out.print(" " + sol[i][j] + " "); 
	            System.out.println(); 
	        } 
	    } 
	
	private static boolean canMove(int x,int y,int[][] maze) {
		return (x>=0 && x<maze.length && y>=0 && y<maze.length && maze[x][y] == 1);
	}
	
	private static boolean SolveMazeUtil(int[][] maze,int a,int b,int[][] sol) {

		
		if(a == end[0]  && b == end[1]) {
			sol[a][b]=1;
			return true;
		}
		
		if(canMove(a,b,maze)) {
			
			sol[a][b] = 1;
			
			if(SolveMazeUtil(maze,a+1,b,sol))
					return true;
			
			if(SolveMazeUtil(maze,a,b+1,sol))
					return true;
			
			sol[a][b] = 0;
			return false;
		}
	
		return false;
	}
	
	
	private static boolean solveMaze(int[][] maze) {
		int row = maze.length;
		int col = maze[0].length;
		int[][] sol = new int[row][col];
		
		int a = start[0];
		int b = start[1];
		
		if(!SolveMazeUtil(maze,a,b,sol)) {
			System.out.println("No Path exists");
			return false;
		}
		
		print(sol);
		return true;
		
	}

	public static void main(String[] args) {
		
		int[][] maze = new int[][] {
			{1,1,1,0,0},
			{1,1,1,1,0},
			{1,1,1,1,0},
			{1,0,0,1,1},
			{0,1,1,1,1}
		};
		
		
		solveMaze(maze);
	}

}
