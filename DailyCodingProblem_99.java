package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DailyCodingProblem_99 {
	
	// Other Solutions are Brute force ( O(n^3) ) and
	// Sorting ( O(nlogn) )
	
	// O(n) solution using HashSet
	private static int longest_consecutive_sequence(int[] nums) {
		
		//Set<Integer> set  =new HashSet<Integer>(Arrays.asList(nums));
		//set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
		
		Set<Integer> set  =new HashSet<Integer>();
		for(int i:nums)
			set.add(i);
		
		int max =0 ;
		for(int i:set) {
			
			if(!set.contains(i-1)) {
				int cur = i;
				int cnt = 1;
				while(set.contains(cur+1)) {
					cur = cur +1;
					cnt = cnt+1;
				}
				max = Math.max(max,cnt);
			}
		}
		return max;
		
	}

	public static void main(String[] args) {
		
		int[] nums = new int[] {100,1,200,4,3,2};
		int len = longest_consecutive_sequence(nums);
		System.out.println(len);
	}

}
