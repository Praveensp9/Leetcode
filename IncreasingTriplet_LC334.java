package leetcode;

public class IncreasingTriplet_LC334 {
	
	private static boolean triplet(int[] nums) {
		
		int min=Integer.MAX_VALUE;
		int max=Integer.MAX_VALUE;
		
		for(int i=0;i<nums.length;i++) {
			int m=0;
			
			if(nums[i] > max) {
				System.out.print("start" + m+ " ");
				System.out.print("end :" + i+ " ");
				return true;
			}
			else if(nums[i] <= min) {
				
				if(i>0 && nums[i] < nums[i-1])
					m=i;
				min = nums[i];
				
			}
			else
				max = nums[i];
			
		}
		
		return false;
	}

	public static void main(String[] args) {
		int[] res = new int[] {7,4,1,5,7,8,6};
		boolean ans = triplet(res);
		System.out.println(ans);
	}

}
