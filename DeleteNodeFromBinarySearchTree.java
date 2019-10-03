package leetcode;


public class DeleteNodeFromBinarySearchTree {
	

	static class TreeNode{
			
			int val;
			TreeNode left;
			TreeNode right;
			TreeNode(int x){
				this.val = x;
			}
			
		}

	private static TreeNode findMinimum(TreeNode root) {
		
		TreeNode parent = null;
		while(root.left != null) {
			parent = root;
			root = root.left;
		}
		
		parent.left= root.right;
		return parent;
	}
	
	private static TreeNode deleteNode(TreeNode root,int val) {
		if(root == null)
			return null;
		
		
		if( root.val > val) {
			root.left =  deleteNode(root.left,val);
			return root;
		}
		else if(root.val < val) {
			root.right =  deleteNode(root.right,val);
			return root;
		}
		
		if(root.left == null && root.right == null) {
			// case 1: When the node has no child 
			return null;
		}
		else if(root.left == null || root.right == null) {
			// case 2: When the node has only one child
			return (root.left!=null) ? root.left:root.right;
		}
		
		else {
			// case 3: when the node has both the child
			// root.val == val , This is the node to be deleted
			// find the minimum of the right subtree or maximum of left subtree of the node to be deleted
			
			if(root.right.left == null) {
				root.right.left = root.left;
				return root.right;
			}
			TreeNode curr = root;
			TreeNode  delete = findMinimum(curr.right);
			delete.right = root.right;
			delete.left = root.left;
			return delete;
			
		}
		
	}

	public static void main(String[] args) {

	}

}
 