package leetcode;

import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {
	
	private static int MaxSumIncSubSeq(int[] arr) {
	
		int n = arr.length;
		int[] dp = new int[n];
		for(int i=0;i<n;i++)
			dp[i] = arr[i];
		
		for(int i=1;i<n;i++) {
			
			for(int j=0;j<i;j++) {
				
				if(arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], arr[i]+dp[j]);
				}
				
			}
		}
		
		int max = Arrays.stream(dp).max().getAsInt();
			
		return max;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {4,6,1,3,8,4,6};
		int n =MaxSumIncSubSeq(arr);
		System.out.println(n);
	}

}
