package leetcode;

public class LC63_UniquePaths {
	
	
	private static int UniquePathsii(int[][] obstacle) {
		int r = obstacle.length;
		int c = obstacle[0].length;
		
		if(obstacle[0][0] == 1)
			return 0;
		
		obstacle[0][0] = 1;
		
		
		for(int i=1;i<r;i++)
			obstacle[i][0] = (obstacle[i][0] == 0 && obstacle[i-1][0] == 1) ? 1 : 0;
		
		for(int i=1;i<c;i++)
			obstacle[0][i] = (obstacle[0][i] == 0 && obstacle[0][i-1] == 1) ? 1 : 0;
		
		for(int i=1;i<r;i++){
			for(int j=1;j<c;j++) {
				if(obstacle[i][j] == 0)
					obstacle[i][j] = obstacle[i-1][j] + obstacle[i][j-1];
				else
					obstacle[i][j] = 0;
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) 
					System.out.print(obstacle[i][j] + " ");
			System.out.println();
		}
		
		return obstacle[r-1][c-1];
		
	}

	public static void main(String[] args) {
		
		int[][] obstacle = new int[][] {
			{0,1,0},
			{0,1,0},
			{0,0,0}
		};
		int ans = UniquePathsii(obstacle);
		System.out.print(ans);

	}

}
