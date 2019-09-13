package leetcode;

import java.util.Queue;
import java.util.LinkedList;

public class KnightMinimumNumberOfStepsToReachTarget {

	private static final int N=5;
	private static final int a=0,b=0;
	private static final int y=3,z=1;
	static class Cell{
		int x;
		int y;
		int distance;
		public Cell(int x,int y,int d) {
			this.x = x;
			this.y = y;
			this.distance = d;
		}
	}
	
	private static boolean canMove(int x,int y) {
		return (x>=0 && x<N && y>=0 && y<N);
	}
	
	private static int minStepsToReachTarget(int a,int b,int y,int z) {
		
		int[] dx = {1,1,-1,-1,2,2,-2,-2};
	    int[] dy = {2,-2,2,-2,1,-1,1,-1};
	    
	    Queue<Cell> q = new LinkedList<>();
	    q.add(new Cell(a,b,0));
	    
	    Cell cell;
	    boolean[][] visited = new boolean[N][N];
	    visited[a][b] = true;
	    
	    while(!q.isEmpty()) {
	    	cell = q.peek();
	    	q.poll();
	    	
	    	if(cell.x == y && cell.y == z)
	    		return cell.distance;
	    	
	    	for(int k=0;k<8;k++) {
	    		
	    		int m = cell.x+dx[k];
	    		int n = cell.y+dy[k];
	    		
	    		if(canMove(m,n)) {
	    			visited[m][n] = true;
	    			q.add(new Cell(m,n,cell.distance+1));
	    		}
	    	}
	    }
		return -1;
	}

	public static void main(String[] args) {
		int distance = minStepsToReachTarget(a,b,y,z);
		System.out.println(distance);
	}

}
