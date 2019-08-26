package leetcode;

import java.util.List;

public class TriangleSum_LeetCode120 {

	private static int triangle(List<List<Integer>> lst){
		
		
		for(int i=lst.size()-2;i>=0;i--) {
			
			for(int j=0;j<=i;j++) {
				
				
				int min1 = lst.get(i+1).get(j);
				int min2 = lst.get(i+1).get(j+1);
				int min = Math.min(min1, min2);
				int val = lst.get(i).get(j);
				int sum  = val+min;
				lst.get(i).set(j,sum);
				
			}
		}
		
		return lst.get(0).get(0);
	}
	
	public static void main(String[] args) {
	

	}

}
