package leetcode;

import java.util.HashMap;

public class LC662_MaximumWidthOfBinaryTree {
	
	static class TreeNode{ 
		
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			this.val = x;
		} 
	}
	
	private static int max = 1;
	private static HashMap<Integer,Integer> map = new HashMap<>();
	private static void widthMax(TreeNode root,int level,int pos) {
		if(root == null) 
			return;
		
		if(map.containsKey(level)) {
			max = Math.max(pos-map.get(level)+1, max);
		}
		else
			map.put(level, pos);
		widthMax(root.left,level+1,2*pos-1);
		widthMax(root.right,level+1,2*pos);
		
	}
	
	private static int MaximumWidthBinaryTree(TreeNode root) {
		
		widthMax(root,1,1);
		return max;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		MaximumWidthBinaryTree(root);
	}

}
