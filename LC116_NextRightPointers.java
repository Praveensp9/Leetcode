package leetcode;

public class LC116_NextRightPointers {
	
	static class TreeNode {
	    public int val;
	    public TreeNode left;
	    public TreeNode right;
	    public TreeNode next;

	    public TreeNode() {}

	    public TreeNode(int val,TreeNode left,TreeNode right,TreeNode next) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	        this.next = next;
	    }
	};
	
	private static TreeNode connect(TreeNode root) {
		
		TreeNode head = root;
		
		TreeNode dummy = new TreeNode();
		TreeNode prev = dummy;
		
		while(root != null) {
			
			if(root.left != null) {
				prev.next = root.left;
				prev = prev.next;
			}
			if(root.right != null) {
				prev.next = root.right;
				prev = prev.next;
			}
			
			root = root.next;
			
			if(root == null) {
				prev=  dummy;
				root = dummy.next;
				dummy.next = null;
			}
			
		}
		
		return head;
		
	}
	
	private static void bfs(TreeNode root) {
		if(root == null)
			return;
		if(root.left != null) {
			root.left.next = root.right;
			if(root.next != null)
				root.right.next = root.next.left;
			bfs(root.left);
			bfs(root.right);
		}
	}
	
	private static TreeNode connectRecursive(TreeNode root) {
		 bfs(root);
		 return root;
	}

	public static void main(String[] args) {

	}

}
