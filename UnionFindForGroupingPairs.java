package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnionFindForGroupingPairs {
	
	private static class UnionFind{
		
		int[] parent;
		int[] rank;
		
		private UnionFind(int n) {
			parent = new int[n];
			rank = new int[n];
			for(int i=0;i<n;i++)
			{
				parent[i] = i;
				rank[i]  = 1;
			}
		}
		
		private int find(int x) {
			if(parent[x] != x)
				parent[x] = find(parent[x]);
			return parent[x];
		}
		
		private void union(int x,int y) {
			
			
			int xp = find(x);
			int yp = find(y);
			
			if(xp == yp)
				return;
			if(rank[xp] < rank[yp]) {
				parent[xp] = yp;
				rank[yp]++;
			}
			else if(rank[xp] > rank[yp]) {
				parent[yp] = xp;
				rank[xp]++;
			}
			else
			{
				parent[yp] = xp;
				rank[xp]++;
			}
		}
	}
	
	
	private static List<List<Integer>> GroupPairs(int[][] pairs){
		
		int n = pairs.length;
		UnionFind uf = new UnionFind(n);
		
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int set=0;set<n;set++) {
			
			for(int val:pairs[set]) {
				if(map.containsKey(val))
					uf.union(set, map.get(val));
				else
					map.put(val,set);
			}
			
		}
		
		Map<Integer,List<Integer>> res = new HashMap<>();
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			int set = uf.find(entry.getValue());
			
			res.putIfAbsent(set, new ArrayList<>());
			res.get(set).add(entry.getKey());
		}
		
		return new ArrayList<>(res.values());
	}

	public static void main(String[] args) {
		
		 int[][] pairs = {{1,2},{3,4},{7,2},{5,12},{11,3},{9,7}};
	     System.out.println(GroupPairs(pairs));
	}

}
