package leetcode;

import java.util.HashSet;

public class LC41_FirstMissingPositive {
	
	// T.C : O(n) and S.C : O(n)
	private static int firstMissingPositive(int[] nums) {
		 HashSet<Integer> set = new HashSet<>();
		 for(int i:nums)
			 set.add(i);
		 int k=1;
		 while(set.contains(k))
				 k++;
		 
		 return k;
	 }
	
	// T.C : O(n) and S.C : O(1)
	private static int firstMissingPositiveBetter(int[] nums) {
		    
		int len = nums.length;
		int[] arr = new int[len+2];
		for(int n:nums) {
			if(n>0 && n<len)
				arr[n]++;
		}
			
		
		for(int i=1;i<len;i++)
			if(arr[i] == 0)
				return i;
		return 1;
	}

	public static void main(String[] args) {
		
		int[] nums = new int[] {1,2,4,7,8,9,10,11};
		System.out.println(firstMissingPositive(nums));
		System.out.println(firstMissingPositiveBetter(nums));
	}

}
