package leetcode;

import java.util.TreeMap;

/**
 * @author Praveen Patil
 *
 */
public class TreeMapHigherKeyApplication_LC870 {

	/**
	 * @param args
	 */
	
	
	private static int[] shuffle(int[] a, int[] b) {
		
		TreeMap<Integer,Integer> treemap = new TreeMap<>();
		for(int i:a) {
			treemap.put(i, treemap.getOrDefault(i,0)+1);
		}
		
		int[] ans = new int[a.length];
		for(int i=0;i<b.length;i++) {
			
			Integer key = treemap.higherKey(b[i]);
			if(key == null)
				ans[i] = -1;
			else {
				
				ans[i] = key;
				treemap.put(key,treemap.get(key)-1);
				if(treemap.get(key) == 0)
					treemap.remove(key);
			}
			
		}
		for(int i=0;i<ans.length;i++) {
			
			if(ans[i] == -1) {
				 	int firstKey = treemap.firstKey();
	                ans[i] = firstKey;
	                treemap.put(firstKey, treemap.get(firstKey) - 1);
	                if (treemap.get(firstKey) == 0) treemap.remove(firstKey);
			}
		}
		
		
		return ans;
	}
	public static void main(String[] args) {
	
		int[] res = shuffle(new int[] {2,7,13,15},new int[] {13,15,32,11});
		for(int i:res)
			System.out.print(i+" ");
	}

}
