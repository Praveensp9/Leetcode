package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18_KSum {
	
	
	 private static void kSum(int[] nums, int target, int index, int k, List<List<Integer>> res, List<Integer> temp) {
	        if (index == nums.length && target == 0) {
	            res.add(new ArrayList<Integer>(temp));
	            return;
	        }
	        if (k == 2) {
	            int left = index;
	            int right = nums.length - 1;
	            int sum = 0;
	            while (left < right) {
	                sum = nums[left] + nums[right];
	                if (sum == target) {
	                    temp.add(nums[left]);
	                    temp.add(nums[right]);
	                    kSum(nums, 0, nums.length, 0, res, temp);
	                    temp.remove(temp.size() - 1);
	                    temp.remove(temp.size() - 1);
	                    left++;
	                    right--;
	                    while (left < right && nums[left] == nums[left - 1]) left++;
	                    while (left < right && nums[right] == nums[right + 1]) right--;
	                } else if (sum > target) {
	                    right--;
	                } else {
	                    left++;
	                }
	            }
	        } else {
	            for (int i = index; i < nums.length - k + 1; i++) {
	                if (i > index && nums[i] == nums[i - 1]) continue;
	                temp.add(nums[i]);
	                kSum(nums, target - nums[i], i + 1, k - 1, res, temp);
	                temp.remove(temp.size() - 1);
	            }
	        }
	    } 

	
	private static List<List<Integer>> FourSum(int[] nums,int target){
		
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        if (nums.length == 0) 
            return res;
        
        kSum(nums, target, 0, 4, res, temp);
        return res;
	}

	
	private static List<List<Integer>> ThreeSum(int[] nums,int target){
		
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        if (nums.length == 0) 
            return res;
        
        kSum(nums, target, 0, 3, res, temp);
        return res;
	}


	public static void main(String[] args) {
		int[] arr = new int[] {1, 0, -1, 0, -2, 2};
		System.out.println(FourSum(arr,0));
		System.out.print(ThreeSum(arr,0));
		
	}

}
