package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15_3Sum {

	private static List<List<Integer>> ThreeSum(int[] arr) {
		
		List<List<Integer>> lst = new ArrayList<>();
		Arrays.sort(arr);
		
		for(int i=0;i<arr.length;i++) {
			
			if(i>0 && arr[i] == arr[i-1])
				continue;
			
			int s=i+1;
			int e=arr.length-1;
			
			while(s<e) {
				
				int sum = arr[i]+arr[s] + arr[e];
				if(sum>0)
					e--;
				else if(sum < 0)
					s++;
				else {
					
					lst.add(Arrays.asList(arr[i],arr[s],arr[e]));
				}
				
				while(s<e && arr[s] == arr[s+1])
					s++;
				while(s<e && arr[e] == arr[e-1])
					e--;
			s++;
			e--;
			}
		}
		
		return lst;
		
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {-1, 0, 1, 2, -1, -4};
		ThreeSum(arr);
	}

}
