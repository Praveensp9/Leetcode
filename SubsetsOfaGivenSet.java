package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubsetsOfaGivenSet {
	
	private static void subsetUtil(int[] arr,List<List<Integer>> res,List<Integer> lst,int i) {
		
		if(i == arr.length) {
			if(!res.contains(lst))
				res.add(new ArrayList<>(lst));
			return;
		}
		
		subsetUtil(arr,res,lst,i+1);
		lst.add(arr[i]);
		subsetUtil(arr,res,lst,i+1);
		lst.remove(lst.size()-1);
	}
	
	private static List<List<Integer>> subset(int[] arr) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> lst = new ArrayList<>();
		
		subsetUtil(arr,res,lst,0);
		return res;
	}

	public static void main(String[] args) {
		List<List<Integer>> lst = subset(new int[] {1,2,2});
		
		System.out.println(lst);

	}

}
