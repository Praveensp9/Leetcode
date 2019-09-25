package leetcode;


public class LC98_ValidateBinarySearchTree {

	static class TreeNode{ 
		
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			this.val = x;
		} 
	}
	
	
	// Recursive Solution
	private static boolean validateBst(TreeNode root,Integer l,Integer r) {
		
		if(root == null)
			return true;
		
		int val = root.val;
		
		if(l != null) {
			
			if(val<=l)
				return false;
		}
		if(r != null) {
			
			if(val>=r)
				return false;
		}
		
		if(!validateBst(root.left,l,root.val))
			return false;
		if(!validateBst(root.right,root.val,r))
			return false;
		return true;
	}
	
	
	private static boolean isBST(TreeNode root) {
		return validateBst(root,null,null);
	}
	
	public static void main(String[] args) {


	}

}
