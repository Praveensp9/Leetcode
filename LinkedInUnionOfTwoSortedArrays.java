package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LinkedInUnionOfTwoSortedArrays {
	
	private static List<Integer> union(List<Integer> a,List<Integer> b) {
		int l1 = a.size();
		int l2 = b.size();
		
		int i = 0;
		int j = 0;
		
		List<Integer> ret = new ArrayList<Integer>();
		
		while (i < l1 && j < l2) {
			
			if (a.get(i) == b.get(j)) {
				ret.add(a.get(i));
				i++;
				j++;
			} 
			else if (a.get(i) < b.get(j)) {
				ret.add(a.get(i++));
			} else {
				ret.add(b.get(j++));
			}
		}
		while (i < l1) {
			ret.add(a.get(i++));
		}
		while (j < l2) {
			ret.add(b.get(j++));
		}
		return ret;
	}

	public static void main(String[] args) {
		
		List<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(6);
		
		List<Integer> b = new ArrayList<>();
		b.add(1);
		b.add(2);
		b.add(3);
		b.add(7);
		b.add(8);
		b.add(9);
		
		List<Integer> res = union(a,b);
		System.out.print(res);
	}

}
