package leetcode;

import java.util.Queue;
import java.util.LinkedList;

public class SymmetricTree {
	static class TreeNode{ 
		
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			this.val = x;
		} 
	}
	
	// Iterative Solution
	private static boolean helperIterative(TreeNode root) {
		 Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        q.add(root);
	        
	        while(!q.isEmpty()){
	            TreeNode l = q.poll();
	            TreeNode r = q.poll();
	            if( l == null && r == null) 
	                continue;
	            if(l == null || r == null)
	                return false;
	            
	            if(l.val != r.val)
	                return false;
	            
	            q.add(l.left);
	            q.add(r.right);
	            q.add(l.right);
	            q.add(r.left);
	        }
	        return true;
	}
	
	// Recursive Solution
	private static boolean helper(TreeNode l,TreeNode r) {
		
		if(l == null && r == null)
			return true;
		if(l == null || r == null)
			return false;
		
		if(l.val != r.val)
			return false;
		
		return helper(l.left,r.right) && helper(l.right, r.left);
		
	}
	private static boolean Symmetric(TreeNode root) {
		
		return helper(root,root);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two1  = new TreeNode(2);
		TreeNode two2  = new TreeNode(2);
		root.left = two1;
		root.right = two2;
		TreeNode three1  = new TreeNode(3);
		TreeNode three2  = new TreeNode(4);
		TreeNode four1  = new TreeNode(4);
		TreeNode four2  = new TreeNode(3);
		two1.left = three1;
		two1.right = three2;
		two2.left = four1;
		two2.right = four2;
		
		boolean ans = Symmetric(root);
		System.out.println(ans);
		
	}

}
