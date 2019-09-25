package leetcode;

import java.util.Arrays;

public class LC1029_TwoCityScheduling {
	
	private static int twoCitySchedCost(int[][] costs) {
		Arrays.sort(costs,(a,b)->{
			return (a[1]-a[0]) - (b[1]-b[0]);
		});
		
		int l = costs.length;
		int m = l/2;
		int cost = 0;
		for(int i=0;i<l;i++) {
			if(i<m)
				cost = cost + costs[i][1];
			else
				cost = cost + costs[i][0];
		}
		
		return cost;
	}

	public static void main(String[] args) {
		int cost = twoCitySchedCost(new int[][]{ {400,50},{200,10},{5,20},{60,30} });
		System.out.println(cost);
	}

}
