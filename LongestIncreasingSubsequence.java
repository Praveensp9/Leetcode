package leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	
	private static int lis(int[] arr) {
		
		if(arr.length<=0)
			return 0;
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);
		
		for(int i=1;i<arr.length;i++) {
			
			for(int j=0;j<i;j++) {
				
				if(arr[j] < arr[i])
					dp[i] = Math.max(dp[i],dp[j]+1);
			}
		}
		
		return Arrays.stream(dp).max().getAsInt();
	}

	public static void main(String[] args) {
			int[] arr = new int[] {10,9,2,5,3,7,101,18};
			int n =lis(arr);
			System.out.println(n);
	}

}
