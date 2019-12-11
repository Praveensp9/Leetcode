package leetcode;

public class MaximumSumOfNonAdjancentElements {
	
	
	private static int maxSum(int[] arr) {
		
		int excl = 0;
		int incl = arr[0];
		
		for(int i=1;i<arr.length;i++) {
			int temp = incl;
			incl = Math.max(excl+arr[i], incl);
			excl = temp;
		}
		
		return incl;
	}
	
	private static int maxSumDynamicProgramming(int[] arr) {
		
		 	int n = arr.length;
	        int[] dp = new int[100005];
	        dp[0] = Math.max(0, arr[0]);
	        if(n == 1)
	            return dp[0];
	        dp[1] = Math.max(dp[0],arr[1]);
	        for(int i=2;i<n;i++) {
	            dp[i] = Math.max(dp[i-2], Math.max(dp[i-1],dp[i-2]+arr[i]));
	        }
	        
	        return Math.max(dp[n-2],dp[n-1]);

		
	}

	public static void main(String[] args) {
		
		int[] arr = new int[] {1,6,3,9,2};
		int ans = maxSum(arr);
		System.out.println(ans);
		
	}

}
