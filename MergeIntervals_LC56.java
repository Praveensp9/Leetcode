package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals_LC56 {
	
	private static int s=0;
	private static int e=1;
	private static int[][] merge(int[][] intervals) {
		
		if(intervals.length == 0 || intervals == null)
			return intervals;
//		Arrays.sort(intervals, new Comparator<int[]>(){
//		
//			public int compare(int[] x, int[] y) {
//				return x[s] - y[s];
//			}
//		}		
//		);
		
		Arrays.sort(intervals,(a,b)-> a[s]-b[s]);
		
		int l=0;
		for(int[] interval : intervals) {
			
			if(l == 0 || intervals[l-1][e] < interval[s] )
				intervals[l++] = interval;
			else {
				intervals[l-1][e] = Math.max(intervals[l-1][e], interval[e]);
			}
		}
		
		
		return Arrays.copyOfRange(intervals, 0, l);
	}

	public static void main(String[] args) {
		
		int[][] intervals = new int[][] {{15,18},{2,3},{4,8},{1,5},{8,10}};
		
		intervals = merge(intervals);
	        
		for(int[] i:intervals){
	        System.out.print("["+i[0]+","+i[1] +"]");
	    }

	}

}
