package leetcode;

import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveIntegerNotInArray_LC41 {
	
	private static int FirstMissingPositive(int[] arr) {
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i: arr)
			set.add(i);
		
		int k=1;
		for( k =1;k<=arr.length;k++) {
			if(set.contains(k))
			 continue;
			else
				 return k;
		}
		
		return 0;
	}

	public static void main(String[] args) {
	
		int[] arr = new int[] {1,3,6,4,2};
		int n = FirstMissingPositive(arr);
		System.out.println(n);
	}

}
