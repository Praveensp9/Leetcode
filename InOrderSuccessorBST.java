package leetcode;

public class InOrderSuccessorBST {
	
	static class TreeNode {
	    public int val;
	    public TreeNode left;
	    public TreeNode right;

	    public TreeNode() {}

	    public TreeNode(int val) {
	        this.val = val;
	  
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
	
	private static TreeNode inOrderPredecessor(TreeNode root,TreeNode p) {
		
		TreeNode ans = null;
		
		while(root != null) {
			
			if( root.val < p.val) {
				ans = root;
				root=root.right;
			}
			else
				root=root.left;
		}
		return ans;
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
		
		insert(root,val);
		return root;
	}
	

	public static void main(String[] args) {
		
		TreeNode root= new TreeNode();
		
		root = insertIntoBST(root,9);
		root = insertIntoBST(root,5);
		root = insertIntoBST(root,16);
		root = insertIntoBST(root,4);
		root = insertIntoBST(root,13);
		root = insertIntoBST(root,2);
		root = insertIntoBST(root,3);
		
		
		TreeNode successor = inOrderSuccessor(root,new TreeNode(13));
		System.out.println(successor.val);
		
		TreeNode predessor = inOrderPredecessor(root,new TreeNode(13));
		System.out.println(predessor.val);

	}

}
