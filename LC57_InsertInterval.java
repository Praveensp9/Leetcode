package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC57_InsertInterval {

	private static int[][] insertInterval(int[][] intervals,int[] newInterval){
		
		 if(intervals == null || newInterval == null || newInterval.length == 0)                 return null;
	       if (intervals.length == 0) 
	           return new int[][]{newInterval};
	        
	        List<int[]> result = new ArrayList<>();
	        
	        boolean seen = false;
	        int n = intervals.length;
	        
	        for(int i=0;i<n;i++){
	                
	            if(intervals[i][1] < newInterval[0])
	                result.add(intervals[i]);
	            else if(intervals[i][0] > newInterval[1]){
	                if(!seen){
	                    result.add(newInterval);
	                    seen = true;
	                }
	                result.add(intervals[i]);
	            }
	            else{
	                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
	                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
	            }
	                
	        }
	        
	        if (!seen) {
	            result.add(newInterval);
	        }
	        
	        return result.toArray(new int[result.size()][2]);
		
	}
	
	public static void main(String[] args) {
		
		int[][] intervals = new int[][] {{1,3},{2,6},{8,10},{15,18}};
		int[] newInterval = new int[] {2,3};
		
		intervals = insertInterval(intervals,newInterval);
	        
		for(int[] i:intervals){
	        System.out.print("["+i[0]+","+i[1] +"]");
	    }

	}

}
