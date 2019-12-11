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
	private static int paintHouseII(int[][] costs) {
		
		if(costs == null || costs.length == 0)
            return 0;
        
        int total_house = costs.length;
        
        int min1 = 0;
        int min2 = 0;
        int index1 = -1;
        
        for(int i=0;i<total_house;i++){
            int m1 = Integer.MAX_VALUE;
            int m2 = Integer.MAX_VALUE;
            int index = -1;
            
            for(int j=0;j<costs[0].length;j++){
                
                int cost = costs[i][j] + (j != index1 ? min1 : min2);
                
                if(cost<m1){
                    m2=m1;
                    m1= cost;
                    index = j;
                }
                else if(cost<m2){
                    m2=cost;
                }
            }
            
            min1 = m1;
            min2 = m2;
            index1 = index;
        }
        return min1;
	}

	public static void main(String[] args) {
		
		int[][] arr = new int[][] {
									{14,2,10},
									{1,4,5},
									{20,9,18},
									{11,2,9}
								  };
		int costs = paintHouseI(arr);
		System.out.println(costs);
		
		
		int[][] paint = new int[][] {
			{1,3},
			{2,4}
		};
		int cost = paintHouseII(paint);
		System.out.println(cost);
	}

}
