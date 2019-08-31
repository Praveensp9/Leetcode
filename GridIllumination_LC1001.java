package leetcode;

public class GridIllumination_LC1001 {
	
	private static int[] gridIllumination(int N, int[][] lamps,int[][] queries) {
		int res[] = new int[queries.length];
		
		return res;
		
	}

	public static void main(String[] args) {
		
		int N = 5;
		int[][] lamps = new int[][]{{1,1},{4,2}};
		int[][] queries = new int[][]{{0,1},{2,3},{1,1},{2,0}};
		int[] res = gridIllumination(N,lamps,queries);
		for(int i:res)
			System.out.println(i);
	}

}
