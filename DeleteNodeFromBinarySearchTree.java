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
	
	private static TreeNode deleteNode(TreeNode root,int val) {
		if(root == null)
			return null;
		
		if(val > root.val) {
			root.right =  deleteNode(root.right,val);
			return root;
		}
		else if(val < root.val) {
			root.left =  deleteNode(root.left,val);
			return root;
		}
		
		if(root.left == null && root.right == null) {
			return null;
		}
		else if(root.left == null || root.right == null) {
			return (root.left!=null) ? root.left:root.right;
		}
		
		return root;
	}

	public static void main(String[] args) {

	}

}
 