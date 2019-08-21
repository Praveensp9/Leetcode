package leetcode;

public class MaximumSumSubArray {
	private static int end =0;
	private static int start = 0;
	
	private static int maxSubArrayKadanesAlgorithm(int[] nums) {
        
	    //kadane's Algorithm
		
		int max = nums[0];
		int sum = nums[0];
		int cnt =0;
		for(int i=1;i<nums.length;i++) {
			
			sum = sum + nums[i];
			if(sum < nums[i]) {
				sum = nums[i];
				start = i;
				end = i;
				cnt = 0;
			}
			if(max < sum) {
				max = sum;
			}
			cnt++;
		}
		

		return max;
	}
	
	private static int maxSubArray(int[] nums) {
        
	    //Dynamic Programming Solution
		int[] dp = new int[nums.length];
		int max = nums[0];
		dp[0] = nums[0];
		
		for(int i=1;i<nums.length;i++) {
			
			dp[i] = Math.max( dp[i-1]+nums[i] ,nums[i]);
			max  = Math.max(max, dp[i]); 
		}
	      
	      
		return max;
	}

	public static void main(String[] args) {
		
		int[] arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		int sum = maxSubArray(arr);
		System.out.println(sum);
		System.out.println();
		int sum2=maxSubArrayKadanesAlgorithm(arr);
		System.out.println(sum2);
		System.out.println(start + " , "+ end);

	}

}
