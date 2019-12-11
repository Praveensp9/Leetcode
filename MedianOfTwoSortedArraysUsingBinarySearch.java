package leetcode;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 *
 * Solution
 * Take minimum size of two array. Possible number of partitions are from 0 to m in m size array.
 * Try every cut in binary search way. When you cut first array at i then you cut second array at (m + n + 1)/2 - i
 * Now try to find the i where a[i-1] <= b[j] and b[j-1] <= a[i]. So this i is partition around which lies the median.
 *
 * Time complexity is O(log(min(x,y))
 * Space complexity is O(1)
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */

public class MedianOfTwoSortedArraysUsingBinarySearch {

	private static double median(int[] a,int[] b) {
		
		//if input1 length is greater than switch them so that input1 is smaller than input2.
		if(a.length > b.length)
			return median(b,a);
		
		int x = a.length;
		int y = b.length;
		int len = x+y;
		
		int start = 0;
		int end = x;
		
		while(start<=end) {
			
			int px = (start+end)/2;
			int py = (x+y+1)/2-px;
			
			//if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
			
			int x1 = (px == 0) ? Integer.MIN_VALUE : a[px-1];
			int x2 = (px == x) ? Integer.MAX_VALUE : a[px];
			
			int y1 = (py == 0) ? Integer.MIN_VALUE : b[py-1];
			int y2 = (py == y) ? Integer.MAX_VALUE : b[py];
			
			if(x1<= y2 && y1 <= x2) {
				
				if(len%2 == 0) {
					return (double) (Math.max(x1, y1) + Math.min(x2, y2)) / 2.0;
				}
				else {
					return (double) Math.max(x1, y1);
				}
			}
			else if(x1>y2){
				end = px-1;
			}
			else {
				start = px+1;
			}
			
		}
		
		return 0;
	}
	
	public static void main(String[] args) {

		int[] a = new int[] {1,3,4,5,7,9,11};
		int[] b = new int[] {2,4,7,8,11,13};
		double m = median(a,b);
		System.out.println(m);
	}

}