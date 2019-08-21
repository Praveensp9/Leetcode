package leetcode;


public class PostOrderTraversalBinaryTree {
	
	static class TreeNode{
		
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			this.val = x;
		}
	}

	private static void postorder(TreeNode root) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		postorder(root);
	}

}
