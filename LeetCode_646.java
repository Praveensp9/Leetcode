package leetcode;

import java.util.Arrays;

public class LeetCode_646 {

	private static int MaximumLengthOfPairChain(int[][] pairs) {
		
		Arrays.sort(pairs, (a,b)->(a[1]-b[1]));
		int ans =0;
		int cur = Integer.MIN_VALUE;
		for(int[] pair:pairs) {
			
			if(cur<pair[0]) {
				cur = pair[1];
				ans++;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		
			int[][] pairs = new int[3][];
			pairs[0] = new int[] {1,2};
			pairs[1] = new int[] {2,3};
			pairs[2] = new int[] {3,4};
			int res = MaximumLengthOfPairChain(pairs);
			System.out.println(res);
	}

}
