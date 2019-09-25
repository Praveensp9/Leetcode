package leetcode;

public class InOrderSuccessorBST {
	
	static class TreeNode {
	    public int val;
	    public TreeNode left;
	    public TreeNode right;

	    public TreeNode() {}

	    public TreeNode(int val,TreeNode left,TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	};
	
	private static TreeNode inOrderSuccessor(TreeNode root,TreeNode p) {
		
		TreeNode ans = null;
		
		while(root != null) {
			
			if( root.val > p.val) {
				ans = root;
				root=root.left;
			}
			else
				root=root.right;
		}
		return ans;
	}

	public static void main(String[] args) {

	}

}
