package leetcode;

public class PaintHouseIandII {
	
	
	
	// LeetCode Paint House 1 
	private static int paintHouseI(int[][] costs) {
		if(costs==null||costs.length==0)
			return 0;
		
		int m = costs.length-1;
		
		for(int i=1;i<=m;i++) {
			
			costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
			costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
			costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
		}
		
		return Math.min(Math.min(costs[m][0], costs[m][1]),costs[m][2]);
		
	}
	
	// LeetCode Paint House 2
	private static void paintHouseII() {
		
	}

	public static void main(String[] args) {
		
		int[][] arr = new int[][] {
									{14,2,10},
									{1,4,5},
									{20,9,18},
									{11,2,9,5}
								  };
		int costs = paintHouseI(arr);
		System.out.println(costs);
		paintHouseII();
	}

}
