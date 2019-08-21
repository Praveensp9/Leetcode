package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationsUsingDFS {
	
	private static void permute(List<Integer> n,List<Integer> c,List<List<Integer>> lst) {
		if(n.size() == 0) {
			lst.add(new ArrayList<>(c));
			return;
		}
		
		for(int i=0;i<n.size();i++) {
			int val = n.get(i);
			c.add(val);
			n.remove(i);
			permute(n,c,lst);
			n.add(i,val);
			c.remove(c.size()-1);
		}
	}
	
	
	

	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3};
		List<List<Integer>> lst = new ArrayList<>();
        List<Integer> n = new ArrayList<>();
        for(int i:nums)
            n.add(i);
        List<Integer> c = new ArrayList<>();
		permute(n,c,lst);
	}

}
