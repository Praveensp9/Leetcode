package leetcode;

public class MaximumSumSubArray_KadanesAlgorithm {
	
	// T.C : O(n)
	
	// Dynamic Programming
	
	private static int dpMaxSubSum(int[] arr) {
		
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		int max = arr[0];
		for(int i=1;i<arr.length;i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
			max=Math.max(dp[i], max);
		}
		return max;
	}
	
	// Kadane's Algorithm
	
	private static int maxSubSum(int[] arr) {
		
		
		int sum = 0;
		int max =0;
		int currentStart = 0;
		int maxStart = -1;
        int maxEnd = -1;
		for(int i=0;i<arr.length;i++) {
			sum = sum+arr[i];
			
			if(sum<0) {
				sum=0;
				currentStart = i+1;
			}
			if(max<sum) {
				max = sum;
				maxStart = currentStart;
                maxEnd = i;
			}
		}
		
		System.out.println(maxStart+" "+maxEnd);
		return max;
	}

	public static void main(String[] args) {
		
		int[] arr  = new int[] {-2,1,3,1,-1,2,1,-5,4};
		System.out.println(dpMaxSubSum(arr));
		System.out.println(maxSubSum(arr));
	}

}
