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
		
		
		int sum = arr[0];
		int max =arr[0];
		int currentStart = 0;
		int maxStart = 0;
        int maxEnd = 0;
		for(int i=1;i<arr.length;i++) {
			sum = sum+arr[i];
			
			if(sum<arr[i]) {
				sum=arr[i];
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
		
		int[] arr  = new int[] {-5,-10,3,2,-5,-8,-4};
		System.out.println(dpMaxSubSum(arr));
		System.out.println(maxSubSum(arr));
	}

}
