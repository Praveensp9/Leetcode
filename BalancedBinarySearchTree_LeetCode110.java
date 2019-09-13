package leetcode;


public class BalancedBinarySearchTree_LeetCode110 {
	
	static class TreeNode{ 
		
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			this.val = x;
		} 
	}
	
	private static int height_bst(TreeNode root) {
		
		if(root == null)
			return 0;
		else
			return Math.max(height_bst(root.left),height_bst(root.right))+1;
	}
	
	private static boolean isBalanced(TreeNode root) {
		
		if(root == null)
			return true;
		else
		{
			int left_height = height_bst(root.left);
			int right_height = height_bst(root.right);
			
			int val = Math.abs(right_height - left_height);
			return (val<=1 && isBalanced(root.left) && isBalanced(root.right));
		}
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(9);
		root.left = new TreeNode(10);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(3);
		boolean balanced = isBalanced(root);
		System.out.println(balanced);
	}

}
