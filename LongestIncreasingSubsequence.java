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
				// Odd Increasing Subsequence : arr[j] < arr[i]  && arr[j]%2!=0 && arr[i]%2 !=0
				// Odd Even Increasing Subsequnce : arr[j] < arr[i]  && (arr[i]+arr[j]) %2!=0
				// Even Increasing Subsequence : arr[j] < arr[i]  && (arr[i]+arr[j]) %2==0
				if(arr[j] < arr[i]  && (arr[i]+arr[j]) %2==0)
					dp[i] = Math.max(dp[i],dp[j]+1);
			}
		}
		
		return Arrays.stream(dp).max().getAsInt();
	}

	public static void main(String[] args) {
			int[] arr = new int[] {1, 12, 2, 22, 5, 30, 31, 14, 17, 11};
			int n =lis(arr);
			System.out.println(n);
	}

}
