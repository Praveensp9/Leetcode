package leetcode;


public class LowestCommonAncestor {
	
static class TreeNode{
		
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			this.val = x;
		}
	}
	
	
	private static int LowestCommonAncestorBST(TreeNode root,TreeNode p,TreeNode q) {
		
		int ancestor = root.val;
		
		if(p.val<ancestor && q.val<ancestor)
			return LowestCommonAncestorBST(root.left,p,q);
		else if(p.val>ancestor && q.val > ancestor)
			return LowestCommonAncestorBST(root.right,p,q);
		else
			return root.val;

	}
	
	// One solution for the binary tree problem is 
	// Find all the nodes in the path of the gives two nodes
	// example   3
	//			/ \
	//	       6   8
	//	      / \   \          2,5 == > 6
	//	     2  11   13        2 -- > 3,6,2
	//	       /  \   /        5 -- > 3,6,11,5
	//	      9    5  7
	
	// Other Solution is given below with T.C : O(n) and S.C: O(1)
	private static TreeNode LowestCommonAncestorBT(TreeNode root,TreeNode p,TreeNode q) {
		
		
		if(root == null)
			return null;
		
		if(root == p || root==q)
			return root;
		
		TreeNode left = LowestCommonAncestorBT(root.left,p,q);
		TreeNode right = LowestCommonAncestorBT(root.right,p,q);
		if(left !=null && right != null)
			return root;
		
		return left!= null ? left:right;
	}
	
	public static void main(String[] args) {
		
		
		TreeNode root = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		TreeNode eight = new TreeNode(8);
		root.left = six;
		root.right = eight;
		LowestCommonAncestorBST(root,six,eight);
		LowestCommonAncestorBT(root,six,eight);
		
	}

}
