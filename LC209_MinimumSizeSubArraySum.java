package leetcode;

public class LC209_MinimumSizeSubArraySum {
	
	private static int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            while(sum >= s){
                min = Math.min(min,i+1-left);
                sum = sum-nums[left++];
            }
        }
        
        return min;
    }
	public static void main(String[] args) {
		int ans = minSubArrayLen(7,new int[] {2,3,1,2,4,3});
		System.out.print(ans);

	}

}
