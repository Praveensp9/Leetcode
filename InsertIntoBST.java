package leetcode;


public class InsertIntoBST {
	
	static class TreeNode{
		
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			this.val = x;
		}
	}
	
	private static void insert(TreeNode root,int val) {
		
		TreeNode cur = root;
		TreeNode parent  = null;
		while(cur != null) {
			parent = cur;
			
			if(cur.val > val)
				cur = cur.left;
			else
				cur = cur.right;
			
		}
		if(parent.val > val)
			parent.left = new TreeNode(val);
		else
			parent.right = new TreeNode(val);
		
	}
	
	private static TreeNode insertIntoBST(TreeNode root, int val) {
		if(root == null)
			return new TreeNode(val);
		
		return root;
	}
	

	public static void main(String[] args) {
		
		TreeNode root = null;
		insertIntoBST(root,9);
	}

}
