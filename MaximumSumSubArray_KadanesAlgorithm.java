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
		
		return max;
	}
	
	private static int maximumSumByRemovingOneElement(int[] arr) {
		
		int n = arr.length;
		int[] forwardSum = new int[n];
		int[] backwardSum = new int[n];
		
		int max = arr[0];
		int curMax = arr[0];
		
		forwardSum[0] = arr[0];
		for(int i=1;i<n;i++) {
			
			curMax = Math.max(arr[i], curMax+arr[i]);
			max = Math.max(max, curMax);
			
			forwardSum[i] = curMax;
			
		}
		
		curMax = arr[n-1];
		max = arr[n-1];
		backwardSum[n-1] = arr[n-1];
		
		for(int i=n-2;i>=0;i--) {
			
			curMax = Math.max(arr[i], curMax+arr[i]);
			max = Math.max(max,curMax);
			
			backwardSum[i] = curMax;
		}
		
		int result = max;
		
		for(int i=0;i<n;i++) {
			System.out.print(forwardSum[i] +"     ");
		}
		System.out.println();
		for(int i=0;i<n;i++) { 
			System.out.print(backwardSum[i] + "      ");
		}
		System.out.println();
		for(int i=1;i<n-1;i++)
			result = Math.max(result, forwardSum[i-1]+backwardSum[i+1]);
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int[] arr  = new int[] {-5,-10,3,2,-5,-8,-4};
		
		System.out.println(dpMaxSubSum(arr));
		System.out.println(maxSubSum(arr));
		
		
		int[] arr1  = new int[] {-2,-3,4,-1,-2,1,5,-3};
		int sum = maximumSumByRemovingOneElement(arr1);
		
		System.out.println(sum);
	}

}
